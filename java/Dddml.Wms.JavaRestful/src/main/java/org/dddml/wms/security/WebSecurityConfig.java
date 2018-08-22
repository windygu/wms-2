package org.dddml.wms.security;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/**
 * SpringSecurity 的配置
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public JwtUtil jwtUtilBean() throws Exception {
        return new JwtUtil();
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilterBean() throws Exception {
        return new JwtAuthenticationFilter(authenticationManager());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests()
                //.antMatchers(HttpMethod.POST, "/users/signup").permitAll()
                //.antMatchers(HttpMethod.GET, "/**").permitAll()
                .anyRequest().authenticated()
                .and()
                //.addFilter(new JWTLoginFilter(authenticationManager()))
                .addFilter(jwtAuthenticationFilterBean());
    }


    //private UserDetailsService userDetailsService;
    //private BCryptPasswordEncoder bCryptPasswordEncoder;
    //public WebSecurityConfig(UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
    //this.userDetailsService = userDetailsService;
    //this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    //}

}