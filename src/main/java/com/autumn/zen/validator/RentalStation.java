package com.autumn.zen.validator;

import com.autumn.zen.bean.Customer;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.executable.ExecutableValidator;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.Set;

/**
 * @since 2022-09-07
 */
public class RentalStation {

    public RentalStation() {

    }

    public RentalStation(@NotNull String name) {
        //...
    }

    public void rentCar(
            @NotNull Customer customer,
            @NotNull @Future Date startDate,
            @Min(1) int durationInDays) {

        //...
    }

    public static void main(String[] args) throws Exception {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        ExecutableValidator executableValidator = factory.getValidator().forExecutables();
        RentalStation object = new RentalStation();
        Method method = RentalStation.class.getMethod("rentCar", Customer.class, Date.class, int.class);
        Object[] parameterValues = {new Customer(), new Date(), 2};
        Set<ConstraintViolation<RentalStation>> violations = executableValidator.validateParameters(object, method, parameterValues);

        violations.forEach(x -> System.out.println(x));


    }

}
