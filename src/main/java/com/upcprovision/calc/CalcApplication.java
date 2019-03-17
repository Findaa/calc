package com.upcprovision.calc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class CalcApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalcApplication.class, args);

    }


}
