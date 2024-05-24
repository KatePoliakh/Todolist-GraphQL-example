package com.example.todolistgraphqlexample.controllers;

import com.example.todolistgraphqlexample.dto.TaskDto;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;

public interface TaskController {
    @QueryMapping
    Iterable<TaskDto> findAll();

    @MutationMapping
    TaskDto createTask(@Argument String title, @Argument String description);

}
