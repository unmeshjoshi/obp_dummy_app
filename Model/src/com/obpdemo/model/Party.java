package com.obpdemo.model;

public class Party {
    private String name;
    private String branchName;
   
    public Party() {
        this("Suncorp Employee");
    }
    
    public Party(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchName() {
        return branchName;
    }
}
