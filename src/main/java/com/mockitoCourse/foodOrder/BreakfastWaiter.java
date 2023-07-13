package com.mockitoCourse.foodOrder;

import java.util.Arrays;
import java.util.List;

public class BreakfastWaiter {

    public List<String> getNormalMenu() {
        return Arrays.asList("Apple", "Sausages", "Bacon", "Toast");
    }

    public List<String> getVegetarianMenu() {
        return Arrays.asList("Apple", "Beans", "Hash brown", "Toast");
    }
}
