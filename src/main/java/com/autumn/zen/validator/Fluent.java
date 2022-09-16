package com.autumn.zen.validator;

import com.autumn.zen.bean.Car;
import com.baidu.unbiz.fluentvalidator.*;
import com.baidu.unbiz.fluentvalidator.validator.element.ValidatorElementList;

import java.util.List;

/**
 * @since 2022-09-07
 */
public class Fluent {


    public static void doJob() {

    }


    public static void main(String[] args) {

        Car car = new Car();
        Result ret = FluentValidator.checkAll().failFast().on(car.getSeatCount(), new CarSeatCountValidator()).when(false).doValidate().result(ResultCollectors.toSimple());

        FluentValidator.checkAll().doValidate(new ValidateCallback() {
            @Override
            public void onSuccess(ValidatorElementList validatorElementList) {
                System.out.println("validatorElementList = " + validatorElementList);
            }

            @Override
            public void onFail(ValidatorElementList validatorElementList, List<ValidationError> errors) {
                System.out.println("validatorElementList = " + errors);
            }

            @Override
            public void onUncaughtException(Validator validator, Exception e, Object target) throws Exception {
                throw e;
            }
        });


        System.out.println(ret);


    }
}
