package com.tannika.jira.service;

import com.tannika.jira.exception.AddMilestoneToModuleException;
import com.tannika.jira.exception.RemoveDeveloperException;
import com.tannika.jira.model.*;
import com.tannika.jira.model.Module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModuleService {
    public boolean addMilestoneToModule(Module module, MileStone mileStone){
        try {
            return module.addMileStone(mileStone);
        } catch (AddMilestoneToModuleException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Employee> getTeam(Module module){
        List<Employee> developers = new ArrayList<Employee>();
        List<MileStone> mileStones = module.getMileStones();
        for (MileStone mileStone : mileStones){
            List<Task> tasks = mileStone.getTasks();
            for (Task task : tasks) {
                developers.add(task.getDeveloper());
            }
        }
        return developers;
    }

    public Map<Task, Status> getAllStatus(Module module) {
        Map<Task, Status> taskStatus = new HashMap<Task, Status>();
        List<MileStone> mileStones = module.getMileStones();
        for (MileStone mileStone : mileStones){
            List<Task> tasks = mileStone.getTasks();
            for (Task task : tasks) {
                taskStatus.put(task,task.getStatus());
            }
        }
        return taskStatus;
    }

    public boolean removeDeveloperFromModule(Module module, Employee developer){
        List<MileStone> mileStones = module.getMileStones();
        boolean isDeveloperRemoved = false;
        for (MileStone mileStone : mileStones){
            List<Task> tasks = mileStone.getTasks();
            for (Task task : tasks) {
                if(task.getDeveloper() == developer) {
                    try {
                        task.removeDeveloper();
                    } catch (RemoveDeveloperException e) {
                        throw new RuntimeException(e);
                    }
                    isDeveloperRemoved = true;
                }
            }
        }
        return isDeveloperRemoved;
    }
}
