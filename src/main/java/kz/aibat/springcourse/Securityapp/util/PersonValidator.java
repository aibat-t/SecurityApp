package kz.aibat.springcourse.Securityapp.util;


import kz.aibat.springcourse.Securityapp.models.Person;
import kz.aibat.springcourse.Securityapp.services.PersonDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class PersonValidator implements Validator {

    private final PersonDetailsService personDetailsService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;

        Optional<Person> personOptional = personDetailsService.getUserByUsername(person.getUsername());
        if(personOptional.isPresent()){
            errors.rejectValue("username","", "Человек с таким именем пользователя существует");
        }
    }
}
