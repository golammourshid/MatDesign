package com.example.matdesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView txtWorld;
    private RecyclerView contactsRecView;
    private MaterialCardView cardView;
    private RelativeLayout parent;
    private FloatingActionButton fab;
    private Button snackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtWorld = findViewById(R.id.txtWorld);

        contactsRecView = findViewById(R.id.contactsRecView);

        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Antor", "golammourshid@gmail.com", "https://static.toiimg.com/thumb/msid-58475411,width-748,height-499,resizemode=4,imgsize-142947/.jpg"));
        contacts.add(new Contact("Kamal", "kamalparvez@gmail.com", "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Image_created_with_a_mobile_phone.png/1200px-Image_created_with_a_mobile_phone.png"));
        contacts.add(new Contact("Touhid", "touhid@gmail.com", "https://cdn.pixabay.com/photo/2013/07/25/12/06/bridge-167041__340.jpg"));

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

        Typeface typeface = ResourcesCompat.getFont(this, R.font.energy_spike);

        snackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtWorld.setTypeface(typeface);
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