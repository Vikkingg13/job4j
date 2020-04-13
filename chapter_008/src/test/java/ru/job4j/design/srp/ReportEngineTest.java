package ru.job4j.design.srp;

import org.junit.Test;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class ReportEngineTest {
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
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine engine = new ReportEngine(store);
        StringBuilder expected =  new StringBuilder();
        expected.append("Name; Hired; Fired; Salary; ")
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";");
        assertEquals(engine.generate((em -> true)), expected.toString());
    }

    @Test
    public void whenGeneratedForDevelopersThenCreateHTMLFile() {
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
                .append("<th>").append("Name").append("</th>")
                .append("<th>").append("Hired").append("</th>")
                .append("<th>").append("Fired").append("</th>")
                .append("<th>").append("Salary").append("</th>")
                .append("<tr>")
                .append("<td>").append(sergey.getName()).append("</td>")
                .append("<td>").append(sergey.getHired().getTime()).append("</td>")
                .append("<td>").append(sergey.getFired().getTime()).append("</td>")
                .append("<td>").append(sergey.getSalary()).append("</td>")
                .append("</tr>")
                .append("</tr>")
                .append("</body>")
                .append("</html>");
        assertEquals(report.generate(em -> em.getFired().get(Calendar.YEAR) < 2000), expected.toString());
    }

    @Test
    public void whenGeneratedForFinanceThenResultWithSpecialFormatForSalary() {
        MemStore store = new MemStore();
        store.add(mishail);
        store.add(oleg);
        store.add(viktor);
        store.add(sergey);
        Report report = new ReportForFinance(store);
        StringBuilder expected = new StringBuilder();
        expected.append("Name; Hired; Fired; Salary; ")
                .append(viktor.getName()).append(";")
                .append(viktor.getHired()).append(";")
                .append(viktor.getFired()).append(";")
                .append(String.format("%.2f", viktor.getSalary())).append(";");
        assertEquals(report.generate((em -> em.getSalary() > 1000)), expected.toString());
    }

    @Test
    public void whenGeneratedForHRThenResultWithoutHiredFiredAndSortedDescending() {
        MemStore store = new MemStore();
        store.add(mishail);
        store.add(oleg);
        store.add(viktor);
        store.add(sergey);
        Report report = new ReportForHR(store);
        StringBuilder expected = new StringBuilder();
        expected.append("Name; Salary; ")
                .append(viktor.getName()).append(";")
                .append(viktor.getSalary()).append(";")
                .append(sergey.getName()).append(";")
                .append(sergey.getSalary()).append(";");
        assertEquals(report.generate(em -> em.getSalary() > 750), expected.toString());
    }
}
