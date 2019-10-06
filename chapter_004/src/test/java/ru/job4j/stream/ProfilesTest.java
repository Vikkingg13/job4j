package ru.job4j.stream;

import org.junit.Test;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class ProfilesTest {
    private List<Profile> list = List.of(
        new Profile(new Address("Minsk", "Kirova", 14, 35)),
        new Profile(new Address("Lida", "Lenina", 42, 12)),
        new Profile(new Address("Minsk", "Kirova", 14, 35)),
        new Profile(new Address("Vegas", "Ember", 101, 1)),
        new Profile(new Address("Vegas", "Ember", 101, 1)),
        new Profile(new Address("Moscow", "Komsomolskaya", 21, 53))
    );

    @Test
    public void whenCollectUniqueSortedAddresses() {
        Profiles profiles = new Profiles();
        List<Address> result = profiles.collect(list);
        List<Address> expected =  List.of(
                new Address("Lida", "Lenina", 42, 12),
                new Address("Minsk", "Kirova", 14, 35),
                new Address("Moscow", "Komsomolskaya", 21, 53),
                new Address("Vegas", "Ember", 101, 1)
        );
        assertThat(result, is(expected));
    }
}
