package com.orbismobile.testingforandroid.model.entities;

/**
 * Created by carlosleonardocamilovargashuaman on 8/9/17.
 */

public class ContactEntity {

    private String name;
    private String email;
    private boolean selected;

    public ContactEntity() {
    }

    public ContactEntity(String name, String email, boolean selected) {
        this.name = name;
        this.email = email;
        this.selected = selected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
