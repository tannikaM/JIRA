package com.tannika.jira.controller;

import com.tannika.jira.model.*;
import com.tannika.jira.model.Module;
import com.tannika.jira.service.ProjectService;

import java.util.List;
import java.util.Map;

public class ProjectController {
    ProjectService projectService = new ProjectService();
    public boolean createProject(String projectName) { return projectService.createProject(projectName); }
    public boolean addModuleToProject(Project project, Module module) { return projectService.addModuleToProject(project, module); }
    public boolean assignProjectManager(Project project, Employee manager) { return projectService.assignProjectManager(project, manager); }
    public List<Employee> getDevelopers(Project project) { return projectService.getDevelopers(project);}
    public Map<Task, Status> getStatus(Project project) { return projectService.getStatus(project); }
}
