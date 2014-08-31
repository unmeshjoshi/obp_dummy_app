package com.obpdemo.backing;

import com.obpdemo.model.PartyVOImpl;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;

public class Util {

    public <T> T getViewObject(String iteratorName) {
           return (T)(getBindings().findIteratorBinding(iteratorName).getViewObject());
    }
    


    private DCBindingContainer getBindings() {
        return (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    }
}
