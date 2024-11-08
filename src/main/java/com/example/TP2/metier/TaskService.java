package com.example.TP2.metier;

import com.example.TP2.models.Task;
import org.springframework.stereotype.Service;
import com.example.TP2.repositories.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private TaskRepository taskRepository ;

    public Task cretaeTask(Task task){
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id){
        return taskRepository.findById(id).orElse(null);
    }

    public Task updateTask(Long id , Task updatedTask){
        Optional<Task> optionalTask = taskRepository.findById(id); // optional pour un objet qui est soit null soit present
        if(optionalTask.isPresent()){
            Task existingTask = optionalTask.get();
            existingTask.setDescription(updatedTask.getDescription());
            existingTask.setDate_create(updatedTask.getDate_create());
            existingTask.setDate_echenace(updatedTask.getDate_echenace());

            return taskRepository.save(existingTask);


        }
        return null ;
    }


    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }

}
