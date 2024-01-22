package com.bookMngr.common.config.security;


import com.bookMngr.common.auth.UserAuthHolderService;
import com.bookMngr.common.auth.UserAuthProvider;
import com.bookMngr.common.config.security.filter.JwtAuthenticationFilter;
import com.bookMngr.common.config.security.filter.LogFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-24        koiw1       최초 생성
 */
@Configuration
public class SecurityConfig {

    private final UserAuthProvider userAuthProvider ;
    private final UserAuthHolderService userAuthHolderService ;

    public SecurityConfig(UserAuthProvider userAuthProvider, UserAuthHolderService userAuthHolderService) {
        this.userAuthProvider = userAuthProvider;
        this.userAuthHolderService = userAuthHolderService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        this.defaultSetHttpSecurity(http) ;

        return http.authorizeRequests()
                .antMatchers("/**/**/bo/manager/**").hasAnyAuthority("ROLE_M", "ROLE_C")
                .antMatchers("/**/**/bo/company/**").hasAuthority("ROLE_C")
                .antMatchers("/*/**").permitAll()
                .and()
                .build() ;
    }

    private HttpSecurity defaultSetHttpSecurity(HttpSecurity http) throws Exception {

        http.httpBasic().disable()
                .formLogin().disable()
                .cors()
                .and()
                .csrf().disable()
                .headers().frameOptions().sameOrigin().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(new LogFilter(), LogoutFilter.class)
                .addFilterBefore(new JwtAuthenticationFilter(userAuthProvider, userAuthHolderService) , UsernamePasswordAuthenticationFilter.class) ;

        return http;
    }

}
