package com.obpdemo.backing.dto;

public class Party {
    String name;
    String branchName;
    PartyAddress address;

    public Party(String name, String branchName, PartyAddress address) {
        this.name = name;
        this.branchName = branchName;
        this.address = address;
    }


    public String getName() {
        return name;
    }

    public String getBranchName() {
        return branchName;
    }

    public PartyAddress getAddress() {
        return address;
    }
}
