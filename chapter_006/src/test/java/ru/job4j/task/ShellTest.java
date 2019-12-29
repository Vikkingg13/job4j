package ru.job4j.task;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;

public class ShellTest {
    @Test
    public void testCommandCd() {
        Shell shell = new Shell();
        assertThat(shell.path(), is("/"));
        shell.cd("/");
        assertThat(shell.path(), is("/"));
        shell.cd("usr/..");
        assertThat(shell.path(), is("/"));
        shell.cd("usr").cd("local");
        shell.cd("../local").cd("./");
        assertThat(shell.path(), is("/usr/local"));
        shell.cd("..");
        assertThat(shell.path(), is("/usr"));
        shell.cd("//lib///");
        assertThat(shell.path(), is("/lib"));
        shell.cd("../usr").cd("local");
        assertThat(shell.path(), is("/usr/local"));
        shell.cd("../../");
        assertThat(shell.path(), is("/"));

    }
}
