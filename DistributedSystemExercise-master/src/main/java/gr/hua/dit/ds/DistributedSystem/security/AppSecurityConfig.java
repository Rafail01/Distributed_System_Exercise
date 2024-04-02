package gr.hua.dit.ds.DistributedSystem.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    private AuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    public AppSecurityConfig(AuthenticationSuccessHandler authenticationSuccessHandler) {
        this.authenticationSuccessHandler = authenticationSuccessHandler;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder())
                .usersByUsernameQuery("select email, password, enabled from user_security where email=?")
                .authoritiesByUsernameQuery("select email, authority from authorities where email=?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
                .antMatchers("/","/api","/login").permitAll()
                .antMatchers("/AdministratorController/**").hasRole("ADMIN")
                .antMatchers("/MunicipalEmployeeController/**").hasRole("MUNICIPAL")
                .antMatchers("/VeterinaryController/**").hasRole("VET")
                .antMatchers("/CitizenController/**").hasRole("CITIZEN")
                .anyRequest().authenticated()
                .and().csrf().disable().headers().frameOptions().disable()
                .and().formLogin().successHandler(authenticationSuccessHandler).permitAll().and().logout().invalidateHttpSession(true)
                .clearAuthentication(true).permitAll();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
        web.ignoring().antMatchers("/");

    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }


}