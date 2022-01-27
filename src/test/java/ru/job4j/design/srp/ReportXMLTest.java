package ru.job4j.design.srp;

import java.time.ZoneOffset;
import java.util.*;
import java.util.function.Predicate;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ReportXMLTest {

    @Test
    public void whenXMLGenerated() {
        MemStore store = new MemStore();
        Calendar now = new GregorianCalendar(2022, 01, 27);
        now.setTimeZone(TimeZone.getTimeZone(ZoneOffset.of("+3")));
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportXML(store);
        StringBuilder expect = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>").append("\n")
                .append("<employees>").append("\n").append("    ")
                .append("<employees>").append("\n").append("        ")
                .append("<fired>2022-02-27T00:00:00+03:00</fired>").append("\n").append("        ")
                .append("<hired>2022-02-27T00:00:00+03:00</hired>").append("\n").append("        ")
                .append("<name>Ivan</name>").append("\n").append("        ")
                .append("<salary>100.0</salary>").append("\n").append("    ")
                .append("</employees>").append("\n")
                .append("</employees>").append("\n");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}
