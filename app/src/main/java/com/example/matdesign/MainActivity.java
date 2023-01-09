package com.example.matdesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView contactsRecView;
    private MaterialCardView cardView;
    private RelativeLayout parent;
    private FloatingActionButton fab;
    private Button snackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactsRecView = findViewById(R.id.contactsRecView);

        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Antor", "golammourshid100@gmail.com", "https://www.educba.com/soap-vs-wsdl/"));
        contacts.add(new Contact("Kamal", "kamalparvez@gmail.com", "https://www.geeksforgeeks.org/wsdl-full-form/"));
        contacts.add(new Contact("Touhid", "touhid@gmail.com", "https://en.wikipedia.org/wiki/Image#/media/File:Image_created_with_a_mobile_phone.png"));

        ContactsRecViewAdapter adapter = new ContactsRecViewAdapter(this);
        adapter.setContacts(contacts);

        contactsRecView.setAdapter(adapter);
//        contactsRecView.setLayoutManager(new LinearLayoutManager(this));
//        contactsRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        contactsRecView.setLayoutManager(new GridLayoutManager(this, 2));

        cardView = findViewById(R.id.cardView);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Card Clicked!", Toast.LENGTH_SHORT).show();
            }
        });

        parent = findViewById(R.id.parent);

        snackButton = findViewById(R.id.snackButton);

        snackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSnackbar();
            }
        });

        fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Fab Clicked!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void showSnackbar() {
        Snackbar.make(parent, "This is a snackbar", Snackbar.LENGTH_INDEFINITE)
                .setAction("Retry", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Retry Clicked!", Toast.LENGTH_SHORT).show();
                    }
                })
                .setActionTextColor(getColor(R.color.orange))
                .setTextColor(Color.RED)
                .show();
    }
}