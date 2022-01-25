package ru.job4j.design.srp;

import java.util.Comparator;
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


//        List<Employee> employees = store.findBy(filter);
//        employees.sort(Comparator.comparingDouble(Employee::getSalary).reversed());


        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
