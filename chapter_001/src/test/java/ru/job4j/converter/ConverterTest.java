package ru.job4j.converter;
import org.junit.Assert;
import org.junit.Test;
public class ConverterTest {

    @Test
    public void rubleToEuro() {
        int in = 140;
        int expected = 2;
        int out = Converter.rubleToEuro(in);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void rubleToDollar() {
        int in = 180;
        int expected = 3;
        int out = Converter.rubleToDollar(in);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void dollarToRuble() {
        int in = 5;
        int expected = 300;
        int out = Converter.dollarToRuble(in);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void euroToRuble() {
        int in = 4;
        int expected = 280;
        int out = Converter.euroToRuble(in);
        Assert.assertEquals(expected, out);
    }
}
