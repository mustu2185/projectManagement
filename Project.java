package com.anahad.projectmanagement;

import java.util.ArrayList;

public class Project {
    String name;
    ArrayList<String> households;
    ArrayList<String> members;
    ArrayList<String> workers;

    public Project() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getHouseholds() {
        return households;
    }

    public void setHouseholds(ArrayList<String> households) {
        this.households = households;
    }

    public ArrayList<String> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<String> members) {
        this.members = members;
    }

    public ArrayList<String> getWorkers() {
        return workers;
    }

    public void setWorkers(ArrayList<String> workers) {
        this.workers = workers;
    }

    public void addUser(String user)
    {
        members.add(user);
    }

    public void removeUser(String user)
    {
        members.remove(user);
    }

    public boolean hasUser(String user)
    {
        return members.contains(user);
    }

    public boolean hasHousehold(String household)
    {
        return households.contains(household);
    }

    public void addHousehold(String household)
    {
        households.add(household);
    }

    public void removeHousehold(String household)
    {
        households.remove(household);
    }


}
