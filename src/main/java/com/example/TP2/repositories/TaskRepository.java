package com.example.TP2.repositories;

import com.example.TP2.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepository extends JpaRepository<Task , Long> {
}
