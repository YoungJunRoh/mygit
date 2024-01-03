package com.example.healthcaremain;

import static android.content.ContentValues.TAG;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class exeSearch extends AppCompatActivity implements View.OnClickListener{

    List<Exercise> exel = new ArrayList<>();
    ListView exelist;

    FirebaseDatabase database;
    private DatabaseError databaseError;

    private List<String> list1;          // 데이터를 넣은 리스트변수
    private EditText editSearch2;        // 검색어를 입력할 Input 창
    private SearchAdapter2 adapter2;      // 리스트뷰에 연결할 아답터
    private ArrayList<Exercise> arraylist2;
    private ActivityResultLauncher<Intent> resultLauncher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exe_search);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("운동 추가");

        editSearch2 = (EditText) findViewById(R.id.searchWord02);
        exelist = (ListView) findViewById(R.id.exelist);

        resultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {

                    }
                }
        );

        exelist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), Fragment4.class);
                intent.putExtra("name", exel.get(i).getexeName());
                intent.putExtra("kal", exel.get(i).getexeKal());
                startActivity(intent);
            }
        });
        database = FirebaseDatabase.getInstance();

        database.getReference().child("Exercise").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                exel.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Exercise exercise = snapshot.getValue(Exercise.class);
                    exel.add(exercise);
                }
                ListAdapter2 adapter = new ListAdapter2(exeSearch.this, exel);
                exelist.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
            }
        });

        list1 = new ArrayList<String>();

        arraylist2 = new ArrayList<Exercise>();
        arraylist2.addAll(exel);

        // 리스트에 연동될 아답터를 생성한다.
        adapter2 = new SearchAdapter2(exel, this);

        // 리스트뷰에 아답터를 연결한다.
        exelist.setAdapter(adapter2);


        editSearch2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                // input창에 문자를 입력할때마다 호출된다.
                // search 메소드를 호출한다.
                String text = editSearch2.getText().toString();
                search2(text);
            }
        });
    }
        // 검색을 수행하는 메소드
        public void search2(String charText) {

            // 문자 입력시마다 리스트를 지우고 새로 뿌려준다.
            exel.clear();

            // 문자 입력이 없을때는 모든 데이터를 보여준다.
            if (charText.length() == 0) {
                exel.addAll(arraylist2);
            }
            // 문자 입력을 할때..
            else
            {
                // 리스트의 모든 데이터를 검색한다.
                for(int i = 0; i < arraylist2.size(); i++)
                {
                    // arraylist의 모든 데이터에 입력받은 단어(charText)가 포함되어 있으면 true를 반환한다.
                    if (String.valueOf(arraylist2.get(i)).toLowerCase().contains(charText))
                    {
                        // 검색된 데이터를 리스트에 추가한다.
                        list1.add(String.valueOf(arraylist2.get(i)));
                    }
                }
            }
            // 리스트 데이터가 변경되었으므로 아답터를 갱신하여 검색된 데이터를 화면에 보여준다.
            adapter2.notifyDataSetChanged();
        }

    @Override
    public void onClick(View v) {

    }
}
