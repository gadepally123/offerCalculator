package com.verizon.offercalculator.validator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OfferValidator {

    @Value("${customerTypes}")
    private String customerTypes;


    public boolean validateCustomerType(String customerType) {

        String [] customerTypeList = customerTypes.split(",");
        for( String custType : customerTypeList){
            if(custType.equalsIgnoreCase(customerType)){
                return true;
            }
        }
        return false;
    }
}
