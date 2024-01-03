package com.example.healthcaremain;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends ArrayAdapter {


    private Activity mContext;
    List<Foods> foodsList;
    List<String> foodl;
    public ListAdapter(Activity mContext, List<Foods> foodsList){
        super(mContext,R.layout.list_item,foodsList);
        this.mContext=mContext;
        this.foodsList =foodsList;
    }

    public ListAdapter(Search mContext, List<String> foodl) {
        super(mContext, R.layout.list_item, foodl);
        this.mContext= mContext;
        this.foodl =foodl;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = mContext.getLayoutInflater();
        View listItemView = inflater.inflate(R.layout.list_item,null,true);

        TextView tvName = listItemView.findViewById(R.id.tvname);
        TextView tvKal = listItemView.findViewById(R.id.tvkal);

        Foods foods = foodsList.get(position);
        tvName.setText(foods.getName());
        tvKal.setText(foods.getKal());
        return listItemView;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}