package com.mehmetberkan.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class BudgetMateSecurityConfig {

    @Bean
    public JwtTokenFilter jwtTokenFilter() {
        return new JwtTokenFilter();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        /**
         * Belli URL adreslerine, kullanıcılar tarafından girilmesine izin verilerek
         * belli adreslerin erişimi kapatılacak.
         * Erişimi kapatılan adreslere kontrollü erişim ve rol tabanlı erişim sağlanacak.
         */
        http.authorizeHttpRequests(req -> {
            req
                    .requestMatchers("/swagger-ui/**","v3/api-docs/**","/dev/v1/user/**") // belirli bir URL adresine erişimi yönet
                    .permitAll() // yukarıdaki adrese ve adreslere izin ver.

                   .requestMatchers("/dev/v1/category/**","/dev/v1/payment/**").hasAuthority("ROLE_ADMIN")
                   .requestMatchers("/dev/v1/payment/**").hasAuthority("ROLE_USER")
                    // Yukarıdaki, Oturum açanın yetki kimliği USER, ADMİN (VS)... tipindeyse erişime izin ver
                    .anyRequest() //yapılan tüm istek türleri(/admin ,/user,comment/getById...)
                    .authenticated(); // oturum açma zorunluluğu getirir.

        });
        http.csrf(AbstractHttpConfigurer::disable);
        /**
         * Kullanıcıların sisteme nasıl giriş yapılacakları. Yani kendi kimliklerini nasıl doğrulayacaklar.
         *
         */
        http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();

    }

}
