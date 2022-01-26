package ru.job4j.design.srp;

import com.google.gson.GsonBuilder;

import java.util.Calendar;
import java.util.function.Predicate;

public class ReportJSON implements Report {

    private Store store;

    public ReportJSON(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        String text;
        var employees = store.findBy(filter);
        var lib = new GsonBuilder().create();
        return lib.toJson(employees);
    }


    public static void main(String[] args) {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Petr", now, now, 500);
        store.add(worker1);
        store.add(worker2);
        Report engine = new ReportJSON(store);
        System.out.println(engine.generate(em -> true));


    }
}
