package ru.job4j.design.srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ReportJSONTest {

    @Test
    public void whenJSONGenerated() {
        MemStore store = new MemStore();
        Calendar now = new GregorianCalendar(2022, 01, 27);
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportJSON(store);
        StringBuilder expect = new StringBuilder()
                .append("[{\"name\":\"Ivan\",\"hired\":{\"year\":2022,\"month\":1,\"dayOfMonth\":27,\"hourOfDay\":0,"
                        + "\"minute\":0,\"second\":0},\"fired\":{\"year\":2022,\"month\":1,\"dayOfMonth\":27,"
                        + "\"hourOfDay\":0,\"minute\":0,\"second\":0},\"salary\":100.0}]");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}
