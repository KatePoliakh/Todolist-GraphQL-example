package com.example.todolistgraphqlexample.services;

import com.example.todolistgraphqlexample.dto.TaskDto;

import java.util.List;

public interface TaskService {
    TaskDto createTask(String title, String description);

    List<TaskDto> findAll();

    void deleteTask(Long id);
}
