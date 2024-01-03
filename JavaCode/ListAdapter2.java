package com.example.healthcaremain;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ListAdapter2 extends ArrayAdapter {

    private Activity mContext;
    List<Exercise> exerciseList;
    List<String> exel;

    public ListAdapter2(Activity mContext, List<Exercise> exerciseList) {
        super(mContext, R.layout.list_item2, exerciseList);
        this.mContext = mContext;
        this.exerciseList = exerciseList;
    }
   public ListAdapter2(exeSearch mContext, List<String> exel) {
        super(mContext,R.layout.list_item2,exel);
        this.mContext = mContext;
        this.exel =exel;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = mContext.getLayoutInflater();
        View listItemView = inflater.inflate(R.layout.list_item2,null,true);

        TextView tvName2 = listItemView.findViewById(R.id.tvname2);
        TextView tvKal2 = listItemView.findViewById(R.id.tvkal2);

        Exercise exercise= exerciseList.get(position);
        tvName2.setText(exercise.getexeName());
        tvKal2.setText(exercise.getexeKal());
        return listItemView;
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
}
