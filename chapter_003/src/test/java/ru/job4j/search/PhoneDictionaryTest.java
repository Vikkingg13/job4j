package ru.job4j.search;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByAddress() {
        PhoneDictionary dictionary = new PhoneDictionary();
        dictionary.add(new Person("Alexander", "Lukashenko", "3722176", "Minsk"));
        dictionary.add(new Person("Alexey", "Navalny", "651484", "Moscow"));
        List<Person> persons = dictionary.find("Moscow");
        assertThat(persons.iterator().next().getSurname(), is("Navalny"));
    }
}
