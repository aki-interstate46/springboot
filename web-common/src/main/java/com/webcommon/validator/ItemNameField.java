package com.webcommon.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.webcommon.validator.ItemNameField.ItemNameFieldValidator;

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
@Constraint(validatedBy = ItemNameFieldValidator.class)
@Target({ java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ItemNameField {
	
	String message() default "なまえがへんだよ！";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
	
	class ItemNameFieldValidator implements ConstraintValidator<ItemNameField, String> {
		
		@Override
		public void initialize(ItemNameField field) {
		}
		
		@Override
		public boolean isValid(String itemField, ConstraintValidatorContext arg1) {
			if (itemField != null && !itemField.matches(".{0,5}")) {
				return false;
			}
			return true;
		}
	}
}
