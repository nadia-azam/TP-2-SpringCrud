package com.example.TP2;

import com.example.TP2.models.Task;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.TP2.repositories.TaskRepository;

import java.util.Date;

@SpringBootApplication
public class TP2Application {

    public static void main(String[] args) {
        SpringApplication.run(TP2Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(TaskRepository taskRepository){

        return args -> {
            taskRepository.save(new Task(null , "un book" , new Date() , new Date()));
            taskRepository.save(new Task(null , "un stylo" , new Date() , new Date()));
            taskRepository.save(new Task(null , "une histoire" , new Date() , new Date()));
            taskRepository.save(new Task(null , "un cahier" , new Date() , new Date()));


            taskRepository.findAll().forEach(task -> System.out.println(task));

            taskRepository.deleteById(1L);

            taskRepository.findAll().forEach(task -> System.out.println(task));





        };
    }


}
