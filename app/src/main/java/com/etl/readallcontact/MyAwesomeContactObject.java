package com.etl.readallcontact;

import com.tomash.androidcontacts.contactgetter.entity.ContactData;

public class MyAwesomeContactObject extends ContactData {

    private String mySuperField;

    public String getMySuperField() {
        return mySuperField;
    }

    public void setMySuperField(String mySuperField) {
        this.mySuperField = mySuperField;
    }

    public MyAwesomeContactObject() {
    }
}
