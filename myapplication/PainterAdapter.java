package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PainterAdapter extends ArrayAdapter<Painter> {

    private Context context;
    private ArrayList<Painter> dane;

    public PainterAdapter(Context context, ArrayList<Painter> dane){
        super(context,R.layout.list_element,dane);
        this.context=context;
        this.dane=dane;
    }



    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_element, parent,false);
        TextView imie = rowView.findViewById(R.id.imie);
        TextView nazwisko = rowView.findViewById(R.id.nazwisko);
        ImageView obrazek = rowView.findViewById(R.id.imageView);
        CheckBox CheckBox = rowView.findViewById(R.id.checkBox);
        CheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(CheckBox.isChecked())
                    dane.get(position).setToDelete(true);
                else
                    dane.get(position).setToDelete(false);
            }
        });
        imie.setText((dane.get(position).getName()));
        nazwisko.setText(dane.get(position).getSurname());
        obrazek.setImageResource(dane.get(position).getPicture());
        return rowView;
    }
}
