package com.tcs.rakesh.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DescriptionConstraintValidator implements ConstraintValidator<Description, String>{
	private static final String des="^[a-zA-Z,.-_]{2,100}$";
	private Pattern pattern;
	private Matcher matcher;
	public  DescriptionConstraintValidator() {
		// TODO Auto-generated constructor stub
	pattern=Pattern.compile(des);
		
	}
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		   
        if(value == null) {
        	return false;
        }
        matcher=pattern.matcher(value);
        return matcher.matches();
	}
	public void initialize(Description desc) {
		desc.message();
	}
	

}
