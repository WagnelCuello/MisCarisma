package com.yowaelectronics.app.miscantos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private CardView cvMyList, cvList, cvLaudes, cvBible, cvResucito, cvCantos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cvMyList = findViewById(R.id.cvMyList);
        cvList = findViewById(R.id.cvList);
        cvLaudes = findViewById(R.id.cvLaudes);
        cvBible = findViewById(R.id.cvBible);
        cvResucito = findViewById(R.id.cvResucito);
        cvCantos = findViewById(R.id.cvCantos);

        cvMyList.setOnClickListener(this);
        cvList.setOnClickListener(this);
        cvLaudes.setOnClickListener(this);
        cvBible.setOnClickListener(this);
        cvResucito.setOnClickListener(this);
        cvCantos.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getTag().equals("myList")){
            //TODO: Here all code
        }else if(v.getTag().equals("list")){
            //TODO: Here all code
        }else if(v.getTag().equals("laudes")){
            //TODO: Here all code
        }else if(v.getTag().equals("bible")){
            //TODO: Here all code
        }else if(v.getTag().equals("bible")){
            //TODO: Here all code
        }else if(v.getTag().equals("resucito")){
            //TODO: Here all code
        }else if(v.getTag().equals("cantos")){
            //TODO: Here all code
        }
    }
}
