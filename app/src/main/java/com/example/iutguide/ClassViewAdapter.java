package com.example.iutguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ClassViewAdapter extends BaseAdapter {

    String[] courseInfo;
    String[] starting;
    String[] ending;
    Context context;
    private LayoutInflater inflater;

    ClassViewAdapter(Context context, String[] courseInfo, String[] starting,String[] ending){
        this.context=context;
        this.courseInfo = courseInfo;
        this.starting = starting;
        this.ending = ending;

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view==null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.activity_class_view_layout,viewGroup,false);


        }

        TextView courseName = view.findViewById(R.id.courseName);
        TextView start = view.findViewById(R.id.start);
        TextView end = view.findViewById(R.id.end);

        courseName.setText(courseInfo[i]);
        start.setText(starting[i]);
        end.setText(ending[i]);

        return null;
    }
}
