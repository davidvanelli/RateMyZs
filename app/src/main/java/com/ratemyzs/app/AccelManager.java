package com.ratemyzs.app;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.TextView;


import java.lang.Runnable;
import java.util.ArrayList;

/**
 * Created by David on 4/9/14.
 */
public class AccelManager extends Activity implements SensorEventListener {
    final int interval = 30;
    public int count = 0;
    public SensorManager mSensorManager;
    public Sensor mAccelerometer;
    private State rState;
    private Runnable record;
    private Thread accelThread;
    public TextView accelerometerText, changeText;
    public ArrayList<Integer> changeList;
    float x,y,z;

    public void AccelManager(){

    }

    public enum State {RUNNING, PAUSED};

    public void startRecording()
    {
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSensorManager.registerListener(this, mAccelerometer, 200);

        changeText = (TextView) findViewById(R.id.changeView);
        accelerometerText = (TextView) findViewById(R.id.accTextView);

        record = new Runnable() {
            @Override
            public void run() {
                runCode();
            }
        };
        accelThread = new Thread(record);
        accelThread.start();

    }

    public void pause()
    {
        rState = State.PAUSED;
    }


    public void runCode()
    {
        //running = true;
        changeList = new ArrayList<Integer>();
        rState = State.RUNNING;

        ++count;
        while(rState == State.RUNNING)
        {
            changeText.append("\nRunning" + count);

            //long startThirty = System.currentTimeMillis();
            long endThirty = System.currentTimeMillis() + 30000;
            int change = 0;

            while (System.currentTimeMillis() != endThirty)
            {
                changeText.append("\n\nRunning2");

                float zerop1 = (x + 1);
                float zerom1 = (x - 1);
                float onep1 = (y + 1);
                float onem1 = (y - 1);
                float twop1 = (z + 1);
                float twom1 = (z - 1);

                if ((x >= zerop1 || x <= zerom1) || (y >= onep1  || y <= onem1) || (z >= twop1  || z <= twom1))
                {
                    ++change;
                }
            }

            changeList.add(change);

        }

        changeText.append(changeList.toString());
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    public void onSensorChanged(SensorEvent event) {
        x = event.values[0] * 10;
        y = event.values[1] * 10;
        z = event.values[2] * 10;

        accelerometerText.setText("X: " + x + "\nY: " + y + "\nZ: " + z);


//        final float alpha = (float) 0.8;
//        float[] gravity = new float[3];
//        float[] linear_acceleration = new float[3];

//        gravity[0] = alpha * gravity[0] + (1 - alpha) * event.values[0];
//        gravity[1] = alpha * gravity[1] + (1 - alpha) * event.values[1];
//        gravity[2] = alpha * gravity[2] + (1 - alpha) * event.values[2];

//        linear_acceleration[0] = event.values[0] - gravity[0];
//        linear_acceleration[1] = event.values[1] - gravity[1];
//        linear_acceleration[2] = event.values[2] - gravity[2];

//        accelerometerText.setText("X: " + (linear_acceleration[0] * 10) + "\nY: " + (linear_acceleration[1] * 10) + "\nZ: " + (linear_acceleration[0] * 10));

    }
}
