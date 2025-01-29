package com.psr.spring_demo_reactive;

import com.psr.spring_demo_reactive.student.Student;
import com.psr.spring_demo_reactive.student.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDemoReactiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDemoReactiveApplication.class, args);
    }

    // Create seed data
    /*@Bean
    public CommandLineRunner commandLineRunner(
            StudentService service
    ) {
        return args -> {
            for (int i = 0; i < 100; i++) {
                service.save(
                        Student.builder()
                                .firstName("Samrach + " + i)
                                .lastName("Kong + " + i)
                                .age(i)
                                .build()
                ).subscribe();
            }
        };
    }*/
}
