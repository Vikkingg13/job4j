package ru.job4j.calculator;

import org.junit.Assert;
import org.junit.Test;


public class FitTest {

    @Test
    public void manWeigth(){
        double in = 185;
        double expected = 97.5;
        double out = Fit.manWeigth(in);
        Assert.assertEquals(expected,out,0.5);
    }

    @Test
    public void womanWeigth(){
        double in = 170;
        double expected = 69;
        double out = Fit.womanWeigth(in);
        Assert.assertEquals(expected,out,0.5);
    }
}
