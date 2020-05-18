package ru.job4j.design.lsp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ControllQuality {

    private static final Logger log = LoggerFactory.getLogger( ControllQuality.class );
    private Storage storage;
    private Date currentDate;

    public ControllQuality(Date date) {
        currentDate = date;
    }

    public void distribute(Food food) {
        long period = food.getExpiredDate().getTime() - food.getCreateDate().getTime();
        Date top = new Date(food.getCreateDate().getTime() + period / 4);
        Date down = new Date(food.getCreateDate().getTime() + period - (period / 4));//13 12 00
        if (currentDate.before(top)) {
            storage = Warehouse.getInstance();
        } else if (currentDate.before(down)) {
            storage = Shop.getInstance();
        } else if (currentDate.before(food.getExpiredDate())) {
            storage = Shop.getInstance();
            food.setDiscount();
            log.info("Set discount {} percent.", food.getDiscount());
        } else {
            storage = Trash.getInstance();
        }
        storage.add(food);
        log.info("Added to {}.", storage.getClass().getSimpleName());
    }
}
