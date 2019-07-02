package com.example.chapter3.homework.Fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.chapter3.homework.R;

import java.util.List;

public class MyAdapter extends ArrayAdapter<String> {
    private int layoutId;

    public MyAdapter(Context context, int layoutId, List<String> list){
        super(context, layoutId, list);
        this.layoutId = layoutId;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String str = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(layoutId,parent,false);
        TextView textView = (TextView) view.findViewById(R.id.list_text);

        textView.setText(str);

        return view;
    }


}
