package ru.job4j.design.srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Ignore;
import org.junit.Test;

import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.TimeZone;

public class ReportHTMLTest {

    @Ignore
    @Test
    public void whenHtmlGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 200);
        now.setTimeZone(TimeZone.getTimeZone(ZoneOffset.of("+3")));
        store.add(worker);
        Report engine = new ReportHTML(store);
        StringBuilder expect = new StringBuilder()
                .append("<html>").append(System.lineSeparator())
                .append("<body>").append(System.lineSeparator())
                .append("<h>Name; Hired; Fired; Salary</h>")
                .append(System.lineSeparator())
                .append("<p>").append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append("</p>").append(System.lineSeparator())
                .append("</body>").append(System.lineSeparator())
                .append("</html>").append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}
