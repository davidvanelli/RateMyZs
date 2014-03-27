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

import static android.view.View.FIND_VIEWS_WITH_CONTENT_DESCRIPTION;
import static android.view.View.OnClickListener;

public class StartRecording extends ActionBarActivity implements SensorEventListener {

    public SensorManager mSensorManager;
    public Sensor mAccelerometer;
    public TextView accelerometerText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_recording);

        //if (savedInstanceState == null) {
        //    getSupportFragmentManager().beginTransaction()
        //            .add(R.id.container, new PlaceholderFragment())
        //            .commit();
        //}

        accelerometerText = (TextView) findViewById(R.id.accTextView);
        Button startButton = (Button) findViewById(R.id.startButton);
        Button stopButton = (Button) findViewById(R.id.stopButton);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);



        startButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Accelerometer is being listened to");
                onResume();

            }
        });

        stopButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("Accelerometer is not being listened to");
                onPause();

            }
        });

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

    protected void onResume() {
        super.onResume();
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);

    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    public void onSensorChanged(SensorEvent event) {
        accelerometerText.setText("X: " + event.values[0] + "\nY: " + event.values[1] + "\nZ: " + event.values[0]);
    }

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
