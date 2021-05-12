package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView mainList;
    private ArrayList<Painter> painters;
    private ArrayList<Painter> painters2;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        mainList = findViewById(R.id.mainList);
        painters = new ArrayList<>();
        painters2 = new ArrayList<>();
        painters.add(new Painter("Leonardo","da Vinci",R.drawable.vinci));
        painters.add(new Painter("Rafael","Santi",R.drawable.santi));
        painters.add(new Painter("Claude","Monet",R.drawable.monet));
        PainterAdapter adapter = new PainterAdapter(this,painters);
        PainterAdapter adapter1 = new PainterAdapter(this,painters2);
        mainList.setAdapter(adapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if(adapter.isEnabled())
                for (Painter painter: painters){
                    if (painter.isToDelete() ==false){
                        painters2.add(painter);
                    }
                }
                mainList.setAdapter(adapter1);
                /*else {
                    for (Painter painter : painters2){
                    if (painter.isToDelete() == true){
                    painter.add(painter);
                    }
                    }
                    mainList.setAdapter(adapter);
               }*/
            }
        });
    }
}