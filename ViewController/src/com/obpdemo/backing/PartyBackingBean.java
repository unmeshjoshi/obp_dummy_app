package com.obpdemo.backing;

import com.obpdemo.backing.dto.Party;
import com.obpdemo.model.PartyVOImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.context.FacesContext;

import javax.faces.validator.Validator;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.component.rich.RichForm;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.output.RichMessages;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;

import oracle.jbo.ViewObject;

import org.apache.myfaces.trinidad.component.UIXGroup;

public class PartyBackingBean {
    private RichInputText name;
    private RichPanelFormLayout pfl2;
    private RichPanelFormLayout pfl1;
    private RichForm f1;
    private RichMessages m1;
    private RichDocument d1;
    private UIXGroup g1;
    private RichPanelFormLayout pfl3;
    private RichInputText it1;
    private RichCommandButton cb2;
    private HtmlCommandButton cb3;
    private RichCommandButton cb1;

    public PartyBackingBean() {
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

    public String showMessage(UIComponent component, String messageText) {
            FacesMessage fm = new FacesMessage(messageText);
            /**
             * set the type of the message.
             * Valid types: error, fatal,info,warning
             */
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext context = FacesContext.getCurrentInstance();
            //departmentName is the binding property for our field.
            context.addMessage(component.getClientId(context), fm);
            return null;
        }

    public void setG1(UIXGroup g1) {
        this.g1 = g1;
    }

    public UIXGroup getG1() {
        return g1;
    }

    public void setPfl3(RichPanelFormLayout pfl3) {
        this.pfl3 = pfl3;
    }

    public RichPanelFormLayout getPfl3() {
        return pfl3;
    }

    public void setIt1(RichInputText it1) {
        this.it1 = it1;
    }

    public RichInputText getIt1() {
        return it1;
    }

    public void setCb2(RichCommandButton cb2) {
        this.cb2 = cb2;
    }

    public RichCommandButton getCb2() {
        return cb2;
    }

    public void setCb3(HtmlCommandButton cb3) {
        this.cb3 = cb3;
    }

    public HtmlCommandButton getCb3() {
        return cb3;
    }

    public void setCb1(RichCommandButton cb1) {
        this.cb1 = cb1;
    }

    public RichCommandButton getCb1() {
        return cb1;
    }


    private Util util = new Util();
    private PartyService partyService = new PartyService();

    public String searchParty() {
        
        PartyVOImpl party = util.getViewObject("PartyVO1Iterator");
        
        String name = (String)party.getCurrentRow().getAttribute("name");
        String branchName = (String)party.getCurrentRow().getAttribute("branchName");

        List<Party> parties = partyService.search(name, branchName);
        if (parties.isEmpty()) {
            showMessage(getName(), "No client found with this name");  
            return null;
        }

        ViewObject address = util.getViewObject("PartyAddressIterator");
        Row addressRow = address.createRow();
        addressRow.setAttribute("streetName", "Blackberry Hill Road");    
        addressRow.setAttribute("city", "Lexington");    
        addressRow.setAttribute("state", "MA");    
        addressRow.setAttribute("country", "USA");    
        
        address.insertRow(addressRow);

        return "StayOnTheSamePage";
    }


    public String createOrUpdate() {
        // Add event code here...
        return "Save";
    }

    public String edit() {
        return "Edit";
    }
}
