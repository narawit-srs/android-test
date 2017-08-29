package com.orbismobile.testingforandroid.view.pet;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.orbismobile.testingforandroid.R;
import com.orbismobile.testingforandroid.model.entities.PetEntity;
import com.orbismobile.testingforandroid.model.entities.PetSectionEntity;

import java.util.ArrayList;
import java.util.List;

public class PetSectionsActivity extends AppCompatActivity {

    private List<PetSectionEntity> petSectionEntities = new ArrayList<>();
    private PetSectionAdapter petSectionAdapter;

    private List<PetEntity> petEntities;

    public PetSectionsActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_sections);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        RecyclerView rcvPetSections = findViewById(R.id.rcvPetSections);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        for (int i = 0; i < 10; i++) {
            petEntities = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                petEntities.add(new PetEntity("pet " +i+" - "+ j));
            }
            petSectionEntities.add(new PetSectionEntity("TITLE " + i, petEntities));
        }

        petSectionAdapter = new PetSectionAdapter(petSectionEntities);
        rcvPetSections.setAdapter(petSectionAdapter);

    }
}
