package com.tannika.jira.controller;

import com.tannika.jira.model.Employee;
import com.tannika.jira.model.Status;
import com.tannika.jira.model.Task;
import com.tannika.jira.service.TaskService;

public class TaskController {

    private TaskService taskService = new TaskService();

    public boolean assignDeveloper(Task task, Employee developer) {
        return taskService.assignDeveloper(task, developer);
    }

    public boolean updateTaskStatus(Task task, Status status){
        return taskService.updateTaskStatus(task, status);
    }

}
