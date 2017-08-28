package com.orbismobile.testingforandroid.view.contact;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.orbismobile.testingforandroid.R;
import com.orbismobile.testingforandroid.model.entities.ContactEntity;
import com.orbismobile.testingforandroid.view.contactdetail.ContactDetailActivity;

import java.util.ArrayList;
import java.util.List;

public class ContactsActivity extends AppCompatActivity implements ContactsAdapter.OnContactItemClickListener {

    private List<ContactEntity> contactEntityList = new ArrayList<>();
    private ActionMode actionMode;
    private ActionModeCallback actionModeCallback = new ActionModeCallback();

    ContactsAdapter contactsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView rcvContact = findViewById(R.id.rcvContact);

        for (int i = 0; i < 100; i++) {
            if (i == 10) {
                contactEntityList.add(new ContactEntity("Contact " + i, "carlos@gmail " + i, true));
            } else {
                contactEntityList.add(new ContactEntity("Contact " + i, "carlos@gmail " + i, false));
            }
        }

        contactsAdapter = new ContactsAdapter(contactEntityList);
        rcvContact.setAdapter(contactsAdapter);
        rcvContact.setItemAnimator(new DefaultItemAnimator());
        contactsAdapter.setOnContactItemClickListener(this);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void onContactItemClick(int position) {
        goToContactDetailActivity(contactEntityList.get(position).getName());
    }

    @Override
    public void onContactLongItemClick(int position) {
        Toast.makeText(this, "onLongClick", Toast.LENGTH_SHORT).show();
        //actionMode = startSupportActionMode(actionModeCallback);

        contactsAdapter.toggleSelection(position);
    }

    private class ActionModeCallback implements ActionMode.Callback {

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            mode.getMenuInflater().inflate(R.menu.menu_main_selected, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            if (item.getItemId() == R.id.action_select_all) {

                Toast.makeText(ContactsActivity.this, "YEAH!", Toast.LENGTH_SHORT).show();
                mode.finish();
                return true;
            }
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            actionMode = null;
        }
    }


    public void goToContactDetailActivity(String title) {
        Intent intent = new Intent(ContactsActivity.this, ContactDetailActivity.class);
        intent.putExtra("title", title);
        startActivity(intent);
    }

}
