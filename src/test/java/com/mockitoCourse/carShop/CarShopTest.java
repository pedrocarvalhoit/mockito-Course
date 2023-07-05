package com.mockitoCourse.carShop;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class CarShopTest {

    @Test
    public void testCarsInShopThenReturn(){
        CarShop carShopSpy = Mockito.spy(CarShop.class);
        Map<String, Integer> carInStock = new HashMap<String, Integer>();
        carInStock.put("Jaguar", 10);

        //For exceptions then return is better because the method is actually called
        when(carShopSpy.getCarsInStock()).thenReturn(carInStock);

        assertEquals((10), carShopSpy.getStockForBrand("Jaguar"));
    }


    @Test
    public void testCarsInShopDoReturn(){
        CarShop carShopSpy = Mockito.spy(CarShop.class);
        Map<String, Integer> carInStock = new HashMap<String, Integer>();
        carInStock.put("Jaguar", 10);
        //Do return don't call the mathod
        doReturn(carInStock).when(carShopSpy).getCarsInStock();

        assertEquals((10), carShopSpy.getStockForBrand("Jaguar"));
    }

}