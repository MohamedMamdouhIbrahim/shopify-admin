package com.example.shopifygp_serverside;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Stats extends AppCompatActivity {
    private TextView itemsCountTextView;
    private TextView usersCountTextView;
    private TextView ordersCountTextView;
    FirebaseDatabase database;
    DatabaseReference itemsRef;
    DatabaseReference usersRef;
    DatabaseReference ordersRef;
    Button showstatsbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        ImageButton inventbtnS = (ImageButton) findViewById(R.id.inventoryS);
        ImageButton trackie = (ImageButton) findViewById(R.id.trackingbtnS);
        showstatsbtn = (Button) findViewById(R.id.showstats);
        itemsCountTextView = findViewById(R.id.itemCount);
        usersCountTextView = findViewById(R.id.userCount);
        ordersCountTextView = findViewById(R.id.orderCount);

        database = FirebaseDatabase.getInstance("https://shopifygp-70897-default-rtdb.firebaseio.com/");
         itemsRef = FirebaseDatabase.getInstance().getReference("ItemModel");
         usersRef = FirebaseDatabase.getInstance().getReference("User");
         ordersRef = FirebaseDatabase.getInstance().getReference("Orders");
        inventbtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Stats.this, Inventory.class);

                startActivity(intent);
                finish();
            }
        });

        trackie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Stats.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
showstatsbtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        // Listen to changes in the number of items
        itemsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                long itemsCount = snapshot.getChildrenCount();
                itemsCountTextView.setText(String.valueOf(itemsCount));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        // Listen to changes in the number of users
        usersRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                long usersCount = snapshot.getChildrenCount();
                usersCountTextView.setText(String.valueOf(usersCount));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        // Listen to changes in the number of orders
        ordersRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                long ordersCount = snapshot.getChildrenCount();
                ordersCountTextView.setText(String.valueOf(ordersCount));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

    }
});

    }
}
