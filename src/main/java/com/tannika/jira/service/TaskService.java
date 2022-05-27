package com.tannika.jira.service;

import com.tannika.jira.exception.TaskUpdationException;
import com.tannika.jira.model.Employee;
import com.tannika.jira.model.Status;
import com.tannika.jira.model.Task;

public class TaskService {
    public boolean updateTaskStatus(Task task, Status status){
        try {
            return task.updateStatus(status);
        } catch (TaskUpdationException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean assignDeveloper(Task task, Employee employee) {
        return task.setDeveloper(employee);
    }
}
