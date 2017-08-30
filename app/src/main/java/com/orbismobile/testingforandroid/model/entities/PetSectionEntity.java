package com.orbismobile.testingforandroid.model.entities;

import java.util.List;

/**
 * Created by carlosleonardocamilovargashuaman on 8/29/17.
 */

public class PetSectionEntity {

    private int id;
    private String title;
    private List<PetEntity> petEntities;

    public PetSectionEntity() {
    }

    public PetSectionEntity(int id, String title, List<PetEntity> petEntities) {
        this.id = id;
        this.title = title;
        this.petEntities = petEntities;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<PetEntity> getPetEntities() {
        return petEntities;
    }

    public void setPetEntities(List<PetEntity> petEntities) {
        this.petEntities = petEntities;
    }
}
