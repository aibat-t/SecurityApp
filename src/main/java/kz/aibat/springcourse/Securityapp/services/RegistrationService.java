package kz.aibat.springcourse.Securityapp.services;

import kz.aibat.springcourse.Securityapp.models.GrantAccess;
import kz.aibat.springcourse.Securityapp.models.Person;
import kz.aibat.springcourse.Securityapp.repositories.GrantAccessRepository;
import kz.aibat.springcourse.Securityapp.repositories.PeopleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final PeopleRepository peopleRepository;
    private final PasswordEncoder passwordEncoder;
    private final GrantAccessRepository grantAccessRepository;

    @Transactional
    public void register(Person person){
        person.setPassword(passwordEncoder.encode( person.getPassword()));
        GrantAccess userAccess = grantAccessRepository.findByAccessValue("ROLE_USER");
        person.setGrantAccessList(Collections.singletonList(userAccess));
        peopleRepository.save(person);
    }
}
