package com.mockitoCourse.foodOrder;

import java.util.Arrays;
import java.util.List;

public class DinnerWaiter {

    public List<String> getNormalMenu() {
        return Arrays.asList("Calamari", "Roast Chicken", "Stick toffee pudding");
    }

    public List<String> getVegetarianMenu() {
        return Arrays.asList("Garlic bread", "Vegetable Lasagne", "Chocolate Brownie");
    }
}