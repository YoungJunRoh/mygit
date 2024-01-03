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

public class ExerciseInput extends AppCompatActivity implements View.OnClickListener {

    EditText editable2;
    EditText editKal2;
    DatabaseReference exeInfoDb;
    Button insertExe;
    ListView list2;
    List<Exercise> exelit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_input);

        editable2 = (EditText) findViewById(R.id.editExeName);
        editKal2 = (EditText) findViewById(R.id.editExeKal);
        insertExe = (Button) findViewById(R.id.InsertExe);

        insertExe.setOnClickListener(this);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        exeInfoDb = database.getReference().child("Exercise");

        list2 = (ListView) findViewById(R.id.myListView2);
        exelit = new ArrayList<>();

        exeInfoDb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                exelit.clear();
                for(DataSnapshot foodDatasnap : snapshot.getChildren()){
                    Exercise exercise = foodDatasnap.getValue(Exercise.class);
                    exelit.add(exercise);
                }

                ListAdapter2 adapter = new ListAdapter2(ExerciseInput.this, exelit);
                list2.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
    private void insertExeData(){
        String name = editable2.getText().toString();
        String kal = editKal2.getText().toString();

        Exercise exercise= new Exercise(name, kal);

        exeInfoDb.push().setValue(exercise);
        Toast.makeText(ExerciseInput.this, "data inserted", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        insertExeData();
    }
}