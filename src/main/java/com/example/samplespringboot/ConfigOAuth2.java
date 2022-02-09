package com.example.samplespringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class ConfigOAuth2 extends AuthorizationServerConfigurerAdapter {

//    @Value( "${google.id}" )
//    private String clientId;
//
//    @Value( "${google.secret}" )
//    private String secret;

    private String clientId = "admin";
    private String secret = "admin";

    private String privateKey = "-----BEGIN RSA PRIVATE KEY-----\n" +
            "MIIEowIBAAKCAQEAugEpfc1WUWXwZ+LKLQRbsXcyE+45sZyO9iokH2/QIiEKZjgC\n" +
            "wOK8d3oIj0jnlOozhAZBq7hC8V4qhW37J4rt2g+y6ZoP5GMIggexOj8lwMTDyxmO\n" +
            "rQo2vJW5YArUd7Wse2Bb7qTQiBDmnLePru8E/porglLKtZZgGBoFWT/91nYOZtcP\n" +
            "ceFnzvaQrw4+GHa5wRGi/4BHyooyhqARutNS1OKTpb2ZnyOXLqDsS6nivuViiUFU\n" +
            "rItv+v8mcTeazbu7hb+7W+omjUh6SzRUf1y2ItPvLwNw3fS7Sa7O1ENjN/Q1CnDA\n" +
            "GJq1sA88VNHdzebnsMTWZHe0qD5jWV9HH2AiRQIDAQABAoIBADiyq/weAGbVhP+V\n" +
            "wP0R7AVfiRNMNafvSiC9Xb97bN1KZwobnrM/KiXdPAi5N2ZMMaHX6mK2yykaBCoi\n" +
            "CUHXdoNW77mHbbq3eVtxjtNrdk2ZbPlW9AfJKkA3/4bIJlXLOiVtjPhkovAm/rTc\n" +
            "u16em04knoieRg4uJWKTY/f9qpmZY7JF4pP/oae8UCgBBc3uVxxSXylT45nuk8WD\n" +
            "G9Qsml220c4Yy9MG4BNmn9Q+o+4aoAr1RiqE4Sx44lZmsMaPA/CWr/y+ZauWU5sD\n" +
            "u33IxCDx+yOdmlD8JqUwtp8as7zJezTOEAmP+Hgksec34h4jxrNwDOxJ2SoYlkbl\n" +
            "z9h7o20CgYEA5sttE+HC0RmwE5PxvFr7qqUK6CGOuhH8RhdLngAqDMj3rwJq2Tv1\n" +
            "orMdJqF3FnuTC6eBQWPF4cmky4BXWAUjcx0VLmVavKE6ElU3jAN7dloOq2Co4E6/\n" +
            "KTzOJAL3TEj1E1IrwvcElZmen9714z66BCpEibOXTFbkgtmuJSDYsJ8CgYEAzlF9\n" +
            "u2n0WxORC9UW3uqtKgMOl42r4Xr259vfS52KZV/gmKKFYjBFOaprpt9peeSjpaI8\n" +
            "hISXHmfDehpK+tAU0qjIen3XKH2A6oaff4kqW7yle7WI8SzMhSDw3hQvngUwXbOw\n" +
            "8TFSpHzxX4B1tnyypqpcKErwM8cvjtMDH/CrjpsCgYEApsLyS91ioSgIe/z4PHsZ\n" +
            "QVIDsXsd4ADC4fpPHxlLSPWlUgVTIygZ8retJo6gt9QOies8j/0BrIXA13Iiqmz8\n" +
            "El8/QMjnaUit5zU/76FMglXMJ7SuEXWU1r0izg5+ldZZjt5e1H8cBuR7I1U9Ijfe\n" +
            "vMe1wjHL7tMSRiH3nMhBCk0CgYA8bM2AKCXyzqY6auxJ2T1iAocxh8KBRTwu58xc\n" +
            "HwW7bvseeOrLuQttOiZRNzlzA62SAxPqU9LWitlLV4wCLRMMJ3afuV9ccnVhOpBY\n" +
            "D9oiB/wHYUF8MPytONqSkCLqCucBanE2EpX7qsQejkbrbVX9TgOzoU78OygIknBl\n" +
            "2FzGZQKBgBbBUoorHKmd+6W3o+IursL13xeBo1PjeiwEQfUz/PaEPLYRE1W4yUQG\n" +
            "PSWbXsat6DK8WfKPtSLSpwAA6VhXRPM83SZEDTrPVXKB7SduGyQpYXQmbu1zXBIh\n" +
            "Gf1qIZAeNoV0TBJCAAdA4nofU+hJ5SIw1cmqXTtSxWWOlCQiHFJW\n" +
            "-----END RSA PRIVATE KEY-----";
    private String publicKey = "-----BEGIN PUBLIC KEY-----\n" +
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAugEpfc1WUWXwZ+LKLQRb\n" +
            "sXcyE+45sZyO9iokH2/QIiEKZjgCwOK8d3oIj0jnlOozhAZBq7hC8V4qhW37J4rt\n" +
            "2g+y6ZoP5GMIggexOj8lwMTDyxmOrQo2vJW5YArUd7Wse2Bb7qTQiBDmnLePru8E\n" +
            "/porglLKtZZgGBoFWT/91nYOZtcPceFnzvaQrw4+GHa5wRGi/4BHyooyhqARutNS\n" +
            "1OKTpb2ZnyOXLqDsS6nivuViiUFUrItv+v8mcTeazbu7hb+7W+omjUh6SzRUf1y2\n" +
            "ItPvLwNw3fS7Sa7O1ENjN/Q1CnDAGJq1sA88VNHdzebnsMTWZHe0qD5jWV9HH2Ai\n" +
            "RQIDAQAB\n" +
            "-----END PUBLIC KEY-----";


    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Bean
    public JwtAccessTokenConverter tokenEnhancer() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(privateKey);
        converter.setVerifierKey(publicKey);
        return converter;
    }

    @Bean
    public JwtTokenStore tokenStore() {
        return new JwtTokenStore(tokenEnhancer());
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager).tokenStore(tokenStore())
                .accessTokenConverter(tokenEnhancer());
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory().withClient(clientId).secret(passwordEncoder.encode(secret)).scopes("read", "write")
                .authorizedGrantTypes("password", "refresh_token").accessTokenValiditySeconds(20000)
                .refreshTokenValiditySeconds(20000);

    }


}
