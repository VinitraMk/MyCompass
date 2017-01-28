package com.example.android.mycompass;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.hardware.SensorEventListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements SensorEventListener  {

    private TableLayout img;
    private float currdeg = 360f;
    private SensorManager mSensorManager;
    TextView heading;

    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = (TableLayout) findViewById(R.id.compasstable);
        heading = (TextView) findViewById(R.id.heading);
        tv1=(TextView)findViewById(R.id.t1);
        tv2=(TextView)findViewById(R.id.t2);
        tv3=(TextView)findViewById(R.id.t3);
        tv4=(TextView)findViewById(R.id.t4);
        tv5=(TextView)findViewById(R.id.t5);
        tv6=(TextView)findViewById(R.id.t6);
        tv7=(TextView)findViewById(R.id.t7);
        tv8=(TextView)findViewById(R.id.t8);
        tv9=(TextView)findViewById(R.id.t9);
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);


        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,FileActivity.class);
                intent.putExtra("Title","North West");
                startActivity(intent);
            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,FileActivity.class);
                intent.putExtra("Title","North");
                startActivity(intent);
            }
        });
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,FileActivity.class);
                intent.putExtra("Title","North East");
                startActivity(intent);
            }
        });
        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,FileActivity.class);
                intent.putExtra("Title","West");
                startActivity(intent);
            }
        });
        tv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,FileActivity.class);
                intent.putExtra("Title","Brahmasthan");
                startActivity(intent);
            }
        });
        tv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,FileActivity.class);
                intent.putExtra("Title","East");
                startActivity(intent);
            }
        });
        tv7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,FileActivity.class);
                intent.putExtra("Title","South West");
                startActivity(intent);
            }
        });
        tv8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,FileActivity.class);
                intent.putExtra("Title","South");
                startActivity(intent);
            }
        });
        tv9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,FileActivity.class);
                intent.putExtra("Title","South East");
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume(){
        super.onResume();
        mSensorManager.registerListener(this,mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION),SensorManager.SENSOR_DELAY_GAME);
    }
    @Override
    protected void onPause(){
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event){
        float degree=Math.round(event.values[0]);
        heading.setText("Heading: "+Float.toString(degree)+" degrees");
        RotateAnimation ra=new RotateAnimation(currdeg,-degree, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        ra.setDuration(210);
        ra.setFillAfter(true);
        img.startAnimation(ra);
        currdeg=-degree;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}

