package com.example.healthcaremain;

import static com.example.healthcaremain.CalendarUtils.daysInMonthArray;
import static com.example.healthcaremain.CalendarUtils.daysInWeekArray;
import static com.example.healthcaremain.CalendarUtils.monthYearFromDate;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.util.ArrayList;

public class Fragment5 extends Fragment implements CalendarAdapter.OnItemListener{

    Context ct;
    private TextView monthYearText;
    private RecyclerView calendarRecyclerView;
    private ListView eventListView;
    Button btn01;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.activity_week_view, container, false);
        //initWidgets();
        calendarRecyclerView = v.findViewById(R.id.calendarRecyclerView);
        //monthYearText = v.findViewById(R.id.monthYearTV);

        //setWeekView();
        btn01 = v.findViewById(R.id.button001);
        btn01.setOnClickListener(new Button.OnClickListener()

        {
            @Override
            public void onClick(View view) {

                // Toast myToast = Toast.makeText(getActivity().getApplicationContext(),"일정추가버튼", Toast.LENGTH_SHORT);
                //myToast.show();
                Intent intent = new Intent(getActivity(), EventEditActivity.class);
                startActivity(intent);
                //startActivity(new Intent(getActivity(), EventEditActivity.class));
            }


        });


        // CalendarUtils.selectedDate = LocalDate.now();

        return v;
    }
    private void setWeekView()
    {
        monthYearText.setText(monthYearFromDate(CalendarUtils.selectedDate));
        ArrayList<LocalDate> days = daysInWeekArray(CalendarUtils.selectedDate);
        CalendarAdapter calendarAdapter = new CalendarAdapter(days, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity().getApplicationContext(), 7);
        calendarRecyclerView.setLayoutManager(layoutManager);
        calendarRecyclerView.setAdapter(calendarAdapter);
        //setEventAdpater();
    }

    @Override
    public void onItemClick(int position, LocalDate date) {
        CalendarUtils.selectedDate = date;
        // setWeekView();
    }
    /*
       @Override
       protected void onResume()
       {
           super.onResume();
           //setEventAdpater();
       }


       private void setEventAdpater()
       {
           ArrayList<Event> dailyEvents = Event.eventsForDate(CalendarUtils.selectedDate);
           EventAdapter eventAdapter = new EventAdapter(getApplicationContext(), dailyEvents);
           eventListView.setAdapter(eventAdapter);
       }
   */
    public void newEventAction(View view)
    {
        ct = view.getContext();
        startActivity(new Intent(ct, EventEditActivity.class));
    }

    /*
    private void setMonthView()
    {
        monthYearText.setText(monthYearFromDate(CalendarUtils.selectedDate));
        ArrayList<LocalDate> daysInMonth = daysInMonthArray(CalendarUtils.selectedDate);
        ct = getContext();
        CalendarAdapter calendarAdapter = new CalendarAdapter(daysInMonth, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(ct.getApplicationContext(), 7);
        calendarRecyclerView.setLayoutManager(layoutManager);
        calendarRecyclerView.setAdapter(calendarAdapter);
    }

/*
    public void previousMonthAction(View view)
    {
        CalendarUtils.selectedDate = CalendarUtils.selectedDate.minusMonths(1);
        setMonthView();
    }

    public void nextMonthAction(View view)
    {
        CalendarUtils.selectedDate = CalendarUtils.selectedDate.plusMonths(1);
        setMonthView();
    }

    @Override
    public void onItemClick(int position, LocalDate date)
    {
        if(date != null)
        {
            CalendarUtils.selectedDate = date;
            setMonthView();
        }
    }

    public void weeklyAction(View view)
    {
        ct = view.getContext();
        startActivity(new Intent(ct, com.example.healthcaremain.WeekViewActivity.class));
    }
*/

}
