package com.verizon.offercalculator.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PremiumProcessorTest {

    private final PremiumProcessor offerProcessor = new PremiumProcessor();

    @Test
    public void testDiscountLessThan4000() {
        double purchaseAmount = 3000;
        double expectedDiscountedAmount = purchaseAmount * 0.9;
        assertEquals(expectedDiscountedAmount, offerProcessor.offerProcessor(purchaseAmount), 0.001);
    }

    @Test
    public void testDiscountBetween4000And8000() {
        double purchaseAmount = 6000;
        double expectedDiscountedAmount = purchaseAmount * 0.85;
        assertEquals(expectedDiscountedAmount, offerProcessor.offerProcessor(purchaseAmount), 0.001);
    }

    @Test
    public void testDiscountBetween8000And12000() {
        double purchaseAmount = 10000;
        double expectedDiscountedAmount = purchaseAmount * 0.8;
        assertEquals(expectedDiscountedAmount, offerProcessor.offerProcessor(purchaseAmount), 0.001);
    }

    @Test
    public void testDiscountAbove12000() {
        double purchaseAmount = 15000;
        double expectedDiscountedAmount = purchaseAmount * 0.7;
        assertEquals(expectedDiscountedAmount, offerProcessor.offerProcessor(purchaseAmount), 0.001);
    }

    @Test
    public void testDiscountAbove10000_negative() {
        double purchaseAmount = 10000;
        double expectedDiscountedAmount = purchaseAmount * 0.2;
        assertNotEquals(expectedDiscountedAmount, offerProcessor.offerProcessor(purchaseAmount), 0.001);
    }

    @Test
    public void testZeroPurchaseAmount() {
        double purchaseAmount = 0; // Zero value
        assertEquals(0, offerProcessor.offerProcessor(purchaseAmount));
    }
}
