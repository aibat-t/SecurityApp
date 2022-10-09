package kz.aibat.springcourse.Securityapp.services;

import kz.aibat.springcourse.Securityapp.models.Person;
import kz.aibat.springcourse.Securityapp.repositories.PeopleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final PeopleRepository peopleRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void register(Person person){
        person.setPassword(passwordEncoder.encode( person.getPassword()));
        peopleRepository.save(person);
    }
}
