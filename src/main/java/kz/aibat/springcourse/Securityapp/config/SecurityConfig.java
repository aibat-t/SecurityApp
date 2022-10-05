package kz.aibat.springcourse.Securityapp.config;

import kz.aibat.springcourse.Securityapp.security.AuthProviderImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true, securedEnabled = true)
public class SecurityConfig {

    private final AuthProviderImpl authProvider;

    @Bean
    public AuthenticationManager configure(AuthenticationManagerBuilder auth) throws Exception{
        return new ProviderManager(authProvider);
    }
}
