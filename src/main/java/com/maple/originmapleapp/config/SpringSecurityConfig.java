package com.maple.originmapleapp.config;
import com.maple.originmapleapp.config.jwt.JWTFilter;
import com.maple.originmapleapp.config.jwt.TokenProvider;
import com.maple.originmapleapp.config.jwt.LoginFilter;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SpringSecurityConfig {

    private final AuthenticationConfiguration authenticationConfiguration;
    private final TokenProvider tokenProvider;




    //AuthenticationManager Bean 등록
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private static final String [] WHITE_LIST  = {
            "/auth/login",
            "/auth/signup",
            "/auth/signup.process",
            "/board/**",
            "/",
            "/css/**",
            "/logout",
            "/layout/**",
            "/resources/**"
    };

    private static final String [] ADMIN = {
            "/**"
    };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.cors(AbstractHttpConfigurer::disable);
        http.csrf(AbstractHttpConfigurer::disable);
        http.formLogin(AbstractHttpConfigurer::disable);
        http.httpBasic(AbstractHttpConfigurer::disable);

        http.authorizeHttpRequests((auth) -> auth
            // 해당 경로는 모든 권한의 접근을 허용 합니다.
            .requestMatchers(HttpMethod.GET).permitAll()
            .requestMatchers(WHITE_LIST).permitAll()
            // 해당 경로는 ADMIN 권한만 접근 허용 합니다.
            .requestMatchers(ADMIN).hasRole("ADMIN")
            .anyRequest().authenticated());
        http.addFilterBefore(new JWTFilter(tokenProvider), LoginFilter.class);
        //AuthenticationManager()와 JWTUtil 인수 전달
        http.addFilterAt(new LoginFilter(authenticationManager(authenticationConfiguration), tokenProvider), UsernamePasswordAuthenticationFilter.class);
        http.sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }
}



