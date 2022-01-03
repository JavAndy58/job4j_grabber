package ru.job4j.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;

public class AlertRabbit {

    public static void main(String[] args) throws Exception {
        Properties properties = propertiesInit();
        int intInit = Integer.parseInt(properties.getProperty("rabbit.interval"));
        int intSleep = Integer.parseInt(properties.getProperty("rabbit.sleep"));
        try (Connection connection = connectionInit(properties)) {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
            JobDataMap data = new JobDataMap();
            data.put("connection", connection);
            JobDetail job = newJob(Rabbit.class)
                    .usingJobData(data)
                    .build();
            SimpleScheduleBuilder times = simpleSchedule()
                    .withIntervalInSeconds(intInit)
                    .repeatForever();
            Trigger trigger = newTrigger()
                    .startNow()
                    .withSchedule(times)
                    .build();
            scheduler.scheduleJob(job, trigger);
            Thread.sleep(intSleep);
            scheduler.shutdown();
        } catch (SchedulerException | InterruptedException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static Properties propertiesInit() throws Exception {
        try (InputStream in = AlertRabbit.class.getClassLoader().getResourceAsStream("rabbit.properties")) {
            Properties config = new Properties();
            config.load(in);
            return config;
        }
    }

    public static Connection connectionInit(Properties properties) throws Exception {
        Class.forName(properties.getProperty("driver-class-name"));
        return DriverManager.getConnection(
                properties.getProperty("url"),
                properties.getProperty("username"),
                properties.getProperty("password")
        );
    }

    public static class Rabbit implements Job {

        @Override
        public void execute(JobExecutionContext context) {
            Connection cn = (Connection) context.getJobDetail().getJobDataMap().get("cn");
            try (PreparedStatement statement =
                    cn.prepareStatement("insert into rabbit(created_date) values (?)",
                            Statement.RETURN_GENERATED_KEYS)) {
                statement.setTimestamp(1, Timestamp.valueOf(String.valueOf(System.currentTimeMillis())));
                statement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}