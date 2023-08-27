package com.verizon.offercalculator.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RegularProcessorTest {

    private final RegularProcessor regularProcessor = new RegularProcessor();

    @Test
    public void testDiscountBetween5000And10000() {
        double purchaseAmount = 7500;
        double expectedDiscountedAmount = purchaseAmount * 0.9;
        assertEquals(expectedDiscountedAmount, regularProcessor.offerProcessor(purchaseAmount), 0.001);
    }

    @Test
    public void testDiscountAbove10000() {
        double purchaseAmount = 12000;
        double expectedDiscountedAmount = purchaseAmount * 0.8;
        assertEquals(expectedDiscountedAmount, regularProcessor.offerProcessor(purchaseAmount), 0.001);
    }

    @Test
    public void testPurchaseAmountEqualTo5000() {
        double purchaseAmount = 5000;
        double expectedDiscountedAmount = purchaseAmount-purchaseAmount * 0.1;

        assertEquals(expectedDiscountedAmount, regularProcessor.offerProcessor(purchaseAmount), 0.001);
    }

    @Test
    public void testDiscountAbove10000_negative() {
        double purchaseAmount = 10000;
        double expectedDiscountedAmount = purchaseAmount * 0.2;
        assertNotEquals(expectedDiscountedAmount, regularProcessor.offerProcessor(purchaseAmount), 0.001);
    }

    @Test
    public void testZeroPurchaseAmount() {
        double purchaseAmount = 0; // Zero value
        assertEquals(0, regularProcessor.offerProcessor(purchaseAmount));
    }
}
