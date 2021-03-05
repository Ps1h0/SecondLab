package com.journal.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/** Класс конфигурация приложения
 * @see WebMvcConfigurer
 * @author Nikita Platonov
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /** Метод, определяющий переход к страницам по адресу
     * @param registry
     */
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/signin").setViewName("signin");
        registry.addViewController("/journal").setViewName("journal");
        registry.addViewController("/schedule").setViewName("schedule");
    }
}
