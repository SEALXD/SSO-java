package sso.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration

@EnableOAuth2Sso

@EnableGlobalMethodSecurity(prePostEnabled = true)//如果要做本地权限控制，必须加这条注解

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //必须注入这个bean，配合@EnableGlobalMethodSecurity注解控制用户访问权限
    @Autowired
    AuthenticationManager authenticationManager;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.headers().frameOptions().disable();//允许WEB的frame框架访问。
    }
}

