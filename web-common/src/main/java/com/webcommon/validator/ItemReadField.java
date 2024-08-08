package com.webcommon.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.webcommon.validator.ItemReadField.ItemReadFieldValidator;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;

/**
 * ItemFieldの入力チェックを行う
 * 
 * @author Y.AKI
 * @version 1.0.0
 */
@Documented
@Constraint(validatedBy = ItemReadFieldValidator.class)
@Target({ java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ItemReadField {
	
	String message() default "{jp.co.bitz.eticket.validator.ItemReadField.message}";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
	
	class ItemReadFieldValidator implements ConstraintValidator<ItemReadField, String> {
		
		@Override
		public void initialize(ItemReadField field) {
		}
		
		@Override
		public boolean isValid(String itemField, ConstraintValidatorContext arg1) {
			if (itemField != null && !itemField.matches("[a-zA-Z0-9\\u3040-\\u309Fー]{0,256}")) {
				return false;
			}
			return true;
		}
	}
}
