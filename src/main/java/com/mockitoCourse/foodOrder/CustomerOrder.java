package com.mockitoCourse.foodOrder;

import java.util.List;

public class CustomerOrder {

    private BreakfastWaiter breakfastWaiter;
    private DinnerWaiter dinnerWaiter;

    public CustomerOrder(BreakfastWaiter breakfastWaiter, DinnerWaiter dinnerWaiter) {
        this.breakfastWaiter = breakfastWaiter;
        this.dinnerWaiter = dinnerWaiter;
    }

    public List vegetarianBreakfast(){
        return breakfastWaiter.getVegetarianMenu();
    }

    public List normalBreakfast(){
        return breakfastWaiter.getNormalMenu();
    }

    public List vegetarianDinner(){
        return dinnerWaiter.getVegetarianMenu();
    }

    public List normalDinner(){
        return dinnerWaiter.getNormalMenu();
    }

}
