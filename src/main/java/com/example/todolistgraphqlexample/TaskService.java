package com.example.todolistgraphqlexample;

import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(String title, String description) {
        try {
            Task task = new Task();
            task.setTitle(title);
            task.setDescription(description);
            task.setCompleted(false);
            return taskRepository.save(task);
        } catch (Exception e) {
            throw new RuntimeException("Error creating task", e);
        }

    }

    public Iterable<Task> findAll() {
        try {
            return taskRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving tasks", e);
        }
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

}
