package com.obpdemo.backing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import javax.faces.validator.Validator;

import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.component.rich.RichForm;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.output.RichMessages;

public class PartyBackingBean {
    private RichCommandButton cb1;
    private RichInputText name;
    private RichPanelFormLayout pfl2;
    private RichPanelFormLayout pfl1;
    private RichForm f1;
    private RichMessages m1;
    private RichDocument d1;

    public PartyBackingBean() {
    }

    public void setCb1(RichCommandButton cb1) {
        this.cb1 = cb1;
    }

    public RichCommandButton getCb1() {
        return cb1;
    }

    public void setName(RichInputText it1) {
        this.name = it1;
    }

    public RichInputText getName() {
        return name;
    }

    public void setPfl2(RichPanelFormLayout pfl2) {
        this.pfl2 = pfl2;
    }

    public RichPanelFormLayout getPfl2() {
        return pfl2;
    }

    public void setPfl1(RichPanelFormLayout pfl1) {
        this.pfl1 = pfl1;
    }

    public RichPanelFormLayout getPfl1() {
        return pfl1;
    }

    public void setF1(RichForm f1) {
        this.f1 = f1;
    }

    public RichForm getF1() {
        return f1;
    }

    public void setM1(RichMessages m1) {
        this.m1 = m1;
    }

    public RichMessages getM1() {
        return m1;
    }

    public void setD1(RichDocument d1) {
        this.d1 = d1;
    }

    public RichDocument getD1() {
        return d1;
    }

    public void submit() {
        String name = (String)this.getName().getValue();


    }

    //    Gets called only if some value is entered in name field. If the field is empty, this method is not called.

    public void validateName(FacesContext facesContext,
                             UIComponent uIComponent, Object value) {

        if (hasSpecialCharacter(value.toString())) {
            FacesMessage facesMessage =
                new FacesMessage("Name can not have special characters. Only letters and numbers are allowed");
            throw new javax.faces.validator.ValidatorException(facesMessage);
        }
    }

    private boolean hasSpecialCharacter(String value) {
        Pattern p = Pattern.compile("[^A-Za-z0-9]");
        Matcher m = p.matcher(value);
        // boolean b = m.matches();
        return m.find();
    }


}
