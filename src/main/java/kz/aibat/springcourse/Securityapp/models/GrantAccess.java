package kz.aibat.springcourse.Securityapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name="grant_access")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GrantAccess implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="access_value")
    private String accessValue;

    @Override
    public String getAuthority() {
        return accessValue;
    }
}
