package com.tannika.jira.model;

import com.tannika.jira.exception.AddTaskToMilestoneException;

import java.util.ArrayList;
import java.util.List;

public class MileStone {
    private final int id;
    private List<Task> tasks;

    public int getId() {
        return id;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public boolean setTask(Task task) throws AddTaskToMilestoneException {
        if(task != null){
            this.tasks.add(task);
            return true;
        }
        else {
            throw new AddTaskToMilestoneException("Task is null");
        }
    }

    public MileStone(int id) {
        this.id = id;
        this.tasks = new ArrayList<Task>();
    }
}
