package com.example.joshi.todo.Model;

/**
 * Created by Joshi on 08.12.2017.
 */

public class TodoItem {
    private String title;
    private String description;
    private String priority;

    public TodoItem (){

    }

    public TodoItem(String title, String description, String priority){
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public String getPriority() {
        return priority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return getTitle()+" "+getDescription()+" "+getPriority();
    }
}
