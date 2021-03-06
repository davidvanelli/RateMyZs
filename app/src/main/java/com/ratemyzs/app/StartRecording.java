package com.ratemyzs.app;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import java.util.ArrayList;

import static android.view.View.FIND_VIEWS_WITH_CONTENT_DESCRIPTION;
import static android.view.View.OnClickListener;

public class StartRecording extends ActionBarActivity { // implements SensorEventListener {

    public SensorManager mSensorManager;
    public Sensor mAccelerometer;
    public TextView accelerometerText, changeText;
    public float x,y,z;
    public boolean running = false;
    public ArrayList<Integer> changeList = new ArrayList<Integer>();
    private State rState = State.PAUSED;
    private int count;
    public AccelManager accel = new AccelManager();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_recording);

        //if (savedInstanceState == null) {
        //    getSupportFragmentManager().beginTransaction()
        //            .add(R.id.container, new PlaceholderFragment())
        //            .commit();
        //}

        //accelerometerText = (TextView) findViewById(R.id.accTextView);
        //changeText = (TextView) findViewById(R.id.changeView);

        Button startButton = (Button) findViewById(R.id.startButton);
        Button stopButton = (Button) findViewById(R.id.stopButton);





        startButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Accelerometer is being listened to");
                start();

            }
        });

        stopButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("Accelerometer is not being listened to");
                pause();

            }
        });

//        changeList.add(1);
//        changeList.add(2);
//        changeList.add(3);
//        changeList.add(4);
//        changeList.add(5);
//        changeList.add(6);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.start_recording, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public enum State {RUNNING, PAUSED};

    public void start() {
        accel.startRecording();
    }

    public void pause() {
        accel.pause();
    }
    /**
    protected void onResume() {
        super.onResume();

        //AccelManager man1 = new AccelManager();
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSensorManager.registerListener(this, mAccelerometer, 200);

        //boolean sRecord = true;
        changeText.setText("Accessing onResume");
        startRecording();
        //mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }*/

    /**
    protected void onPause() {
        super.onPause();
        rState = State.PAUSED;
        mSensorManager.unregisterListener(this);

        changeText.setText(changeList.toString());

    } */

    /**
    public void startRecording()
    {

        //running = true;
        changeList = new ArrayList<Integer>();
        //rState = State.RUNNING;

        ++count;
        if(rState == State.PAUSED)
        {
            rState = State.RUNNING;
            changeText.append("\nRunning" + count);

            //long startThirty = System.currentTimeMillis();
            long endThirty = System.currentTimeMillis() + 30000;
            int change = 0;

            if (System.currentTimeMillis() != endThirty)
            {
                //changeText.append("\n\nRunning2");

                //float zerop1 = (x + 1);
                //float zerom1 = (x - 1);
                //float onep1 = (y + 1);
                //float onem1 = (y - 1);
                //float twop1 = (z + 1);
                //float twom1 = (z - 1);

               // if ((x == zerop1 || x == zerom1) || (y == onep1  || y == onem1) || (z == twop1  || z == twom1))
               // {
                   // ++change;
                //};
            //}

            //changeList.add(change);

        //}
    }*/


    //public void onAccuracyChanged(Sensor sensor, int accuracy) {
    //}

    //public void onSensorChanged(SensorEvent event) {
        //x = event.values[0] * 10;
        //y = event.values[1] * 10;
        //z = event.values[2] * 10;

        //accelerometerText.setText("X: " + x + "\nY: " + y + "\nZ: " + z);
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

    //}

    public void showToast(String message)
    {
        Toast.makeText(getBaseContext(), message, Toast.LENGTH_SHORT).show();
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    /**
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_start_recording, container, false);
            return rootView;
        }

    }
        */

}
