package ru.job4j.design.srp;

import com.google.gson.GsonBuilder;

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
        text = lib.toJson(employees);
        return text;
    }
}
