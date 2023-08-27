package com.verizon.offercalculator.util;

public class RegularProcessor implements CustomerTypeProcessor{
    @Override
    public double offerProcessor(double purchaseAmount) {
        double discount = 0;
        if(purchaseAmount >= 5000 && purchaseAmount <10000){
            discount = 0.1;
        }else if(purchaseAmount >= 10000){
            discount = 0.2;
        }

        double discountedPurchaseAmount = purchaseAmount - (discount * purchaseAmount);
        return discountedPurchaseAmount;
    }
}
