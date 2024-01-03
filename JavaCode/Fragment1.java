package com.example.healthcaremain;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Fragment1 extends Fragment implements View.OnClickListener {
    public static Fragment1 newInstance(int index) {
        Fragment1 f = new Fragment1();
        Bundle bundle = new Bundle();
        bundle.putInt("index", index);
        f.setArguments(bundle);
        return f;
    }
    TextView profile;
    ListView noticeListView;
    private NoticeListAdapter adapter;
    private ImageView profile_photo;
    ArrayList<Notice> noticeList;
    ScrollView mScrollView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_1, container, false);
        noticeList = new ArrayList<>();
        noticeListView= (ListView) v.findViewById(R.id.noticeListView);
        mScrollView = (ScrollView) v.findViewById(R.id.mScrollview);
        profile_photo = (ImageView) v.findViewById(R.id.profile_photo);
        profile = v.findViewById(R.id.profile);
        profile.setOnClickListener(this);

        noticeListView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                mScrollView.requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });



        noticeList.add(new Notice("공지사항입니다.","노영준", "2022-05-20"));
        noticeList.add(new Notice("공지사항입니다.","정인태", "2022-05-20"));
        noticeList.add(new Notice("공지사항입니다.","임혜주", "2022-05-20"));
        noticeList.add(new Notice("공지사항입니다.","개발자", "2022-05-20"));
        noticeList.add(new Notice("공지사항입니다.","노영준", "2022-05-20"));
        noticeList.add(new Notice("공지사항입니다.","정인태", "2022-05-20"));
        noticeList.add(new Notice("공지사항입니다.","임혜주", "2022-05-20"));
        noticeList.add(new Notice("공지사항입니다.","개발자", "2022-05-20"));
        noticeList.add(new Notice("공지사항입니다.","노영준", "2022-05-20"));
        noticeList.add(new Notice("공지사항입니다.","정인태", "2022-05-20"));
        noticeList.add(new Notice("공지사항입니다.","임혜주", "2022-05-20"));
        noticeList.add(new Notice("공지사항입니다.","개발자", "2022-05-20"));
        noticeList.add(new Notice("공지사항입니다.","노영준", "2022-05-20"));
        noticeList.add(new Notice("공지사항입니다.","정인태", "2022-05-20"));
        noticeList.add(new Notice("공지사항입니다.","임혜주", "2022-05-20"));
        noticeList.add(new Notice("공지사항입니다.","개발자", "2022-05-20"));
        noticeList.add(new Notice("공지사항입니다.","노영준", "2022-05-20"));
        noticeList.add(new Notice("공지사항입니다.","정인태", "2022-05-20"));
        noticeList.add(new Notice("공지사항입니다.","임혜주", "2022-05-20"));
        noticeList.add(new Notice("공지사항입니다.","개발자", "2022-05-20"));
        noticeList.add(new Notice("공지사항입니다.","노영준", "2022-05-20"));
        noticeList.add(new Notice("공지사항입니다.","정인태", "2022-05-20"));
        noticeList.add(new Notice("공지사항입니다.","임혜주", "2022-05-20"));
        noticeList.add(new Notice("공지사항입니다.","개발자", "2022-05-20"));

        adapter = new NoticeListAdapter(getContext(), noticeList);
        noticeListView.setAdapter(adapter);

        return v;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.profile:
                Intent intent = new Intent(getActivity(), MyInfoActivity.class);
                startActivity(intent);
                break;
        }
    }
}