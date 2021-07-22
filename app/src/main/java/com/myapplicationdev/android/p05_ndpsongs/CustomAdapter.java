package com.myapplicationdev.android.p05_ndpsongs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context context;
    int resource;
    ArrayList<Song> al;

    public CustomAdapter(@NonNull Context context, int resource, ArrayList<Song> al) {
        super(context, resource,al);

        this.context=context;
        this.resource=resource;
        this.al=al;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView=inflater.inflate(resource,parent,false);




        Song currentVersion=al.get(position);



        TextView tvBlue=rowView.findViewById(R.id.tvBlue);
        TextView tvGrey=rowView.findViewById(R.id.tvGrey);
        TextView tvRed=rowView.findViewById(R.id.tvRed);
        TextView tvLightBlue=rowView.findViewById(R.id.tvLightBlue);

        tvBlue.setText(currentVersion.getTitle());
        tvGrey.setText(String.valueOf(currentVersion.getYearReleased()));

        String starsString="";

        for(int i = 0; i < currentVersion.getStars(); i++){
            starsString += "*";
        }
        tvRed.setText(starsString);
        tvLightBlue.setText(currentVersion.getSingers());



        return rowView;


    }
}
