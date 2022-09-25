package za.ac.cput.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity

public class securityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);

        auth.inMemoryAuthentication()
                .withUser("Admin")
                .password("12345")
                .roles("ADMIN")
                .and()
                .withUser("Clerk")
                .password("1111")
                .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);

        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "**/employee/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "**/employee/read").hasRole("USER")
                .antMatchers(HttpMethod.GET, "**/employee/all").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }
}
