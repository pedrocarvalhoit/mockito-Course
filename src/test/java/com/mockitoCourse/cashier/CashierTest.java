package com.mockitoCourse.cashier;

import jakarta.transaction.InvalidTransactionException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashierTest {

    @Test
    public void validateTransactionThrowsIllegalArgument() throws InvalidTransactionException {
        assertThrows(IllegalArgumentException.class, () -> {
            Cashier.validateTransaction("USD", 20);
        });
    }

    @Test
    public void validateAmountThrowsInvallidTransactionException() throws InvalidTransactionException {
        assertThrows(InvalidTransactionException.class, () -> {
            Cashier.validateTransaction("EUR", -5);
        });


    }

}