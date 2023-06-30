package com.mockitoCourse.cashier;

import jakarta.transaction.InvalidTransactionException;

import java.util.Arrays;
import java.util.List;

public class Cashier {

    private static final List<String> acceptedCurrencies = Arrays.asList("EUR", "GBP");

    public static double validateTransaction(String currency, double amount) throws InvalidTransactionException {
        if(currencyIsAccepted(currency) && amountIsValid(amount)){
            return amount;
        }
        return -1;
    }

    private static boolean currencyIsAccepted(String currency) {
        if(!acceptedCurrencies.contains(currency)){
            throw new IllegalArgumentException("Currency " + currency + " not accepted");

        }
        return true;
    }

    private static boolean amountIsValid(double amount) throws InvalidTransactionException {
        if(amount < 0){
            throw new InvalidTransactionException("Transaction amount must be greater than 0");
        }
        return true;
    }



}
