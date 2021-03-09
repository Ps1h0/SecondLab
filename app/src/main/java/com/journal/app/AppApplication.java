package com.journal.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

/** Точка выхода приложения
 * @author Danil Belonogov
 */

@SpringBootApplication
public class AppApplication {

    public static void main(String[] args) {

        SpringApplication.run(AppApplication.class, args);
    }
}
