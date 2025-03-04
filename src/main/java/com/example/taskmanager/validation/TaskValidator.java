package com.example.taskmanager.validation;

import com.example.taskmanager.entity.Task;
import com.example.taskmanager.exception.ErrorMessages;
import com.example.taskmanager.exception.InvalidTaskException;
import com.example.taskmanager.exception.TaskNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class TaskValidator {

    public static void validateTask(Task task) {
        if(task.getTitle() == null || task.getTitle().isEmpty()) {
            throw new InvalidTaskException(ErrorMessages.TITLE_CANNOT_BE_EMPTY);
        }

        if(task.getTitle().length() > 255) {
            throw new InvalidTaskException(ErrorMessages.TITLE_TOO_LONG);
        }

        if(task.getDescription() == null || task.getDescription().isEmpty()) {
            throw new InvalidTaskException(ErrorMessages.DESCRIPTION_CANNOT_BE_EMPTY);
        }

        if(task.getDescription().length() > 500) {
            throw new InvalidTaskException(ErrorMessages.DESCRIPTION_TOO_LONG);
        }
    }
}
