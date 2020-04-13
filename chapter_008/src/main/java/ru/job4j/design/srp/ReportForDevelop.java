package ru.job4j.design.srp;

import java.io.FileWriter;
import java.io.IOException;
import java.util.function.Predicate;

public class ReportForDevelop implements Report {
    private Store store;

    public ReportForDevelop(Store store) {
        this.store = store;
    }

    public String generate(Predicate<Employee> filter) {
        String html = "";
        try (FileWriter writer = new FileWriter("employees.html")) {
            StringBuilder builder = new StringBuilder();
            for (Employee employee : store.findBy(filter)) {
                String name = employee.getName();
                String hired = employee.getHired().getTime().toString();
                String fired = employee.getFired().getTime().toString();
                double salary = employee.getSalary();
                String row = String.format("<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>",
                        name, hired, fired, salary);
                builder.append(row);
            }
            html = String.format("<html>"
                    +
                    "<body>"
                    +
                    "<table border=1>"
                    +
                    "<tr>"
                    +
                    "<th>Name</th>"
                    +
                    "<th>Hired</th>"
                    +
                    "<th>Fired</th>"
                    +
                    "<th>Salary</th>"
                    +
                    "%s"
                    +
                    "</tr>"
                    +
                    "</body>"
                    +
                    "</html>", builder.toString());
            writer.write(html);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return html;
    }
}
