package ru.job4j.io;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {
    @Test
    public void whenPairWithoutComment() {
        Config config = new Config("./data/pair_without_comment.properties");
        config.load();
        assertThat(config.value("name"), is("Viktor"));
        assertThat(config.value("age"), is("25"));
        assertThat(config.value("country"), is("Belarus"));
    }

    @Test
    public void whenPairWithCommentAndEmptyLine() {
        Config config = new Config("app.properties");
        config.load();
        assertThat(config.value("name"), is("Viktor"));
        assertThat(config.value("age"), is("25"));
        assertThat(config.value("country"), is("Belarus"));
    }
}