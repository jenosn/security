package com.jenson.security.validater;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TestConstarint implements ConstraintValidator<TestValidater, Object> {

	@Override
	public void initialize(TestValidater constraintAnnotation) {
		System.out.println("У�鿪ʼ");
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		System.out.println(value);
		return true;
	}

}
