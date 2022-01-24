package ru.job4j.design.srp;

import java.util.List;
import java.util.function.Predicate;

public class ReportSalarySort implements Report {

    private Store store;

    public ReportSalarySort(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary").append(System.lineSeparator());
        List<Employee> employees = store.findBy(filter);
        employees.sort((o1, o2) -> (int) (o1.getSalary() - o2.getSalary()));
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
