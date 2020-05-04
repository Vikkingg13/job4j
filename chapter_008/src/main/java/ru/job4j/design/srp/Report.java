package ru.job4j.design.srp;

import java.util.function.Predicate;

public interface Report {
    String generate(Predicate<Employee> filter);

    String generateToXML(Predicate<Employee> filter);

    String generateToJSON(Predicate<Employee> filter);

    String generateToHTML(Predicate<Employee> filter);
}
