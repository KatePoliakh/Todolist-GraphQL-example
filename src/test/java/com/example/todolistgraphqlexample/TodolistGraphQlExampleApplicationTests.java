package com.example.todolistgraphqlexample;

import com.example.todolistgraphqlexample.dto.TaskDto;
import com.example.todolistgraphqlexample.entities.Task;
import com.example.todolistgraphqlexample.repositories.TaskRepository;
import com.example.todolistgraphqlexample.services.TaskServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TodolistGraphQlExampleApplicationTests {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskServiceImpl taskServiceImpl;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateTask() {
        // Arrange
        String title = "Test Title";
        String description = "Test Description";
        Task task = new Task(title, description);
        task.setCompleted(false);
        Task savedTask = new Task(title, description);
        savedTask.setId(1L);
        when(taskRepository.save(any(Task.class))).thenReturn(savedTask);

        // Act
        TaskDto taskDto = taskServiceImpl.createTask(title, description);

        // Assert
        assertNotNull(taskDto);
        assertEquals(1L, taskDto.getId());
        assertEquals(title, taskDto.getTitle());
        assertEquals(description, taskDto.getDescription());
        assertFalse(taskDto.isCompleted());

        ArgumentCaptor<Task> taskArgumentCaptor = ArgumentCaptor.forClass(Task.class);
        verify(taskRepository, times(1)).save(taskArgumentCaptor.capture());
        Task capturedTask = taskArgumentCaptor.getValue();
        assertEquals(title, capturedTask.getTitle());
        assertEquals(description, capturedTask.getDescription());
        assertFalse(capturedTask.isCompleted());
    }

    @Test
    public void testFindAll() {
        // Arrange
        Task task1 = new Task("Title 1", "Description 1");
        task1.setId(1L);
        task1.setCompleted(false);
        Task task2 = new Task("Title 2", "Description 2");
        task2.setId(2L);
        task2.setCompleted(true);
        when(taskRepository.findAll()).thenReturn(Arrays.asList(task1, task2));

        // Act
        List<TaskDto> taskDtos = taskServiceImpl.findAll();

        // Assert
        assertNotNull(taskDtos);
        assertEquals(2, taskDtos.size());

        TaskDto taskDto1 = taskDtos.get(0);
        assertEquals(1L, taskDto1.getId());
        assertEquals("Title 1", taskDto1.getTitle());
        assertEquals("Description 1", taskDto1.getDescription());
        assertFalse(taskDto1.isCompleted());

        TaskDto taskDto2 = taskDtos.get(1);
        assertEquals(2L, taskDto2.getId());
        assertEquals("Title 2", taskDto2.getTitle());
        assertEquals("Description 2", taskDto2.getDescription());
        assertTrue(taskDto2.isCompleted());
    }

    @Test
    public void testDeleteTask() {
        // Arrange
        Long taskId = 1L;

        // Act
        taskServiceImpl.deleteTask(taskId);

        // Assert
        verify(taskRepository, times(1)).deleteById(taskId);
    }
}
