package com.tannika.jira.controller;

import com.tannika.jira.model.*;
import com.tannika.jira.model.Module;
import com.tannika.jira.service.ModuleService;

import java.util.List;
import java.util.Map;

public class ModuleController {
    ModuleService moduleService = new ModuleService();
    public boolean addMilestoneToModule(Module module, MileStone mileStone){
        return moduleService.addMilestoneToModule(module, mileStone);
    }
    public List<Employee> getTeam(Module module){
        return moduleService.getTeam(module);
    }
    public Map<Task, Status> getAllStatus(Module module) { return moduleService.getAllStatus(module);}
    public boolean removeDeveloperFromModule(Module module, Employee developer){ return moduleService.removeDeveloperFromModule(module, developer); }
}
