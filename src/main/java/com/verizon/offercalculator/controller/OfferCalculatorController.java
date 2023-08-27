package com.verizon.offercalculator.controller;

import com.verizon.offercalculator.service.OfferService;
import com.verizon.offercalculator.validator.OfferValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OfferCalculatorController {

    public static final Logger logger = LoggerFactory.getLogger("offerCalculatorController");

    @Autowired
    OfferService offerService;

    @Autowired
    OfferValidator offerValidator;

    @GetMapping("/offer/{customerType}/calculate")
    public ResponseEntity calcualteOffer(@PathVariable String customerType, @RequestParam double purchaseAmount){
        logger.info(" Controller Request Came :: customer Type {}, purchase Amount {}",customerType,purchaseAmount);

        boolean validate = offerValidator.validateCustomerType(customerType);
        if(!validate){
            return new ResponseEntity("Invalid Customer Type ",HttpStatus.BAD_REQUEST);
        }

        double afterOfferPurchaseAmount = offerService.calculatorOffer(customerType,purchaseAmount);

        return new ResponseEntity(afterOfferPurchaseAmount, HttpStatus.OK);
    }
}
