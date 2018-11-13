package com.example.invisiblehacker.apk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Bmi extends AppCompatActivity {
    TextView wgt,ft,inch,bmi;
    Float weight,hgt,feet,inches,ans;
    Button b;
    String res;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        b=(Button)findViewById(R.id.button);
        wgt=(TextView)findViewById(R.id.wgt);
        ft=(TextView)findViewById(R.id.ft);
        inch=(TextView)findViewById(R.id.inch);
        bmi=(TextView)findViewById(R.id.bmi);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weight=Float.parseFloat(wgt.getText().toString());
                feet=Float.parseFloat(ft.getText().toString());
                inches=Float.parseFloat(inch.getText().toString());
                hgt=(((feet*12)+inches)*5)/200;
                ans=(weight/hgt)/hgt;
                res=""+ans;
                bmi.setText(res);

            }
        });


    }

}

