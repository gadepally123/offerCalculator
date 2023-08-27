package com.verizon.offercalculator.validator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.*;

public class OfferValidatorTest {

    private final OfferValidator offerValidator = new OfferValidator();

    @Test
    public void testValidCustomerType() {
        String customerTypes = "regular,premium";
        ReflectionTestUtils.setField(offerValidator, "customerTypes", customerTypes);

        assertTrue(offerValidator.validateCustomerType("regular"));
        assertTrue(offerValidator.validateCustomerType("premium"));
    }

    @Test
    public void testInvalidCustomerType() {
        String customerTypes = "regular,premium";
        ReflectionTestUtils.setField(offerValidator, "customerTypes", customerTypes);

        assertFalse(offerValidator.validateCustomerType("unknown"));
    }

    @Test
    public void testNullCustomerType() {
        String customerTypes = "regular,premium";
        ReflectionTestUtils.setField(offerValidator, "customerTypes", customerTypes);

        assertFalse(offerValidator.validateCustomerType(null));
    }
}
