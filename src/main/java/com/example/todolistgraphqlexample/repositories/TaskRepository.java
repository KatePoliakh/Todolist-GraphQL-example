package com.example.todolistgraphqlexample.repositories;

import com.example.todolistgraphqlexample.entities.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
}
