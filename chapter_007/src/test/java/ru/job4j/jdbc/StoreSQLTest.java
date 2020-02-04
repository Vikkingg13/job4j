package ru.job4j.jdbc;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class StoreSQLTest {
    @Test
    public void checkConnection() {
        StoreSQL store = new StoreSQL(new Config("sqlite.properties"));
        assertThat(store.init(), is(true));
    }

    @Test
    public void whenGenerate3EntriesThenStoreHas3Rows() {
        try (StoreSQL store = new StoreSQL(new Config("sqlite.properties"))) {
            store.init();
            store.generate(3);
            assertThat(store.load().size(), is(3));
        }
    }

    @Test
    public void whenGenerate3ThenGeneratedNumbersOneTwoThree() {
        try (StoreSQL store = new StoreSQL(new Config("sqlite.properties"))) {
            store.init();
            store.generate(3);
            assertThat(store.load().get(0).getField(), is(1));
            assertThat(store.load().get(1).getField(), is(2));
            assertThat(store.load().get(2).getField(), is(3));
        }
    }
}
