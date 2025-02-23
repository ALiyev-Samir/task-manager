package com.example.taskmanager.service;

import com.example.taskmanager.entity.Task;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    private final List<Task> tasks = new ArrayList<>();
    @Override
    public List<Task> getTasks() {
        return tasks;
    }

    @Override
    public void createTask(Task newTask) {
        tasks.add(newTask);
    }

    @Override
    public void updateTask(long id, Task updateTask) {
        tasks.stream()
           .filter(task -> task.getId().equals(id))
           .findFirst()
           .ifPresent(task -> {
                task.setTitle(updateTask.getTitle());
                task.setStatus(updateTask.getStatus());
           });

    }

    @Override
    public Optional<Task> getTask(long id) {
        return tasks.stream()
           .filter(task -> task.getId().equals(id))
           .findFirst();
    }

    @Override
    public void removeTask(long id) {
        tasks.removeIf(task -> task.getId().equals(id));
    }
}
