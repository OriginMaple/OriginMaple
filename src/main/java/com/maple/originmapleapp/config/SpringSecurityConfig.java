package com.maple.originmapleapp.config;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SpringSecurityConfig {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    PasswordEncoder passwordEncoder() {
        return new SimplePasswordEncoder();
    }

        @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors(AbstractHttpConfigurer::disable)
            .csrf(AbstractHttpConfigurer::disable)
            .httpBasic(AbstractHttpConfigurer::disable)
            .formLogin(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(request -> request
                    .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                    .requestMatchers("/auth/login", "/auth/signup", "/board/**", "/", "/auth/signup.process").permitAll()
                    .anyRequest().authenticated()
                )
                .formLogin(login -> login
                        .loginPage("/auth/login")
                        .loginProcessingUrl("/auth/login.process")
                        .usernameParameter("member_email")
                        .passwordParameter("member_pw")
                        .defaultSuccessUrl("/", true)
                        .permitAll()
                )
                .logout(Customizer.withDefaults());

        return http.build();
    }
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.csrf(AbstractHttpConfigurer::disable)
//                .httpBasic(AbstractHttpConfigurer::disable)
//                .formLogin(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests((authorize) -> authorize
//                        .requestMatchers("/auth/login", "/auth/signup", "/board/**", "/", "/auth/signup.process").permitAll()
//                        .anyRequest().authenticated())
//                // 폼 로그인은 현재 사용하지 않음
////				.formLogin(formLogin -> formLogin
////						.loginPage("/auth/login")
////						.defaultSuccessUrl("/auth/login.process"))
//                .logout((logout) -> logout
//                        .logoutSuccessUrl("/login")
//                        .invalidateHttpSession(true))
//                .sessionManagement(session -> session
//                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                );
//        return http.build();
//    }
}