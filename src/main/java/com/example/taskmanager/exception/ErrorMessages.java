package com.example.taskmanager.exception;


public class ErrorMessages {

    public static final String TASK_NOT_FOUND = "Task with ID %d not found.";
    public static final String INVALID_TASK = "Invalid task data provided.";
    public static final String ID_MISMATCH = "ID in URL does not match ID in the task body.";
    public static final String TASK_CANNOT_BE_DELETED = "Task with ID %d cannot be deleted.";
    public static final String TASK_CANNOT_BE_UPDATED = "Task with ID %d cannot be updated.";
    public static final String TITLE_CANNOT_BE_EMPTY = "Title cannot be empty.";
    public static final String TITLE_TOO_LONG = "Title cannot exceed 255 characters.";
    public static final String DESCRIPTION_CANNOT_BE_EMPTY = "Description cannot be empty.";
    public static final String DESCRIPTION_TOO_LONG = "Description cannot exceed 500 characters.";

}
