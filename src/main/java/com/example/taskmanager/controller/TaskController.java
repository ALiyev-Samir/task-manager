package com.example.taskmanager.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @PostMapping
    public ResponseEntity<String> createTask() {
        return ResponseEntity.ok("Создание задачи работает");
    }

    @GetMapping
    public ResponseEntity<String> getAllTasks() {
        return ResponseEntity.ok("Получение всех задач работает");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTask(@PathVariable Long id) {
        return ResponseEntity.ok("Обновление задачи " + id + " работает");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id) {
        return ResponseEntity.ok("Удаление задачи " + id + " работает");
    }
}
