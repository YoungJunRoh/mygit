package com.example.healthcaremain;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.net.Uri;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.OAuthCredential;

import java.util.ArrayList;

public class MyInfoActivity extends AppCompatActivity implements View.OnClickListener{
    private final int GET_GALLERY_IMAGE = 1;
    private ImageView profile, menu1, menu2, menu3, menu4, menu5, menu6, menu7, menu8, menu9;
    private Spinner spinner, spinner2 = null;
    TextView connect, deconnect;
    EditText name, height, weight;
    ArrayList<String> arrayList, arrayList2;
    ArrayAdapter<String> arrayAdapter ,arrayAdapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("내 정보");

        name = (EditText) findViewById(R.id.name);
        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        profile = (ImageView) findViewById(R.id.profile_photo);
        profile.setBackground(new ShapeDrawable(new OvalShape()));
        profile.setClipToOutline(true);
        profile.setOnClickListener(this);
        connect = (TextView) findViewById(R.id.connect);
        deconnect = (TextView) findViewById(R.id.deconnect);
        connect.setOnClickListener(this);
        deconnect.setOnClickListener(this);
        menu1 = (ImageView) findViewById(R.id.menu1);
        menu2 = (ImageView) findViewById(R.id.menu2);
        menu3 = (ImageView) findViewById(R.id.menu3);
        menu4 = (ImageView) findViewById(R.id.menu4);
        menu5 = (ImageView) findViewById(R.id.menu5);
        menu6 = (ImageView) findViewById(R.id.menu6);
        menu7 = (ImageView) findViewById(R.id.menu7);
        menu8 = (ImageView) findViewById(R.id.menu8);
        menu9 = (ImageView) findViewById(R.id.menu9);
        menu1.setOnClickListener(this);
        menu2.setOnClickListener(this);
        menu3.setOnClickListener(this);
        menu4.setOnClickListener(this);
        menu5.setOnClickListener(this);
        menu6.setOnClickListener(this);
        menu7.setOnClickListener(this);
        menu8.setOnClickListener(this);
        menu9.setOnClickListener(this);

        arrayList = new ArrayList<>();
        arrayList.add("11");
        arrayList.add("12");
        arrayList.add("13");
        arrayList.add("14");
        arrayList.add("15");
        arrayList.add("16");
        arrayList.add("17");
        arrayList.add("18");
        arrayList.add("19");
        arrayList.add("20");
        arrayList.add("21");
        arrayList.add("22");
        arrayList.add("23");
        arrayList.add("24");
        arrayList.add("25");
        arrayList.add("27");
        arrayList.add("28");
        arrayList.add("29");
        arrayList.add("30");
        arrayList.add("31");
        arrayList.add("32");
        arrayList.add("33");
        arrayList.add("34");
        arrayList.add("35");
        arrayList.add("36");
        arrayList.add("37");
        arrayList.add("38");
        arrayList.add("39");
        arrayList.add("40");
        arrayList.add("41");
        arrayList.add("42");
        arrayList.add("43");
        arrayList.add("44");
        arrayList.add("45");
        arrayList.add("46");
        arrayList.add("47");
        arrayList.add("48");
        arrayList.add("49");
        arrayList.add("50");
        arrayList.add("51");
        arrayList.add("52");
        arrayList.add("53");
        arrayList.add("54");
        arrayList.add("55");
        arrayList.add("56");
        arrayList.add("57");
        arrayList.add("58");
        arrayList.add("59");
        arrayList.add("60");
        arrayList.add("61");
        arrayList.add("62");
        arrayList.add("63");
        arrayList.add("64");
        arrayList.add("65");
        arrayList.add("66");
        arrayList.add("67");
        arrayList.add("68");
        arrayList.add("69");
        arrayList.add("70");
        arrayList.add("71");
        arrayList.add("72");
        arrayList.add("73");
        arrayList.add("74");
        arrayList.add("75");
        arrayList.add("76");
        arrayList.add("77");
        arrayList.add("78");
        arrayList.add("79");
        arrayList.add("80");
        arrayList.add("81");
        arrayList.add("82");
        arrayList.add("83");
        arrayList.add("84");
        arrayList.add("85");
        arrayList.add("86");
        arrayList.add("87");
        arrayList.add("88");
        arrayList.add("89");
        arrayList.add("90");
        arrayList.add("91");
        arrayList.add("92");
        arrayList.add("93");
        arrayList.add("94");
        arrayList.add("95");
        arrayList.add("96");
        arrayList.add("97");
        arrayList.add("98");
        arrayList.add("99");

        arrayList2 = new ArrayList<>();
        arrayList2.add("남");
        arrayList2.add("여");

        arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, arrayList);
        spinner = (Spinner) findViewById(R.id.age);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        arrayAdapter2 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, arrayList2);
        spinner2 = (Spinner) findViewById(R.id.gender);
        spinner2.setAdapter(arrayAdapter2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.profile_photo:
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setDataAndType(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI,"image/*");
                startActivityForResult(intent, GET_GALLERY_IMAGE);
                break;
            case R.id.name:
                name.setText(null);
                break;
            case R.id.height:
                height.setText(null);
                break;
            case R.id.weight:
                weight.setText(null);
                break;
            case R.id.connect:
                AlertDialog.Builder connect = new AlertDialog.Builder(this);
                connect.setTitle("로그인").setMessage("아이디 : \n비밀번호 :");
                connect.setPositiveButton("로그인", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int id)
                    {
                    }
                });
                connect.setNegativeButton("취소", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int id)
                    {
                    }
                });
                AlertDialog alertDialog = connect.create();
                alertDialog.show();
                break;
            case R.id.deconnect:
                AlertDialog.Builder deconnect = new AlertDialog.Builder(this);
                deconnect.setTitle("로그아웃").setMessage("로그아웃 하시겠습니까?");
                deconnect.setPositiveButton("로그아웃", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int id)
                    {
                    }
                });
                deconnect.setNegativeButton("취소", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int id)
                    {
                    }
                });
                AlertDialog alertDialog2 = deconnect.create();
                alertDialog2.show();
                break;
            case R.id.menu1:
                Intent intent1 = new Intent();
                intent1.setAction(Intent.ACTION_VIEW);
                intent1.addCategory(Intent.CATEGORY_BROWSABLE);
                intent1.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.fineapp.yogiyo"));
                startActivity(intent1);
                break;
            case R.id.menu2:
                Intent intent2 = new Intent();
                intent2.setAction(Intent.ACTION_VIEW);
                intent2.addCategory(Intent.CATEGORY_BROWSABLE);
                intent2.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.sampleapp"));
                startActivity(intent2);
                break;
            case R.id.menu3:
                Intent intent3 = new Intent();
                intent3.setAction(Intent.ACTION_VIEW);
                intent3.addCategory(Intent.CATEGORY_BROWSABLE);
                intent3.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.coupang.mobile.eats"));
                startActivity(intent3);
                break;
            case R.id.menu4:
                Intent intent4 = new Intent();
                intent4.setAction(Intent.ACTION_VIEW);
                intent4.addCategory(Intent.CATEGORY_BROWSABLE);
                intent4.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.sec.android.app.shealth"));
                startActivity(intent4);
                break;
            case R.id.menu5:
                Intent intent5 = new Intent();
                intent5.setAction(Intent.ACTION_VIEW);
                intent5.addCategory(Intent.CATEGORY_BROWSABLE);
                intent5.setData(Uri.parse("https://play.google.com/store/apps/details?id=kr.co.stone_i.www.dagym"));
                startActivity(intent5);
                break;
            case R.id.menu6:
                Intent intent6 = new Intent();
                intent6.setAction(Intent.ACTION_VIEW);
                intent6.addCategory(Intent.CATEGORY_BROWSABLE);
                intent6.setData(Uri.parse("https://play.google.com/store/apps/details?id=homeworkout.homeworkouts.noequipment"));
                startActivity(intent6);
                break;
            case R.id.menu7:
                Intent intent7 = new Intent();
                intent7.setAction(Intent.ACTION_VIEW);
                intent7.addCategory(Intent.CATEGORY_BROWSABLE);
                intent7.setData(Uri.parse("https://play.google.com/store/apps/details?id=sleeptrakcer.sleeprecorder.sleepapp.sleep"));
                startActivity(intent7);
                break;
            case R.id.menu8:
                Intent intent8 = new Intent();
                intent8.setAction(Intent.ACTION_VIEW);
                intent8.addCategory(Intent.CATEGORY_BROWSABLE);
                intent8.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.northcube.sleepcycle"));
                startActivity(intent8);
                break;
            case R.id.menu9:
                Intent intent9 = new Intent();
                intent9.setAction(Intent.ACTION_VIEW);
                intent9.addCategory(Intent.CATEGORY_BROWSABLE);
                intent9.setData(Uri.parse("https://play.google.com/store/apps/details?id=sleepsounds.relaxandsleep.whitenoise"));
                startActivity(intent9);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == GET_GALLERY_IMAGE && resultCode == RESULT_OK && data != null && data.getData() != null){
            Uri selectedImageUri = data.getData();
            profile.setImageURI(selectedImageUri);

        }
    }
}