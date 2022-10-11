package kz.aibat.springcourse.Securityapp.repositories;

import kz.aibat.springcourse.Securityapp.models.GrantAccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrantAccessRepository extends JpaRepository<GrantAccess, Long> {
    GrantAccess findByAccessValue(String accessValue);
}
