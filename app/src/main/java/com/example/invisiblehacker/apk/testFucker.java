package com.example.invisiblehacker.apk;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class testFucker extends AppCompatActivity implements SensorEventListener {
Button b;
    TextView tv;
    SensorManager sm;
    boolean running=false;
    int msteps=0;
Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_fucker);
        b=(Button)findViewById(R.id.bt);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i= new Intent(testFucker.this,StepC.class);
                startActivity(i);
            }
        });



        tv=(TextView)findViewById(R.id.textView);
        sm=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
       /* SensorEventListener sensorEventListener=new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
            msteps+=sensorEvent.values[0];
                Toast.makeText(MainActivity.this, ""+msteps, Toast.LENGTH_SHORT).show();
            tv.setText(""+msteps);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };*/
    }

    @Override
    protected void onResume() {
        super.onResume();
        running=true;
        Sensor count=sm.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        sm.registerListener(this,count,sm.SENSOR_DELAY_UI);
    }

    @Override
    protected void onPause() {
        super.onPause();
        running=false;
        sm.unregisterListener(this);
        //tv.setText("0");
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(running)
        {
            tv.setText(String.valueOf(sensorEvent.values[0]));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    }

