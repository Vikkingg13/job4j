package ru.job4j.design.srp;

import java.io.FileWriter;
import java.io.IOException;
import java.util.StringJoiner;
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

    @Override
    public String generateToXML(Predicate<Employee> filter) {
        String result = "";
        try (FileWriter writer = new FileWriter("employees_finance.xml")) {
            String ln = System.lineSeparator();
            StringJoiner joiner = new StringJoiner(System.lineSeparator());
            for (Employee employee : store.findBy(filter)) {
                String name = employee.getName();
                String hired = employee.getHired().getTime().toString();
                String fired = employee.getFired().getTime().toString();
                String salary = String.format("%.2f", employee.getSalary());
                joiner.add("   <employee>")
                        .add("      <name>" + name + "</name>")
                        .add("      <hired>" + hired + "</hired>")
                        .add("      <fired>" + fired + "</fired>")
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
        try (FileWriter writer = new FileWriter("employees_finance.json")) {
            String ln = System.lineSeparator();
            StringJoiner joiner = new StringJoiner(",");
            for (Employee employee : store.findBy(filter)) {
                String name = employee.getName();
                long hired = employee.getHired().getTimeInMillis();
                long fired = employee.getFired().getTimeInMillis();
                String salary = String.format("%.2f", employee.getSalary());
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
                                "\"hired\":"  + hired + ","
                                +
                                ln
                                +
                                "\"fired\":" + fired + ","
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
            result =
                    "["
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
        try (FileWriter writer = new FileWriter("employees_finance.html")) {
            StringBuilder builder = new StringBuilder();
            for (Employee employee : store.findBy(filter)) {
                String name = employee.getName();
                String hired = employee.getHired().getTime().toString();
                String fired = employee.getFired().getTime().toString();
                double salary = employee.getSalary();
                String row = String.format("<tr><td>%s</td><td>%s</td><td>%s</td><td>%.2f</td></tr>",
                        name, hired, fired, salary);
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
            writer.write(result);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
