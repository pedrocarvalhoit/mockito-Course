package com.mockitoCourse.carShop;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.HashMap;
import java.util.Map;

public class CarShop {

    public Integer getStockForBrand(String brand){

        Map<String, Integer> carsInStock = getCarsInStock();
        if (carsInStock.containsKey(brand)){
            return carsInStock.get(brand);
        }else{
            throw new RuntimeException("Brand out of stock");
        }

    }

    public Map<String, Integer> getCarsInStock() {
        //calls a database
        System.out.println("Get cars in stock");
        Map<String, Integer> carsInStock = new HashMap<String, Integer>();
        return carsInStock;
    }

}
