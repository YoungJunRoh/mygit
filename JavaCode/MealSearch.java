package com.example.healthcaremain;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MealSearch extends AppCompatActivity implements View.OnClickListener {

    EditText editable;
    EditText editKal;
    DatabaseReference foodInfoDb;
    Button insertDb;
    ListView list1;
    List<Foods> foodlist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_search);

        editable = (EditText) findViewById(R.id.editMealName);
        editKal = (EditText) findViewById(R.id.editMealKal);
        insertDb = (Button) findViewById(R.id.InsertData);

        insertDb.setOnClickListener(this);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        foodInfoDb = database.getReference().child("Foods");

        list1 = (ListView) findViewById(R.id.myListView);
        foodlist = new ArrayList<>();



        foodInfoDb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                foodlist.clear();
                for(DataSnapshot foodDatasnap : snapshot.getChildren()){
                    Foods foods = foodDatasnap.getValue(Foods.class);
                    foodlist.add(foods);
                }

                ListAdapter adapter = new ListAdapter(MealSearch.this, foodlist);
                list1.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void insertFoodData() {
        String name = editable.getText().toString();
        String kal = editKal.getText().toString();

        Foods foods = new Foods(name, kal);

        foodInfoDb.push().setValue(foods);
        Toast.makeText(MealSearch.this, "data inserted", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onClick(View v){
        insertFoodData();
    }

}