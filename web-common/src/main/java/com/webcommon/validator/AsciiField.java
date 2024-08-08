package com.webcommon.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.webcommon.validator.AsciiField.AsciiFieldValidator;

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
@Constraint(validatedBy = AsciiFieldValidator.class)
@Target({java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AsciiField {

    String message() default "{jp.co.bitz.eticket.validator.AsciiField.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class AsciiFieldValidator implements ConstraintValidator<AsciiField, String>{

        @Override
        public void initialize(AsciiField field) {
        }

        @Override
        public boolean isValid(String itemField, ConstraintValidatorContext arg1) {
            if(itemField != null && !itemField.matches("\\p{ASCII}*")){
                return false;
            }
            return true;
        }
    }
}
