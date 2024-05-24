package com.example.todolistgraphqlexample.services;

import com.example.todolistgraphqlexample.dto.TaskDto;
import com.example.todolistgraphqlexample.entities.Task;
import com.example.todolistgraphqlexample.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public TaskDto createTask(String title, String description) {
            Task task = new Task(title, description);
            task.setCompleted(false);
            Task savedTask = taskRepository.save(task);
            return new TaskDto(savedTask.getId(), savedTask.getTitle(), savedTask.getDescription(), savedTask.isCompleted());
    }

    @Override
    public List<TaskDto> findAll() {
            Iterable<Task> tasks = taskRepository.findAll();
            List<TaskDto> taskDtos = new ArrayList<>();
            for (Task task : tasks) {
                taskDtos.add(new TaskDto(task.getId(), task.getTitle(), task.getDescription(), task.isCompleted()));
            }
            return taskDtos;
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

}
