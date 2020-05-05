package com.example.EntrantsSystem.validators;

import com.example.EntrantsSystem.domain.User;
import com.example.EntrantsSystem.dto.UserDto;
import com.example.EntrantsSystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class UserRegisterValidator implements Validator {

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserDto.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserDto dto = (UserDto) o;
        if (dto.getUsername().isEmpty()) {
            errors.rejectValue("username", "", "*field is required");
        }else{

            Optional<User> userMaybe = userRepository.findByUsername(dto.getUsername());
            if(userMaybe.isPresent()){
            errors.rejectValue("username","","*user with this username already exist");
            }
        }

        if (dto.getFirstName().isEmpty()) {
            errors.rejectValue("firstName", "", "*field is required");
        }

        if (dto.getLastName().isEmpty()) {
            errors.rejectValue("lastName", "", "*fild is required");
        }

        if (dto.getAge().isEmpty()) {
            errors.rejectValue("age", "", "*field is required");
        }

        if (dto.getEmail().isEmpty()) {
            errors.rejectValue("email", "", "*field is required");
        }else{

            Optional<User> userMaybe2 = userRepository.findByEmail(dto.getEmail());
            if(userMaybe2.isPresent()){
                errors.rejectValue("email","","*user with this email already exist");
            }
        }

        if (dto.getPassword().isEmpty()) {
            errors.rejectValue("password", "", "*field is required");
        }else if(dto.getPassword().length()<6){
            errors.rejectValue("password","","Password have exist atleast 6 character");
        }
    }
}
