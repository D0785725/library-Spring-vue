//package bin.javaproject.librarysystemtest.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//public class SecurityConfig {
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//       http
//               .authorizeHttpRequests( authorizeRequests -> authorizeRequests
//                       .requestMatchers("/users/register").permitAll()
//                       .requestMatchers("/books/**","/borrowing-records/**").authenticated()
//                       .anyRequest().authenticated()
//
//               )
//               .formLogin(from -> from
//                       .loginPage("/login")
//                       .defaultSuccessUrl("/books")
//                       .permitAll()
//               )
//               .logout(logout -> logout
//                       .permitAll()
//               )
//               .csrf(csrf -> csrf.disable());
//       return http.build();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user = User.builder()
//                .username("admin")
//                .password(passwordEncoder().encode("admin_password"))
//                .roles("USER", "ADMIN") // 設定用戶角色
//                .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder(); // 使用 BCryptPasswordEncoder 進行密碼加密
//    }
//}
