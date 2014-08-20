package com.obpdemo.model;

import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import oracle.jbo.RowIterator;
import oracle.jbo.domain.Number;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.server.ViewRowImpl;
import oracle.jbo.server.ViewRowSetImpl;

import oracle.security.idm.IMException;

public class PartyVOImpl extends ViewObjectImpl {
    
    List<Party> parties = new ArrayList<Party>();
    int partyCount = -1;
    boolean isInitialized = false;
  
    public PartyVOImpl() {
        
    }

    protected void executeQueryForCollection(Object qc, Object[] params,
                                             int noUserParams) {
        //make websevice call to fetch party info.
        //set it in viewobject with position as 0
        if (!isInitialized) {
            parties.add(new Party());
            partyCount = parties.size();
            isInitialized = true;
        }
        setFetchPos(qc, 0);
        super.executeQueryForCollection(qc, params, noUserParams);
    }

    protected ViewRowImpl createRowFromResultSet(Object qc, ResultSet rs) {
        // Create and populate a new row 
        ViewRowImpl r = createNewRowForCollection(qc);
        int pos = getFetchPos(qc);
        populateAttributeForRow(r, 0, parties.get(pos).getName());
        setFetchPos(qc, pos + 1);
        return r; 
    }

    protected boolean hasNextForCollection(Object qc) {
        return getFetchPos(qc) < partyCount;
    }


    public long getQueryHitCount(ViewRowSetImpl viewRowSet) {
        return partyCount;
    }
    
    private void setFetchPos(Object rowset, int pos) {
        if (pos == partyCount) {
            setFetchCompleteForCollection(rowset, true);
        }
        setUserDataForCollection(rowset, new Integer(pos));
    }
    
    private int getFetchPos(Object rowset) {
        return ((Integer)getUserDataForCollection(rowset)).intValue();
    }
    
}
