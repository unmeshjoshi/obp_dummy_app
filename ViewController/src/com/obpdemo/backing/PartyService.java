package com.obpdemo.backing;


import com.obpdemo.backing.dto.Party;

import com.obpdemo.backing.dto.PartyAddress;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartyService {
    
    public List<Party> search(String partyId, String branchName) {
        if (!"scott".equals(partyId)) {
            return new ArrayList<Party>();
        }
        return Arrays.asList(new Party("scott tiger", "br0201", new PartyAddress("1 cranberry hill", "Lexington", "MA", "USA", "60602")));
    }
    
}
