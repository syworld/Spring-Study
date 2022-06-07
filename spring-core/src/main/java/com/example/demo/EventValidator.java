package com.example.demo;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EventValidator implements Validator {

  @Override
  public boolean supports(Class<?> clazz) {
    // Event class 대상
    return Event.class.equals(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "notEmpty", "Empty title not allowed");
//    Event event = (Event) target;
//    if(event.getTitle() == null){
//      errors.reject("notEmpty");
//    }
  }

}
