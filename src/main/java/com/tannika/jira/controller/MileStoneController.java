package com.tannika.jira.controller;


import com.tannika.jira.model.MileStone;
import com.tannika.jira.model.Task;
import com.tannika.jira.service.MileStoneService;

public class MileStoneController {
    MileStoneService mileStoneService = new MileStoneService();
    public boolean addTask(MileStone mileStone, Task task){
        return mileStoneService.addTask(mileStone, task);
    }
}
