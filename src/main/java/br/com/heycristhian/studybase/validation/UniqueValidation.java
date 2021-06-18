package br.com.heycristhian.studybase.validation;

import br.com.heycristhian.studybase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueValidation implements ConstraintValidator<Unique, String> {

    @Autowired private UserService service;

    @Override
    public void initialize(Unique constraintAnnotation) {
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return service.findByEmail(email).isEmpty();
    }
}
