package ru.job4j.loop;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class FitnessTest {
    @Test
    public void whenIvanGreatNik(){
        Fitness fit = new Fitness();
        int month = fit.calc(95,90);
        assertThat(month, is(0));
    }

    @Test
    public void whenIvanLessByOneNik(){
        Fitness fit = new Fitness();
        int month = fit.calc(85,95);
        assertThat(month, is(1));
    }

    @Test
    public void whenIvanLessByFewNik(){
        Fitness fit = new Fitness();
        int month = fit.calc(60,110);
        assertThat(month, is(2));
    }

}
