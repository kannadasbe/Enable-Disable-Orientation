package com.kannadasang.enabledisableorientation;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class SampleActivity extends AppCompatActivity {
TextView tvOrientation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        tvOrientation = (TextView) findViewById(R.id.tvOrientation);
        //1 for Portrait and 2 for Landscape
        int screenOrientation = getApplicationContext().getResources().getConfiguration().orientation;
        if(screenOrientation == 1)
            tvOrientation.setText("Orientation : Portrait");
        else if(screenOrientation == 2)
            tvOrientation.setText("Orientation : Landscape");
        else
            tvOrientation.setText("Orientation : Undefined");
    }

    // OnClick handler for btEnable
    public void enableOrientation(View view)
    {
        setOrientation(true);
    }

    // OnClick handler for btDisable
    public void disableOrientation(View view)
    {
        setOrientation(false);
    }

    public void setOrientation(boolean status) {
        if (status) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_USER);
        } else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        }
    }

}
