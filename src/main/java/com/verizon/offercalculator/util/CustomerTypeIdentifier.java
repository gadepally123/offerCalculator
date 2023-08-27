package com.verizon.offercalculator.util;

import org.springframework.stereotype.Component;

@Component
public class CustomerTypeIdentifier {

    public CustomerTypeProcessor getCustomerTypeProcessor(String customerType){
        if(customerType.equalsIgnoreCase("regular")){
            return new RegularProcessor();
        }else if(customerType.equalsIgnoreCase("premium")){
            return new PremiumProcessor();
        }else{
            return null;
        }
    }
}
