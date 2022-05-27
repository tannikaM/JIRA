package com.tannika.jira.model;

import com.tannika.jira.exception.RemoveDeveloperException;
import com.tannika.jira.exception.TaskUpdationException;

public class Task {
    private final int id;
    private Employee employee;
    private Status status;
    private String taskDescription;

    public Task(int id) {
        this.id = id;
        this.status = status.NOT_STARTED;
    }

    public int getId() {
        return id;
    }

    public Employee getDeveloper() {
        return employee;
    }

    public boolean setDeveloper(Employee employee) {
        if(employee != null){
            this.employee = employee;
            return true;
        }
         return false;
    }

    public Status getStatus() {
        return status;
    }

    public boolean updateStatus(Status status) throws TaskUpdationException {
        if(status.equals(Status.COMPLETED)) {
            Status current = this.getStatus();
            if (current.equals(Status.ON_GOING)) {
                this.status = Status.COMPLETED;
                return true;
            } else {
                throw new TaskUpdationException("Only ongoing tasks can be moved to completed");
            }
        }
        else{
            this.status = status;
        }

        return true;
    }

    public void removeDeveloper() throws RemoveDeveloperException {
        try {
            System.out.println(getDeveloper() + "has been removed");
            this.setDeveloper(null);
        } catch (Exception e){
            throw new RemoveDeveloperException("Problem in removing deveoper");
        }
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", developer=" + employee +
                ", status=" + status +
                ", taskDescription='" + taskDescription + '\'' +
                '}';
    }
}
