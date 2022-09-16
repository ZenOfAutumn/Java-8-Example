package com.autumn.zen.validator;

import com.autumn.zen.bean.Car;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.HibernateValidatorConfiguration;
import org.hibernate.validator.cfg.ConstraintMapping;
import org.hibernate.validator.cfg.defs.NotNullDef;
import org.hibernate.validator.cfg.defs.SizeDef;

import java.util.Set;

/**
 * @since 2022-09-07
 */
public class HValidator {

    public static void main(String[] args) throws Exception {

        ValidatorFactory factory = Validation.byProvider(HibernateValidator.class)
                .configure()
                .failFast(true)
                .buildValidatorFactory();

        Validator validator = factory.getValidator();
        Car car = new Car(null, "DD-AB-123", 4);

        Set<ConstraintViolation<Car>> constraintViolations =
                validator.validate(car);

        HibernateValidatorConfiguration configuration = Validation.byProvider(HibernateValidator.class).configure();
        configuration.allowMultipleCascadedValidationOnReturnValues(true)
                .allowOverridingMethodAlterParameterConstraint(true)
                .allowParallelMethodsDefineParameterConstraints(true);

        ConstraintMapping constraintMapping = configuration.createConstraintMapping();
        constraintMapping.type(Car.class).field("").constraint(new NotNullDef()).field("").ignoreAnnotations(true).constraint(new NotNullDef()).constraint(new SizeDef().min(2).max(4)).type(RentalStation.class).getter("rentalStation")
                .constraint(new NotNullDef());

        validator = configuration.addMapping(constraintMapping)
                .buildValidatorFactory()
                .getValidator();


    }


}
