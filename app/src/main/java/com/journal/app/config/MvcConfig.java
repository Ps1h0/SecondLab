package com.journal.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/** Class configuration of application
 * @see WebMvcConfigurer
 * @author Nikita Platonov
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /** Defines the transition to pages by address
     * @param registry - to configure addressing
     * @see ViewControllerRegistry
     */
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/signin").setViewName("signin");
        registry.addViewController("/journal").setViewName("journal");
        registry.addViewController("/schedule").setViewName("schedule");
    }
}
