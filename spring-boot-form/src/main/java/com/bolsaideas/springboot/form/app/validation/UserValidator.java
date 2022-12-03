package com.bolsaideas.springboot.form.app.validation;

import com.bolsaideas.springboot.form.app.models.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        ValidationUtils.rejectIfEmpty(errors, "name", "Properties error, name have not be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "Properties error, name have not be empty");

//        if (!user.getIdentify().matches("REGEX")){
//            errors.rejectValue("identify", "identify must be like fallowing patterns");
//        }
    }
}
