package com.example.todolistgraphqlexample;


import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;



@Controller
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @QueryMapping
    public Iterable<Task> findAll() {
        return taskService.findAll();
    }

    @MutationMapping
    public Task createTask(@Argument String title, @Argument String description) {
        return taskService.createTask(title, description);
    }

}