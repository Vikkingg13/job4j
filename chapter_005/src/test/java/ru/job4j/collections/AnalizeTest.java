package ru.job4j.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AnalizeTest {
    @Test
    public void whenAnalizeListStanMaxLuisAndMaxLuisAlexThenShouldReturn1Added0Changed1Delete() {
        List<Analize.User> first = List.of(
                new Analize.User(321, "Stan"),
                new Analize.User(231, "Max"),
                new Analize.User(213, "Luis"));
        List<Analize.User> second = List.of(
                new Analize.User(231, "Max"),
                new Analize.User(213, "Luis"),
                new Analize.User(123, "Alex"));
        assertThat(new Analize().diff(first, second), is(new Analize.Info(1, 0, 1)));
    }

    @Test
    public void whenAnalizeListStanMaxLuisAndViktorSteveWillAlexThenShouldReturn1Added0Changed1Delete() {
        List<Analize.User> first = List.of(
                new Analize.User(321, "Stan"),
                new Analize.User(231, "Max"),
                new Analize.User(213, "Luis"));
        List<Analize.User> second = List.of(
                new Analize.User(431, "Viktor"),
                new Analize.User(213, "Steve"),
                new Analize.User(321, "Alex"),
                new Analize.User(231, "Max"));
        assertThat(new Analize().diff(first, second), is(new Analize.Info(1, 2, 0)));
    }

    @Test
    public void whenAnalizeListStanMaxLuisAndEmptyListThenShouldReturn0Added0Changed3Delete() {
        List<Analize.User> first = List.of(
                new Analize.User(321, "Stan"),
                new Analize.User(231, "Max"),
                new Analize.User(213, "Luis"));
        List<Analize.User> second = new ArrayList<>();
        assertThat(new Analize().diff(first, second), is(new Analize.Info(0, 0, 3)));
    }
}
