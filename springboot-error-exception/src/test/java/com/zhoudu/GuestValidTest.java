package com.zhoudu;

import com.zhoudu.domain.Guest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class GuestValidTest {
    public static void main(String[] args) {
        Validator validator= Validation.buildDefaultValidatorFactory().getValidator();

        Guest guest=new Guest("","");
        Set<ConstraintViolation<Guest>> violationSet =  validator.validate(guest);
        for(ConstraintViolation guestCon: violationSet ){
            System.out.println(guestCon.getMessage()+","+guestCon.getPropertyPath());
        }

        Validator validatorFastFail=Validation.byDefaultProvider().configure()
                .addProperty("hibernate.validator.fail_fast","true").
                buildValidatorFactory().getValidator();

        Set<ConstraintViolation<Guest>> violationFastFailSet=validatorFastFail.validate(guest);
        for(ConstraintViolation vavv:violationFastFailSet){
            System.out.println(vavv.getPropertyPath()+","+vavv.getMessage());
        }
    }
}
