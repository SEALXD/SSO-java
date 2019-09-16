package sso.center.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@Configuration

@EnableAuthorizationServer

public class AuthorizationConfig extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private TokenStore tokenStore;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception{
        clients.inMemory().withClient("client")
                .secret("111111")
                .resourceIds("oauth")
                .authorizedGrantTypes("authorization_code", "refresh_token")
                .redirectUris("http://localhost/callback")
                .scopes("all")
                .autoApprove(true);

    }
    /*
                .secret("111111")
                .resourceIds("oauth")
                .authorizedGrantTypes("authorization_code", "refresh_token")//设置验证方式
                .redirectUris("http://localhost/callback")//可指定也可以由客户端携带
                .scopes("all")
                .autoApprove(true);//默认登录后可直接授权
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("permitAll()");
    }


    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception{
        endpoints.tokenStore(tokenStore);
    }

    @Bean
    public TokenStore tokenStore(){
        //这里为了简单达到目的，直接使用内存存储Token和用户信息。
        return new InMemoryTokenStore();
    }

}

