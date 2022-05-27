package com.tannika.jira.service;

import com.tannika.jira.exception.AddModuleToProjectException;
import com.tannika.jira.model.*;
import com.tannika.jira.model.Module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectService {
    ModuleService moduleService = new ModuleService();
    public boolean createProject(String projectName) {
        double id = Math.random();
        Project project = new Project(id, projectName);
        if(project != null)
            return true;
        else return false;
    }
    public boolean addModuleToProject(Project project, Module module) {
        try {
            return project.addModules(module);
        }catch (AddModuleToProjectException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean assignProjectManager(Project project, Employee manager) { return project.setManager(manager);}
    public List<Employee> getDevelopers(Project project) {
        List<Employee> developers = new ArrayList<>();
        List<Module> modules = project.getModules();
        for(Module module : modules){
            developers.addAll(moduleService.getTeam(module));
        }
        return developers;
    }
    public Map<Task, Status> getStatus(Project project) {
        Map<Task, Status> taskStatus = new HashMap<>();
        List<Module> modules = project.getModules();

        for(Module module : modules){
            taskStatus.putAll(moduleService.getAllStatus(module));
        }
        return taskStatus;
    }



}
