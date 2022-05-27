package com.tannika.jira.service;

import com.tannika.jira.exception.AddTaskToMilestoneException;
import com.tannika.jira.model.MileStone;
import com.tannika.jira.model.Task;

public class MileStoneService {
    public boolean addTask(MileStone mileStone, Task task){
        try {
            return mileStone.setTask(task);
        } catch (AddTaskToMilestoneException e) {
            throw new RuntimeException(e);
        }
    }
}
