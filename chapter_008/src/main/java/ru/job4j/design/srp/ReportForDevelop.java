package ru.job4j.design.srp;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.StringJoiner;
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

    @Override
    public String generateToXML(Predicate<Employee> filter) {
        String result = "";
        try (FileWriter writer = new FileWriter("employees_develop.xml")) {
            String ln = System.lineSeparator();
            StringJoiner joiner = new StringJoiner(System.lineSeparator());
            for (Employee employee : store.findBy(filter)) {
                String name = employee.getName();
                String hired = employee.getHired().getTime().toString();
                String fired = employee.getFired().getTime().toString();
                double salary = employee.getSalary();
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
        try (FileWriter writer = new FileWriter("employees_develop.json")) {
            String ln = System.lineSeparator();
            StringJoiner joiner = new StringJoiner(",");
            for (Employee employee : store.findBy(filter)) {
                String name = employee.getName();
                long hired = employee.getHired().getTimeInMillis();
                long fired = employee.getFired().getTimeInMillis();
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
        return generate(filter);
    }
}