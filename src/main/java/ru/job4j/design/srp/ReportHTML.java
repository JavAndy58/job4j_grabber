package ru.job4j.design.srp;

import java.util.function.Predicate;

public class ReportHTML implements Report {

    private Store store;

    public ReportHTML(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<html>").append(System.lineSeparator());
        text.append("<body>").append(System.lineSeparator());
        text.append("<h>Name; Hired; Fired; Salary</h>").append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append("<p>").append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append("</p>").append(System.lineSeparator());
        }
        text.append("</body>").append(System.lineSeparator());
        text.append("</html>").append(System.lineSeparator());
        return text.toString();
    }
}
