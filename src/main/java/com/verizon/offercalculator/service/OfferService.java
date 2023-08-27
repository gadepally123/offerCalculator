package com.verizon.offercalculator.service;

import com.verizon.offercalculator.util.CustomerTypeIdentifier;
import com.verizon.offercalculator.util.CustomerTypeProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfferService {

    @Autowired
    CustomerTypeIdentifier customerTypeIdentifier;


    public double calculatorOffer(String customerType, double purchaseAmount) {
        CustomerTypeProcessor processor = customerTypeIdentifier.getCustomerTypeProcessor(customerType);
        return processor.offerProcessor(purchaseAmount);
    }
}
