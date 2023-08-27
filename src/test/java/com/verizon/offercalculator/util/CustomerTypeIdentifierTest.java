package com.verizon.offercalculator.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerTypeIdentifierTest {

    private final CustomerTypeIdentifier customerTypeIdentifier = new CustomerTypeIdentifier();

    @Test
    public void testGetRegularCustomerTypeProcessor() {
        String customerType = "regular";
        CustomerTypeProcessor processor = customerTypeIdentifier.getCustomerTypeProcessor(customerType);
        assertTrue(processor instanceof RegularProcessor);
    }

    @Test
    public void testGetPremiumCustomerTypeProcessor() {
        String customerType = "premium";
        CustomerTypeProcessor processor = customerTypeIdentifier.getCustomerTypeProcessor(customerType);
        assertTrue(processor instanceof PremiumProcessor);
    }

    @Test
    public void testInvalidCustomerType() {
        String customerType = "unknown";
        CustomerTypeProcessor processor = customerTypeIdentifier.getCustomerTypeProcessor(customerType);
        assertNull(processor);
    }


}
