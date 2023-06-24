package com.example.lr6;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SightAdapter extends ArrayAdapter<Point> {
    private Context context;

    private ArrayList<Point> points;

    private User user;

    @Override
    public int getCount() {
        return points.size();
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.list_node, null);
        TextView name = convertView.findViewById(R.id.name);
        TextView time = convertView.findViewById(R.id.time);
        TextView cost = convertView.findViewById(R.id.cost);
        name.setText(points.get(position).getName());
        time.setText(points.get(position).getTime());
        cost.setText(points.get(position).getCost());

        return convertView;
    }

    public SightAdapter(Context context, ArrayList<Point> POIList, User user) {
        super(context, 0, POIList);
        this.context = context;
        this.points = POIList;
        this.user = user;
    }

    public void setPoints(ArrayList<Point> points) {
        this.points = points;
        notifyDataSetChanged();
    }
}
