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
                //Employee configuration
                .antMatchers(HttpMethod.POST, "**/employee/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "**/employee/read").hasRole("USER")
                .antMatchers(HttpMethod.PUT, "**/employee/update").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "**/employee/all").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "**/employee/delete").hasRole("ADMIN")
                //Restaurant configuration
                .antMatchers(HttpMethod.POST, "**/restaurant/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "**/restaurant/read").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "**/restaurant/update").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "**/restaurant/all").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "**/restaurant/delete").hasRole("ADMIN")
                //Job configuration
                .antMatchers(HttpMethod.POST,"**/job/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"**/job/read").hasRole("ADMIN, USER")
                .antMatchers(HttpMethod.PUT,"**/job/update").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"**/job/all").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"**/job/delete").hasRole("ADMIN")
                //Payment configuration
                .antMatchers(HttpMethod.POST, "**/payment/save").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.GET, "**/payment/read").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.PUT, "**/payment/update").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.GET, "**/payment/all").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.DELETE, "**/payment/delete").hasRole("ADMIN")
                // Reservation configuration
                .antMatchers(HttpMethod.POST, "**/reservation/save").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.GET, "**/reservation/read").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.PUT, "**/reservation/update").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.GET, "**/reservation/all").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.DELETE, "**/reservation/delete").hasRole("ADMIN")
                // Customer configuration
                .antMatchers(HttpMethod.POST, "**/customer/save").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.GET, "**/customer/read").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.PUT, "**/customer/update").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.GET, "**/customer/all").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.DELETE, "**/customer/delete").hasRole("ADMIN")
                // Receptionist configuration
                .antMatchers(HttpMethod.POST, "**/receptionist/save").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.GET, "**/receptionist/read").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.PUT, "**/receptionist/update").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.GET, "**/receptionist/all").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.DELETE, "**/receptionist/delete").hasRole("ADMIN")
                // Table configuration
                .antMatchers(HttpMethod.POST, "**/table/save").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.GET, "**/table/read").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.PUT, "**/table/update").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.GET, "**/table/all").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.DELETE, "**/table/delete").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }
}
