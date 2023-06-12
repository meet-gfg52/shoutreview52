package com.gfg.jbdl52.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.annotation.web.servlet.configuration.WebMvcSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {





    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {

        security.csrf().disable().authorizeRequests()
                .requestMatchers(request -> {
                   return "/movie".equals(request.getServletPath()) && HttpMethod.GET.matches(request.getMethod());
                }).hasAnyAuthority("user","admin")
                .requestMatchers(request -> {
                    return "/movie".equals(request.getServletPath()) && HttpMethod.POST.matches(request.getMethod());
                }).hasAuthority("admin")
                .requestMatchers("/review/**").hasAuthority("user")
                .requestMatchers("/greet/admin/**").hasAuthority("admin")
                .requestMatchers("/greet/**").hasAuthority("user")
                .requestMatchers("/signup").permitAll()
                .and()
                .formLogin(new Customizer<FormLoginConfigurer<HttpSecurity>>() {
                    @Override
                    public void customize(FormLoginConfigurer<HttpSecurity> httpSecurityFormLoginConfigurer) {

                    }
                });

        return security.build();

        /**
         * .and().httpBasic(new Customizer<HttpBasicConfigurer<HttpSecurity>>() {
         *                     @Override
         *                     public void customize(HttpBasicConfigurer<HttpSecurity> httpSecurityHttpBasicConfigurer) {
         *
         *                     }
         *                 });
         *
         *                */
    }


    /**
     * By default spring security will secure all the apis present in all the controllers.
     *
     * Till Spring security v4 , WebSecurityConfigurationProvider.
     *
     * After Spring 5+
     * We have to overload HTTPSecurity ,Filterchain
     *
     *
     * Password encoder and AutheticationConfiguration.
     * */


    /***
     *  1. get the user signed up and store username , password in DB 0 -> UserDetail
     *  2. create a login page. -> not mandatory
     *  3. Take username from Request form the DB. -> UserDetailService
     *  4. Compare the passwords -> passwordEncoder
     *  5. If valid return token else return exception -> AuthenticationManager
     *  6. check if user is authorized to call API. -> FilterChain
     *
     *
     * user_table
     * user  password
     * john  kslkgssdfsdfs  ( original = abc)
     *
     * user=john
     * password=pqr -> fksfnksf
     *
     * incase of correct password
     * kslkgssdfsdfs==kslkgssdfsdfs
     *
     * incase of wrong password:
     * fksfnksf==kslkgssdfsdfs
     *
     *
     * */


    /***
     *
     *Hash vs encrypt
     * hash
     *( abc -> hash(any function) ioieufosih)
     *
     * encrypt-decrypt
     *( abc -> encrypt (any function) fskdfslkfj
     * (fskdfslkfj -> decrypt (,,)  abc )
     * */

    /***
     * password table (
      user-id,password
     1234       lkfjlskjdfs(hash of mypassword)

     principle table
     username,email,phone,user-id

     basic

     select user-id, password from principle_table,password_table where username=principle or email=principle or  phone=principle and user_id=password_table.user-id
     *
     * */
}
