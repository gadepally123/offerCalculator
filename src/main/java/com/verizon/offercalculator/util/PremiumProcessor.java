package com.verizon.offercalculator.util;

public class PremiumProcessor implements CustomerTypeProcessor{
    @Override
    public double offerProcessor(double purchaseAmount) {
        double discount = 0;
        if(purchaseAmount < 4000){
            discount = 0.1;
        }else if(purchaseAmount >= 4000 && purchaseAmount <8000){
            discount = 0.15;
        }else if(purchaseAmount >= 8000 && purchaseAmount <12000){
            discount = 0.2;
        }else if(purchaseAmount >= 12000){
            discount = 0.3;
        }

        double discountedPurchaseAmount = purchaseAmount - (discount * purchaseAmount);
        return discountedPurchaseAmount;
    }
}
