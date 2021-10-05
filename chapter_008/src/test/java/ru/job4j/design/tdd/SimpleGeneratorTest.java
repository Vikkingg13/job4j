/*
*TODO
package ru.job4j.design.tdd;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import java.util.Map;

public class SimpleGeneratorTest {

    @Test
    public void whereGeneratorWithSecondKeys() {
        String template = "My name is ${name}, i'm ${age} years old.";
        Map<String, String> map = Map.of("name", "Viktor",
                "age", "26");
        Generator generator = new SimpleGenerator();
        String result = generator.produce(template, map);
        String expected = "My name is Viktor, i'm 26 years old.";
        assertEquals(expected, result);
    }

    @Test
    public void whereGeneratorWithThreeKeys() {
        String template = "My name is ${name}, i'm ${age} years old. "
                + "I am programming in ${language}";
        Map<String, String> map = Map.of("name", "Viktor",
                "age", "26", "language", "java");
        Generator generator = new SimpleGenerator();
        String result = generator.produce(template, map);
        String expected = "My name is Viktor, i'm 26 years old. "
                + "I am programming in java";
        assertEquals(expected, result);
    }

    @Test(expected = KeyNotFoundException.class)
    public void whereGeneratorNotFindKey() {
        String template = "My name is ${name}, i'm ${age} years old.";
        Map<String, String> map = Map.of("name", "Viktor");
        Generator generator = new SimpleGenerator();
        generator.produce(template, map);
    }

    @Test(expected = KeyNotUsedException.class)
    public void whereGeneratorUsedOnlyOneKey() {
        String template = "My name is ${name}.";
        Map<String, String> map = Map.of("name", "Viktor",
                "age", "26");
        Generator generator = new SimpleGenerator();
        generator.produce(template, map);
    }
}
 */
