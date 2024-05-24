package com.example.todolistgraphqlexample.controllers;


import com.example.todolistgraphqlexample.dto.TaskDto;
import com.example.todolistgraphqlexample.services.TaskServiceImpl;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;



@Controller
public class TaskControllerImpl implements TaskController {

    private final TaskServiceImpl taskService;

    public TaskControllerImpl(TaskServiceImpl taskService) {
        this.taskService = taskService;
    }

    @Override
    @QueryMapping
    public Iterable<TaskDto> findAll() {
        return taskService.findAll();
    }

    @Override
    @MutationMapping
    public TaskDto createTask(@Argument String title, @Argument String description) {
        return taskService.createTask(title, description);
    }

}