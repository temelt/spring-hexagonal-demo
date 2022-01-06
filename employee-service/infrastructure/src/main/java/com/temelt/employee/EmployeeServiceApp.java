package com.temelt.employee;

import com.temelt.Processor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@ComponentScan(
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Processor.class})
        }
)
@SpringBootApplication
public class EmployeeServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeServiceApp.class, args);
    }
}
