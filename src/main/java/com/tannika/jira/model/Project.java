package com.tannika.jira.model;

import com.tannika.jira.exception.AddMilestoneToModuleException;
import com.tannika.jira.exception.AddModuleToProjectException;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private final double id;
    private String name;
    private Employee manager;
    private List<Module> modules;

    public List<Module> getModules() {
        return modules;
    }

    public boolean addModules(Module module) throws AddModuleToProjectException {
        if(module != null){
            this.modules.add(module);
            return true;
        }
        else {
            throw new AddModuleToProjectException("Module is null");
        }
    }

    public Project(double id, String name) {
        this.id = id;
        this.name = name;
        this.modules = new ArrayList();
    }

    public String getName() {
        return name;
    }

    public double getId() {
        return id;
    }

    public Employee getManager() {
        return manager;
    }

    public boolean setManager(Employee manager) {
        if(manager != null){
            this.manager = manager;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", manager=" + manager +
                ", modules=" + modules +
                '}';
    }
}
