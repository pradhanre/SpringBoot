package com.tcs.rakesh.validator;

import java.lang.annotation.Retention;


import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;  

@Constraint(validatedBy = DescriptionConstraintValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD } )  
@Retention(RetentionPolicy.RUNTIME)  

public @interface Description {

	
	 public String message() default "only contains alphnumeric and must be atleast 5 characters "; 
	//represents group of constraints     
     public Class<?>[] groups() default {};  
 //represents additional information about annotation  
     public Class<? extends Payload>[] payload() default {};  
}
