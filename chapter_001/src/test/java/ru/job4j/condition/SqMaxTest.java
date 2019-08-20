package ru.job4j.condition;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class SqMaxTest {

    @Test
    public void whenFirstMax(){
        SqMax check = new SqMax();
        int result = check.max(3,2,1,1);
        assertThat(result,is(3));
    }

    @Test
    public void whenSecondMax(){
        SqMax check = new SqMax();
        int result = check.max(1,2,1,1);
        assertThat(result,is(2));
    }

    @Test
    public void whenThirdMax(){
        SqMax check = new SqMax();
        int result = check.max(1,1,4,3);
        assertThat(result,is(4));
    }

    @Test
    public void whenForthMax(){
        SqMax check = new SqMax();
        int result = check.max(3,2,2,5);
        assertThat(result,is(5));
    }

    @Test
    public void whenAreEqual(){
        SqMax check = new SqMax();
        int result = check.max(1,1,1,1);
        assertThat(result,is(1));
    }
}
