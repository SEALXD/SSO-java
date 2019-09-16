package sso.resource_service.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration

@EnableResourceServer

public class ResourceServerConfigurer extends ResourceServerConfigurerAdapter {

//什么也不干，使用默认配置就可以了

}