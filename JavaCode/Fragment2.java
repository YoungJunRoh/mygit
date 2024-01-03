package com.example.healthcaremain;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class Fragment2 extends Fragment implements View.OnClickListener {

    Button btn01, btn02;
    TextView txt01, txt02;
    int t1h = 0, t1m = 0;
    int t2h = 0, t2m = 0;
    Context ct;

    private LineChart chart; // 선언

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_2, container, false);

        ct = container.getContext();


        int style = AlertDialog.THEME_HOLO_DARK; // spinner모드

        btn01 = v.findViewById(R.id.button01);
        //  btn01.setOnClickListener(this);
        btn01.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.button01) {
                    TimePickerDialog timePickerDialog = new TimePickerDialog(ct, style, new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                            t1h = hourOfDay;
                            t1m = minute;
                            txt01.setText(t1h + ":" + t1m);
                        }
                    }, t1h, t1m, false
                    );
                    timePickerDialog.show();
                }
            }
        });


        btn02 = v.findViewById(R.id.button02);
        //btn02.setOnClickListener(this);
        btn02.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                TimePickerDialog timePickerDialog2 = new TimePickerDialog(ct, style, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                        t2h = hourOfDay;
                        t2m = minute;
                        txt02.setText(t2h + ":" + t2m);
                    }
                }, t2h, t2m, false
                );
                timePickerDialog2.show();

            }
        });




        txt01 = v.findViewById(R.id.textView_date01);
        txt02 = v.findViewById(R.id.textView_date02);

        chart = v.findViewById(R.id.LineChart01); //가져오기



        ArrayList<Entry> values = new ArrayList<>(); //임의값
        //for (int i = 0; i < 7; i++) {
        //float val = (float) (Math.random() * 10);
        values.add(new Entry(1, 6));
        values.add(new Entry(2, 8));
        values.add(new Entry(3, 6));
        values.add(new Entry(4, 7));
        values.add(new Entry(5, 6));
        values.add(new Entry(6, 9));
        values.add(new Entry(7, 8));
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
    public void onClick(View view) {
        int style = AlertDialog.THEME_HOLO_DARK; // spinner모드

        if (view.getId() == R.id.button01) {
            TimePickerDialog timePickerDialog = new TimePickerDialog(ct, style, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                    t1h = hourOfDay;
                    t1m = minute;
                    txt01.setText(t1h + ":" + t1m);
                }
            }, t1h, t1m, false
            );
            timePickerDialog.show();
        }
        else if (view.getId() == R.id.button02){
            TimePickerDialog timePickerDialog2 = new TimePickerDialog(ct, style, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                    t2h = hourOfDay;
                    t2m = minute;
                    txt02.setText(t2h + ":" + t2m);
                }
            }, t2h, t2m, false
            );
            timePickerDialog2.show();
        }

    }

    /*
    public void showBarChart() {

        ArrayList<Double> valueList = new ArrayList<Double>();
        ArrayList<BarEntry> entries = new ArrayList<>();
        String title = "Title";

        //input data
        for (int i = 0; i < 6; i++) {
            valueList.add(i * 100.1);
        }

        //fit the data into a bar
        for (int i = 0; i < valueList.size(); i++) {
            BarEntry barEntry = new BarEntry(i, valueList.get(i).floatValue());
            entries.add(barEntry);
        }

        BarDataSet barDataSet = new BarDataSet(entries, title);

        BarData data = new BarData(barDataSet);
        barChart.setData(data);
        barChart.invalidate();

    }
     */
}





        /*

        TimePickerDialog TP = new TimePickerDialog(
                Fragment2.this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        t1h = hourOfDay;
                        t1m = minute;
                        Calendar cal = Calendar.getInstance();
                        cal.set(0, 0, 0, t1h, t1m);
                        txt01.setText(DateFormat.format("hh:mm", cal));
                    }
                }, 12, 0, false
        );
        TP.updateTime(t1h, t1m);
        TP.show();
    }
}
         */