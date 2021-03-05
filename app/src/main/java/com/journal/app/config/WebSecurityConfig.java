package com.journal.app.config;


import com.journal.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/** Класс конфигурация безопасности приложения
 * @see WebSecurityConfigurerAdapter
 * @author Nikita Platonov
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /** Метод, определяющий, по каким адресам могут переходить авторизованные и неавторизованные пользователи,
     * переадресации страницы
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/index", "/css/**", "/js/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/signin").defaultSuccessUrl("/journal", true).permitAll()
                .and()
                .logout().logoutSuccessUrl("/").permitAll();
    }

    /** Метод, возвращающий декодировщик пароля пользователя
     * @see BCryptPasswordEncoder
     * @return BCryptPasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /** Метод, позволяющий проводить аутентификацию пользователей из базы данных с помощью декодировщика пароля,
     * установленного методом {@link #passwordEncoder()} и параметров пользователя, установленных методом
     * {@link #setUserService(UserService)}
     * @see DaoAuthenticationProvider
     * @return authenticationProvider
     */
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setUserDetailsService(userService);
        return authenticationProvider;
    }
}