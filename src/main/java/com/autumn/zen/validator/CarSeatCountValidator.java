package com.autumn.zen.validator;

import com.baidu.unbiz.fluentvalidator.Validator;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;

/**
 * @since 2022-09-07
 */
public class CarSeatCountValidator extends ValidatorHandler<Integer> implements Validator<Integer> {

    @Override
    public boolean validate(ValidatorContext context, Integer t) {
        if (t < 2) {
            context.addErrorMsg(String.format("Seat count is not valid, invalid value=%s", t));
            return false;
        }
        return true;
    }
}

