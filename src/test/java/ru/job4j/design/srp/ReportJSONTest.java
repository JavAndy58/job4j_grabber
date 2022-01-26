package ru.job4j.design.srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.Calendar;

public class ReportJSONTest {

    @Test
    public void whenJSONGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportJSON(store);

        StringBuilder expect = new StringBuilder().append("[{")
                .append("\"").append("name").append("\"").append(":")
                .append("\"").append(worker.getName()).append("\",")
                .append("\"").append("hired").append("\"").append(":");



        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}
