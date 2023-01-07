package com.example.matdesign;

import androidx.appcompat.app.AppCompatActivity;
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