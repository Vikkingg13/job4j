package ru.job4j.design.srp;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.Predicate;

public class ReportForHR implements Report {
    private Store store;

    public ReportForHR(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary; ");
        List<Employee> list = store.findBy(filter);
        list.sort(Comparator.comparing(Employee::getSalary, Comparator.reverseOrder()));
        for (Employee employee : (list)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";");
        }
        return text.toString();
    }

    @Override
    public String generateToXML(Predicate<Employee> filter) {
        String result = "";
        try (FileWriter writer = new FileWriter("employees_hr.xml")) {
            String ln = System.lineSeparator();
            StringJoiner joiner = new StringJoiner(System.lineSeparator());
            List<Employee> employees =
                    store.findBy(filter);
            employees.sort(Comparator.comparing(Employee::getSalary).reversed());
            for (Employee employee : employees) {
                String name = employee.getName();
                double salary = employee.getSalary();
                joiner.add("   <employee>")
                        .add("      <name>" + name + "</name>")
                        .add("      <salary>" + salary + "</salary>")
                        .add("   </employee>");
            }
            result =
                    "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
                            +
                            ln
                            +
                            "<employees>"
                            +
                            ln
                            +
                            joiner.toString()
                            +
                            ln
                            +
                            "</employees>";
            writer.write(result);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public String generateToJSON(Predicate<Employee> filter) {
        String result = "";
        try (FileWriter writer = new FileWriter("employees_hr.json")) {
            String ln = System.lineSeparator();
            StringJoiner joiner = new StringJoiner(",");
            List<Employee> employees =
                    store.findBy(filter);
            employees.sort(Comparator.comparing(Employee::getSalary).reversed());
            for (Employee employee : employees) {
                String name = employee.getName();
                double salary = employee.getSalary();
                String row = ln
                                 +
                                "{"
                                +
                                ln
                                +
                                "\"name\":" + "\"" + name + "\","
                                +
                                ln
                                +
                                "\"salary\":" + salary
                                +
                                ln
                                +
                                "}"
                                +
                                ln;
                joiner.add(row);
            }
            result = "["
                    +
                    joiner.toString()
                    +
                    "]";
            writer.write(result);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public String generateToHTML(Predicate<Employee> filter) {
        String result = "";
        try (FileWriter writer = new FileWriter("employees_hr.html")) {
            StringBuilder builder = new StringBuilder();
            List<Employee> employees =
                    store.findBy(filter);
            employees.sort(Comparator.comparing(Employee::getSalary).reversed());
            for (Employee employee : employees) {
                String name = employee.getName();
                double salary = employee.getSalary();
                String row = String.format("<tr><td>%s</td><td>%s</td></tr>",
                        name, salary);
                builder.append(row);
            }
            result = String.format("<html>"
                    +
                    "<body>"
                    +
                    "<table border=1>"
                    +
                    "<tr>"
                    +
                    "<th>Name</th>"
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
            writer.write(result);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
