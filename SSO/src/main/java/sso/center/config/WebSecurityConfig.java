package sso.center.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import sso.center.service.MyUserDetailsService;

@Configuration

@EnableWebSecurity

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    MyUserDetailsService myUserDetailsService; //自定义 要注入的用户信息

    @Override

    public void configure(HttpSecurity http) throws Exception {

        http

                .authorizeRequests()

                .antMatchers("/user**","/oauth/check_token**")

                .permitAll()

                .anyRequest()

                .authenticated()

                .and()

                .formLogin().permitAll();

    }

    @Override

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(myUserDetailsService);

    }

}
