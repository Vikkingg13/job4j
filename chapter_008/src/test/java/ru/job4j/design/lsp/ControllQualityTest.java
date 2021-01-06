package ru.job4j.design.lsp;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ControllQualityTest {

    @Test
    public void whereCurrentExpirationDateLess25PercentThenFoodAddedToShopAndAddDiscount() {
        DateInfo.setDate(new GregorianCalendar(2020, Calendar.JANUARY, 18).getTime());
        IceCream iceCream = new IceCream("Trio",
                new GregorianCalendar(2020, Calendar.JANUARY, 11).getTime(),
                new GregorianCalendar(2020, Calendar.JANUARY, 20).getTime(),
                5,
                0);
        Candy candy = new Candy("Choco",
                new GregorianCalendar(2019, Calendar.DECEMBER, 13).getTime(),
                new GregorianCalendar(2020, Calendar.JANUARY, 29).getTime(),
                3,
                0);
        Cheese cheese = new Cheese("Galand",
                new GregorianCalendar(2020, Calendar.JANUARY, 13).getTime(),
                new GregorianCalendar(2020, Calendar.JANUARY, 19).getTime(),
                30,
                0);
        ControllQuality controll = new ControllQuality();
        controll.distribute(iceCream);
        controll.distribute(candy);
        controll.distribute(cheese);
        List<Food> foods = Shop.getInstance().getFoods();
        assertEquals("Trio", foods.get(0).getName());
        assertEquals(40, foods.get(0).getDiscount());
        assertEquals("Choco", foods.get(1).getName());
        assertEquals(60, foods.get(1).getDiscount());
        assertEquals("Galand", foods.get(2).getName());
        assertEquals(25, foods.get(2).getDiscount());
        foods.clear();
    }

    @Test
    public void whereCurrentExpirationDateMore75PercentThenFoodAddedToWarehouse() {
        DateInfo.setDate(new GregorianCalendar(2020, Calendar.JANUARY, 13).getTime());
        IceCream iceCream = new IceCream("Trio",
                new GregorianCalendar(2020, Calendar.JANUARY, 11).getTime(),
                new GregorianCalendar(2020, Calendar.JANUARY, 30).getTime(),
                5,
                0);
        Candy candy = new Candy("Choco",
                new GregorianCalendar(2019, Calendar.DECEMBER, 2).getTime(),
                new GregorianCalendar(2020, Calendar.SEPTEMBER, 5).getTime(),
                3,
                0);
        Cheese cheese = new Cheese("Galand",
                new GregorianCalendar(2020, Calendar.JANUARY, 12).getTime(),
                new GregorianCalendar(2020, Calendar.JANUARY, 20).getTime(),
                30,
                0);
        ControllQuality controll = new ControllQuality();
        controll.distribute(iceCream);
        controll.distribute(candy);
        controll.distribute(cheese);
        List<Food> foods = Warehouse.getInstance().getFoods();
        assertEquals("Trio", foods.get(0).getName());
        assertEquals("Choco", foods.get(1).getName());
        assertEquals("Galand", foods.get(2).getName());
    }

    @Test
    public void whereCurrentExpirationDateLess75PercentAndMore25PercentThenFoodAddedToShop() {
        DateInfo.setDate(new GregorianCalendar(2020, Calendar.JANUARY, 17).getTime());
        IceCream iceCream = new IceCream("Trio",
                new GregorianCalendar(2020, Calendar.JANUARY, 11).getTime(),
                new GregorianCalendar(2020, Calendar.JANUARY, 28).getTime(),
                5,
                0);
        Candy candy = new Candy("Choco",
                new GregorianCalendar(2019, Calendar.DECEMBER, 13).getTime(),
                new GregorianCalendar(2020, Calendar.APRIL, 23).getTime(),
                3,
                0);
        Cheese cheese = new Cheese("Galand",
                new GregorianCalendar(2020, Calendar.JANUARY, 13).getTime(),
                new GregorianCalendar(2020, Calendar.JANUARY, 21).getTime(),
                30,
                0);
        ControllQuality controll = new ControllQuality();
        controll.distribute(iceCream);
        controll.distribute(candy);
        controll.distribute(cheese);
        List<Food> foods = Shop.getInstance().getFoods();
        assertEquals("Trio", foods.get(0).getName());
        assertEquals("Choco", foods.get(1).getName());
        assertEquals("Galand", foods.get(2).getName());
        foods.clear();
    }

    @Test
    public void whereExpiredThenFoodAddedToTrash() {
        DateInfo.setDate(new GregorianCalendar(2020, Calendar.JULY, 5).getTime());
        IceCream iceCream = new IceCream("Trio",
                new GregorianCalendar(2020, Calendar.JANUARY, 11).getTime(),
                new GregorianCalendar(2020, Calendar.JANUARY, 23).getTime(),
                5,
                0);
        Candy candy = new Candy("Choco",
                new GregorianCalendar(2019, Calendar.DECEMBER, 13).getTime(),
                new GregorianCalendar(2020, Calendar.APRIL, 11).getTime(),
                3,
                0);
        Cheese cheese = new Cheese("Galand",
                new GregorianCalendar(2020, Calendar.JANUARY, 13).getTime(),
                new GregorianCalendar(2020, Calendar.FEBRUARY, 19).getTime(),
                30,
                0);
        ControllQuality controll = new ControllQuality();
        controll.distribute(iceCream);
        controll.distribute(candy);
        controll.distribute(cheese);
        List<Food> foods = Trash.getInstance().getFoods();
        assertEquals("Trio", foods.get(0).getName());
        assertEquals("Choco", foods.get(1).getName());
        assertEquals("Galand", foods.get(2).getName());
    }

    @Test
    public void whereResortAllFoods() {
        DateInfo.setDate(new GregorianCalendar(2020, Calendar.JANUARY, 13).getTime());
        IceCream iceCream = new IceCream("Trio",
                new GregorianCalendar(2020, Calendar.JANUARY, 11).getTime(),
                new GregorianCalendar(2020, Calendar.JANUARY, 30).getTime(),
                5,
                0);
        Candy candy = new Candy("Choco",
                new GregorianCalendar(2019, Calendar.DECEMBER, 2).getTime(),
                new GregorianCalendar(2020, Calendar.SEPTEMBER, 5).getTime(),
                3,
                0);
        Cheese cheese = new Cheese("Galand",
                new GregorianCalendar(2020, Calendar.JANUARY, 12).getTime(),
                new GregorianCalendar(2020, Calendar.JANUARY, 20).getTime(),
                30,
                0);
        ControllQuality controll = new ControllQuality();
        controll.distribute(iceCream);
        controll.distribute(candy);
        controll.distribute(cheese);
        List<Food> foods = Warehouse.getInstance().getFoods();
        assertEquals("Trio", foods.get(0).getName());
        assertEquals("Choco", foods.get(1).getName());
        assertEquals("Galand", foods.get(2).getName());
        DateInfo.setDate(new GregorianCalendar(2020, Calendar.MARCH, 3).getTime());
        controll.resort();
        foods = Trash.getInstance().getFoods();
        assertEquals("Trio", foods.get(0).getName());
        foods = Shop.getInstance().getFoods();
        assertEquals("Choco", foods.get(0).getName());
        foods = Trash.getInstance().getFoods();
        assertEquals("Galand", foods.get(1).getName());
        controll.clearAll();
    }
}
