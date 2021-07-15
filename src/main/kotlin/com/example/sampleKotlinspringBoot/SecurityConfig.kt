package com.example.sampleKotlinspringBoot

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
class SecurityConfig : WebSecurityConfigurerAdapter() {

    @Bean
    fun encoder(): PasswordEncoder = BCryptPasswordEncoder()

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.inMemoryAuthentication()
            .withUser(DEFAULT_ADMIN)
            .password(encoder().encode(DEFAULT_PASSWORD))
            .roles("USER", "ADMIN")
            .and()
            .withUser(DEFAULT_USER)
            .password(encoder().encode(DEFAULT_PASSWORD))
            .roles("USER")
    }

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.httpBasic().and().authorizeRequests()
            .antMatchers(HttpMethod.GET, "/api/article/").hasAnyRole()
            .antMatchers(HttpMethod.GET, "/api/article/{slug}").hasAnyRole()
            .antMatchers(HttpMethod.GET, "/api/user/").hasRole("ADMIN")
            .antMatchers(HttpMethod.GET, "/api/user/{login}").hasRole("ADMIN")
            .and()
            .csrf().disable()
            .formLogin().disable()
    }

    companion object {
        private const val DEFAULT_PASSWORD = "pass"
        private const val DEFAULT_USER = "user"
        private const val DEFAULT_ADMIN = "admin"
    }
}