package com.example.shopifygp_serverside;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Locale;

public class Inventory extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference itemref;
    EditText nameTextBox;
    EditText priceTextBox;
    EditText imageTextBox;
    EditText descriptionTextBox;
    EditText categoryTextBox;
    int dido = 29;

    public String CategoryToID (String C)
    {

        if (C.toLowerCase().equals("Consoles".toLowerCase()))
        {
            return "01";
        }

else  if (C.toLowerCase().equals("Televisions".toLowerCase()))
        {
            return "02";
        }
        else  if (C.toLowerCase().equals("Personal Computers".toLowerCase()))
        {
            return "03";
        }
        else  if (C.toLowerCase().equals("Laptops".toLowerCase()))
        {
            return "04";
        }
        else  if (C.toLowerCase().equals("Smart Watches".toLowerCase()))
        {
            return "05";
        }
        else  if (C.toLowerCase().equals("Smart Phones".toLowerCase()))
        {
            return "06";
        }
        else if (C.toLowerCase().equals("Cameras".toLowerCase()))
        {
            return "07";
        }
else{

            Toast.makeText(Inventory.this, "Wrong Category Inserted",
                    Toast.LENGTH_SHORT).show();
            return "00";

        }



    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
        nameTextBox = (EditText) findViewById(R.id.itemNameTextBox);
        priceTextBox = (EditText) findViewById(R.id.priceTextBox);
        imageTextBox = (EditText) findViewById(R.id.imageTextBox);
        descriptionTextBox = (EditText) findViewById(R.id.itemDESTextBox);
        categoryTextBox = (EditText) findViewById(R.id.categoryTextBox);




        ImageButton statsI = (ImageButton) findViewById(R.id.statappi);
        ImageButton trackiei = (ImageButton) findViewById(R.id.trackingbtni);
        Button butonINV =  findViewById(R.id.addtoinv);
        butonINV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database = FirebaseDatabase.getInstance("https://shopifygp-70897-default-rtdb.firebaseio.com/");
               itemref = database.getReference("ItemModel");

               String nameText = nameTextBox.getText().toString();
                String priceText = priceTextBox.getText().toString();
                String  imageText = imageTextBox.getText().toString();
                String descriptionText = descriptionTextBox.getText().toString();
                String  categoryText = categoryTextBox.getText().toString();
                String avala = "Available";

                Log.d("hello",categoryText);
                String mamaID = CategoryToID(categoryText);
                if (mamaID != "00")
                {
                    ItemModel item1 = new ItemModel(nameText,imageText,descriptionText,priceText,mamaID,avala);
                    itemref.child(Integer.toString(dido)).setValue(item1);
                    dido++;

                }

                Toast.makeText(Inventory.this, "Item Added Successfully",
                        Toast.LENGTH_SHORT).show();
            }
        });




        statsI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Inventory.this, Stats.class);

                startActivity(intent);
                finish();
            }
        });

        trackiei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Inventory.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }















}