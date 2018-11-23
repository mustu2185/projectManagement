package com.anahad.projectmanagement;

import java.util.ArrayList;

public class HouseHold {
    String name;
    ArrayList<String> members;
    ArrayList<String> projects;

    public HouseHold(String name) {
        initialize();
        this.name = name;
    }

    public HouseHold() {
        initialize();
    }

    private void initialize()
    {
        members = new ArrayList<String>();
        projects = new ArrayList<String>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addUser(String user)
    {
        members.add(user);
    }

    public void removeUser(String user)
    {
        members.remove(user);
    }

    public boolean hasUser(User user)
    {
        return members.contains(user);
    }
    public void addProject(String project)
    {
        projects.add(project);
    }

    public void removeProject(String project)
    {
        projects.remove(project);
    }

    public boolean isMemberOfProject(String project)
    {
        return projects.contains(project);
    }
}
