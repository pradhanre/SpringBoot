package com.tcs.rakesh.validator;

import java.util.regex.Matcher;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DescriptionConstraintValidator implements ConstraintValidator<Description, String>{
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		String regex = "^[A-Za-z]\\w{5,29}$"; 
		Pattern p = Pattern.compile(regex); 
        if(value == null) {
        	return false;
        }
        Matcher m=p.matcher(value);
        return m.matches();
	}
	public void initialize(Description desc) {
		desc.message();
	}
	

}
