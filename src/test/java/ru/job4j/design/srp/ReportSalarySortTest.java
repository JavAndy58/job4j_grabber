package ru.job4j.design.srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Ignore;
import org.junit.Test;
import java.util.Calendar;

public class ReportSalarySortTest {

    @Ignore
    @Test
    public void whenSalarySortHtmlGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 200);
        store.add(worker);
        Report engine = new ReportHTML(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}
