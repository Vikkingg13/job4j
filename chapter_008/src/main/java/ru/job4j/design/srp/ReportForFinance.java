package ru.job4j.design.srp;

import java.io.FileWriter;
import java.io.IOException;
import java.util.function.Predicate;

public class ReportForFinance implements Report {
    private Store store;

    public ReportForFinance(Store store) {
        this.store = store;
    }

    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary; ");
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(String.format("%.2f", employee.getSalary())).append(";");
        }
        return text.toString();
    }
}
