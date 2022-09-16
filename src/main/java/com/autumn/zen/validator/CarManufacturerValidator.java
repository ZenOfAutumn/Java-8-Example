package com.autumn.zen.validator;

import com.baidu.unbiz.fluentvalidator.Validator;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;
import org.apache.dubbo.common.utils.StringUtils;

/**
 * @since 2022-09-07
 */
public class CarManufacturerValidator extends ValidatorHandler<String> implements Validator<String> {

    @Override
    public boolean validate(ValidatorContext context, String t) {
        if (StringUtils.isBlank(t)) {
            context.addErrorMsg(String.format("Seat count is not valid, invalid value=%s", t));
            return false;
        }
        return true;
    }
}

