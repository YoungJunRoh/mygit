package com.example.healthcaremain;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

public class Fragment3 extends Fragment implements View.OnClickListener{

    Button btn01, btnbreak,btnlunch,btndinner;
    TextView txt01, txt02;
    int t1h = 0, t1m = 0;
    Context ct;
    private LineChart chart;
    String intentname,intentkal;
    Intent intent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_3, container, false);

        ct = container.getContext();

        btn01 = v.findViewById(R.id.button01);
        txt01 = v.findViewById(R.id.textView_date01);
        chart = v.findViewById(R.id.LineChart04);


        btnbreak = v.findViewById(R.id.buttonbreak);
        btnlunch = v.findViewById(R.id.buttonlunch);
        btndinner = v.findViewById(R.id.buttondinner);

        btnbreak.setOnClickListener(this);
        btnlunch.setOnClickListener(this);
        btndinner.setOnClickListener(this);

/*
        intentname = intent.getStringExtra("name");
        intentkal = intent.getStringExtra("kal");

        if(intentname != null && intentkal != null){
            txt02.setText(intentname);
        }*/

        ArrayList<Entry> values = new ArrayList<>(); //임의값
        //for (int i = 0; i < 7; i++) {
        //float val = (float) (Math.random() * 10);
        values.add(new Entry(1, 300));
        values.add(new Entry(2, 600));
        values.add(new Entry(3, 500));
        values.add(new Entry(4, 333));
        values.add(new Entry(5, 777));
        values.add(new Entry(6, 888));
        values.add(new Entry(7, 890));
        // }
        //이부분 아래만
        LineDataSet set1;
        set1 = new LineDataSet(values, "");
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1); // add the data sets
        // create a data object with the data sets
        LineData data = new LineData(dataSets);
        String wannabeColor = "#6EC383";
        set1.setColor(Color.parseColor(wannabeColor));
        set1.setCircleColor(Color.BLACK);
        // set data
        chart.setData(data);


        return v;
    }


    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.buttonbreak) {
            Intent intent = new Intent(getActivity(), Search.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.buttonlunch){
            Intent intent = new Intent(getActivity(), Search1.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.buttondinner){
            Intent intent = new Intent(getActivity(), Search2.class);
            startActivity(intent);
        }

    }
}