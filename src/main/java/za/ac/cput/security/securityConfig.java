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
                .antMatchers(HttpMethod.POST, "**/employeeContact/save").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.GET, "**/employeeContact/read").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.PUT, "**/employeeContact/update").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.GET, "**/employeeContact/all").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.DELETE, "**/employeeContact/delete").hasRole("ADMIN")
                //Payment configuration
                .antMatchers(HttpMethod.POST, "**/contactType/save").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.GET, "**/contactType/read").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.PUT, "**/contactType/update").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.GET, "**/contactType/all").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.DELETE, "**/contactType/delete").hasRole("ADMIN")
                //Payment configuration
                .antMatchers(HttpMethod.POST, "**/payment/save").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.GET, "**/payment/read").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.PUT, "**/payment/update").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.GET, "**/payment/all").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.DELETE, "**/payment/delete").hasRole("ADMIN")
                //Payment configuration
                .antMatchers(HttpMethod.POST, "**/employeeGender/save").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.GET, "**/employeeGender/read").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.PUT, "**/employeeGender/update").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.GET, "**/employeeGender/all").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.DELETE, "**/employeeGender/delete").hasRole("ADMIN")
                //Payment configuration
                .antMatchers(HttpMethod.POST, "**/gender/save").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.GET, "**/gender/read").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.PUT, "**/gender/update").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.GET, "**/gender/all").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.DELETE, "**/gender/delete").hasRole("ADMIN")
                //EmployeeRace configuration
                .antMatchers(HttpMethod.POST, "**/employeeRace/save").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.GET, "**/employeeRace/read").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.PUT, "**/employeeRace/update").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.GET, "**/employeeRace/all").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.DELETE, "**/employeeRace/delete").hasRole("ADMIN")
                //Race configuration
                .antMatchers(HttpMethod.POST, "**/race/save").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.GET, "**/race/read").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.PUT, "**/race/update").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.GET, "**/race/all").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.DELETE, "**/race/delete").hasRole("ADMIN")
                //Order configuration
                .antMatchers(HttpMethod.POST, "**/order/save").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.GET, "**/order/read").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.PUT, "**/order/update").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.GET, "**/order/all").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.DELETE, "**/order/delete").hasRole("ADMIN")
                //Ingredients configuration
                .antMatchers(HttpMethod.POST, "**/ingredients/save").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.GET, "**/ingredients/read").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.PUT, "**/ingredients/update").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.GET, "**/ingredients/all").hasRole("USER, ADMIN")
                .antMatchers(HttpMethod.DELETE, "**/ingredients/delete").hasRole("ADMIN")

                .and()
                .csrf().disable()
                .formLogin().disable();
    }
}
