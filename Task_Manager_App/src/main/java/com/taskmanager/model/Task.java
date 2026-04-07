package com.taskmanager.model;

public class Task {

    private String name;
    private String priority;
    private boolean completed;

    public Task(String name, String priority) {
        this.name = name;
        this.priority = priority;
        this.completed = false;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getPriority() {
        return priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    // Setter
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return (completed ? "✔ " : "") + name + " [" + priority + "]";
    }
}