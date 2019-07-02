package com.example.chapter3.homework.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.chapter3.homework.R;

import java.util.ArrayList;
import java.util.List;

public class HelloFragment extends Fragment {

    private List<String> dataList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        for(int i = 0;i < 20; i++){
            dataList.add("Item "+i);
        }
        MyAdapter myAdapter = new MyAdapter(getActivity(),R.layout.list_view,dataList);
        View view = inflater.inflate(R.layout.fragment_hello,container,false);
        ListView listView = view.findViewById(R.id.list_view);
        listView.setAdapter(myAdapter);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
            }
        }, 5000);
    }

}
