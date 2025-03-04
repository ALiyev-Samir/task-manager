package com.example.taskmanager.service;

import com.example.taskmanager.entity.Task;
import com.example.taskmanager.exception.ErrorMessages;
import com.example.taskmanager.exception.InvalidTaskException;
import com.example.taskmanager.exception.TaskNotFoundException;
import com.example.taskmanager.repository.TaskRepository;
import com.example.taskmanager.validation.TaskValidator;
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
        TaskValidator.validateTask(newTask);
        taskRepository.save(newTask);
    }

    @Override
    public void updateTask(Long id, Task updateTask) {
        if(!taskRepository.existsById(id)) {
            throw new TaskNotFoundException(String.format(ErrorMessages.TASK_NOT_FOUND, id));
        }
        TaskValidator.validateTask(updateTask);
        if (!id.equals(updateTask.getId())) {
            throw new IllegalArgumentException(ErrorMessages.ID_MISMATCH);
        }
        taskRepository.save(updateTask);
    }

    @Override
    public Task getTask(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(String.format(ErrorMessages.TASK_NOT_FOUND, id)));
    }

    @Override
    public void removeTask(Long id) {
        if(!taskRepository.existsById(id)) {
            throw new TaskNotFoundException(String.format(ErrorMessages.TASK_NOT_FOUND, id));
        }
        taskRepository.deleteById(id);
    }

}
