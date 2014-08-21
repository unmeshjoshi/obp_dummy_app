package com.obpdemo.backing;

import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.ide.feedback.ExpectedExceptions;

import static org.junit.Assert.*;
import org.junit.Test;

public class PartyBackingBeanTest {
    public PartyBackingBeanTest() {
    }

    /**
     * @see PartyBackingBean#validateName(javax.faces.context.FacesContext,javax.faces.component.UIComponent,Object)
     */
    @Test(expected = javax.faces.validator.ValidatorException.class)
    public void shouldNotAllowSpecialCharactersInName() {
        PartyBackingBean party = new PartyBackingBean();
        RichInputText nameField = new RichInputText();
        nameField.setValue("#$%%");
        party.setName(nameField);
        party.validateName(null, null, "#$%%");
    }
}
