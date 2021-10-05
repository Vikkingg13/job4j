package ru.job4j.design.srp;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringJoiner;

import static org.junit.Assert.assertEquals;

public class ReportForDevelopTest {
    private Employee mishail = new Employee("Mishail",
            new GregorianCalendar(2001, Calendar.SEPTEMBER, 28),
            new GregorianCalendar(2005, Calendar.MAY, 13),
            700.50);
    private Employee oleg = new Employee("Oleg",
            new GregorianCalendar(2003, Calendar.NOVEMBER, 8),
            new GregorianCalendar(2005, Calendar.JANUARY, 7),
            750.00);
    private Employee viktor = new Employee("Viktor",
            new GregorianCalendar(2020, Calendar.MAY, 3),
            new GregorianCalendar(2023, Calendar.JULY, 14),
            1050.50);
    private Employee sergey = new Employee("Sergey",
            new GregorianCalendar(1990, Calendar.NOVEMBER, 1),
            new GregorianCalendar(1994, Calendar.JANUARY, 7),
            800);

    @Test
    public void testGenerateHTMLReport() throws IOException {
        MemStore store = new MemStore();
        store.add(mishail);
        store.add(oleg);
        store.add(viktor);
        store.add(sergey);
        Report report = new ReportForDevelop(store);
        StringBuilder expected = new StringBuilder();
        expected.append("<html>")
                .append("<body>")
                .append("<table border=1>")
                .append("<tr>")
                .append("<th>Name</th>")
                .append("<th>Hired</th>")
                .append("<th>Fired</th>")
                .append("<th>Salary</th>")
                .append("<tr>")
                .append("<td>" + sergey.getName() + "</td>")
                .append("<td>" + sergey.getHired().getTime() + "</td>")
                .append("<td>" + sergey.getFired().getTime() + "</td>")
                .append("<td>" + sergey.getSalary() + "</td>")
                .append("</tr>")
                .append("</tr>")
                .append("</body>")
                .append("</html>");
        String result = readFile(new File("employees.html"));
        report.generateToHTML(em -> em.getFired().get(Calendar.YEAR) < 2000);
        assertEquals(expected.toString(), result);
    }

    @Test
    public void testGenerateXMLReport() throws IOException {
        MemStore store = new MemStore();
        store.add(mishail);
        store.add(oleg);
        store.add(viktor);
        store.add(sergey);
        Report report = new ReportForDevelop(store);
        StringBuilder expected = new StringBuilder();
        expected.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>")
                .append("<employees>")
                .append("   <employee>")
                .append("      <name>Sergey</name>")
                .append("      <hired>Thu Nov 01 00:00:00 MSK 1990</hired>")
                .append("      <fired>Fri Jan 07 00:00:00 MSK 1994</fired>")
                .append("      <salary>800.0</salary>")
                .append("   </employee>")
                .append("</employees>");
        report.generateToXML(em -> em.getFired().get(Calendar.YEAR) < 2000);
        String result = readFile(new File("employees_develop.xml"));
        assertEquals(expected.toString(), result);
    }

    @Test
    public void testGenerateJSONReport() throws IOException {
        MemStore store = new MemStore();
        store.add(mishail);
        store.add(oleg);
        store.add(viktor);
        store.add(sergey);
        Report report = new ReportForDevelop(store);
        StringBuilder expected = new StringBuilder();
        expected.append("[{"
                +
                "\"name\":\"Sergey\","
                +
                "\"hired\":657406800000,"
                +
                "\"fired\":757890000000,"
                +
                "\"salary\":800.0"
                +
                "}]");
        report.generateToJSON(em -> em.getFired().get(Calendar.YEAR) < 2000);
        String result = readFile(new File("employees_develop.json"));
        assertEquals(expected.toString(), result);
    }

    public String readFile(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder builder = new StringBuilder();
        String line = reader.readLine();
        while (line != null) {
            builder.append(line);
            line = reader.readLine();
        }
        return builder.toString();
    }
}
