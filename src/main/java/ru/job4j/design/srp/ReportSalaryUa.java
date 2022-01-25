package ru.job4j.design.srp;

import java.util.function.Predicate;

public class ReportSalaryUa implements Report {

    private Store store;
    private final double greatBritishPound;

    public ReportSalaryUa(Store store) {
        this.store = store;
        greatBritishPound = 100;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary").append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary() / greatBritishPound).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}