package com.example.taskmanager.service;

import com.example.taskmanager.entity.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TaskService {
    public List<Task> getTasks();
    public void createTask(Task task);
    public void updateTask(long id, Task task);
    public Optional<Task> getTask(long id);
    public void removeTask(long id);
}
