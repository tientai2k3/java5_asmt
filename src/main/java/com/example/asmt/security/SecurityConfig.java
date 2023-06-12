package com.example.asmt.security;

import com.example.asmt.entity.Account;
import com.example.asmt.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity(debug = false)
public class SecurityConfig implements WebMvcConfigurer {
    @Autowired
    private IAccountService accountService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // @formatter:off
        http
                .authorizeHttpRequests((authorize) -> authorize
                .requestMatchers("/shop-dong-ho/").permitAll()
                .requestMatchers("/shop-dong-ho/detail/*").permitAll()
                .requestMatchers("/shop-dong-ho/*").hasAnyRole("USER", "ADMIN")
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
        )
                .httpBasic(withDefaults())
                .formLogin(withDefaults())
                .logout()
                .logoutUrl("/logout") // Đường dẫn xử lý yêu cầu đăng xuất
                .logoutSuccessUrl("/shop-dong-ho") // Đường dẫn sau khi đăng xuất thành công
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .and()
                .exceptionHandling()
                .accessDeniedHandler((request, response, accessDeniedException) ->
                        {
                            response.sendRedirect("/shop-dong-ho");
                        }
                )
        ;

        // @formatter:on
        return http.build();
    }


    // @formatter:off
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        String tenUser = "USER";
        String tenAdmin = "ADMIN";
        List<Account> adminList = accountService.findAccountByChucVu_Ten(tenAdmin);
        List<Account> userList = accountService.findAccountByChucVu_Ten(tenUser);
        List<UserDetails> userDetailsList = new ArrayList<>();
        for (Account account : userList) {
            UserDetails user = User.withDefaultPasswordEncoder()
                    .username(account.getEmail())
                    .password(account.getMatKhau())
                    .roles("USER")
                    .build();
            userDetailsList.add(user);
        }

        for (Account account : adminList) {
            UserDetails user = User.withDefaultPasswordEncoder()
                    .username(account.getEmail())
                    .password(account.getMatKhau())
                    .roles("ADMIN")
                    .build();
            userDetailsList.add(user);
        }

        return new InMemoryUserDetailsManager(userDetailsList);
    }
    // @formatter:on


}
