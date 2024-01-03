package com.example.healthcaremain;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class SearchAdapter2 extends BaseAdapter {

    private Context context;
    private List<Exercise> list;
    private LayoutInflater inflate2;
    private ViewHolder2 viewHolder2;

    public SearchAdapter2(List<Exercise> list, Context context) {
        this.list = list;
        this.context= context;
        this.inflate2 = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i).getexeName();
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView2, ViewGroup parent) {
        if(convertView2 == null){
            convertView2 = inflate2.inflate(R.layout.row_listview2,null);

            viewHolder2 = new ViewHolder2();
            viewHolder2.label2 = (TextView) convertView2.findViewById(R.id.label2);

            convertView2.setTag(viewHolder2);
        }else{
            viewHolder2 = (ViewHolder2)convertView2.getTag();
        }

        // 리스트에 있는 데이터를 리스트뷰 셀에 뿌린다.
        viewHolder2.label2.setText((CharSequence) list.get(position));

        return convertView2;
    }

    class ViewHolder2{
        public TextView label2;
    }
}
