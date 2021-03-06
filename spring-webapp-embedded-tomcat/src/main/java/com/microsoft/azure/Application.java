package com.microsoft.azure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        LogWriter.writeLogs();

        SpringApplication.run(Application.class, args);
    }

}
