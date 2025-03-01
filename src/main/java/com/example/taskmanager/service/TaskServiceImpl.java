package com.example.taskmanager.service;

import com.example.taskmanager.entity.Task;
import com.example.taskmanager.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    @Override
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    @Override
    public void createTask(Task newTask) {
        taskRepository.save(newTask);
    }

    @Override
    public void updateTask(Long id, Task updateTask) {
        taskRepository.save(updateTask);
    }

    @Override
    public Optional<Task> getTask(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public void removeTask(Long id) {
        taskRepository.deleteById(id);
    }
}
