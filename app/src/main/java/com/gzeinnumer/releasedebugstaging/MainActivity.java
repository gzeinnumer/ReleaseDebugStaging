package com.gzeinnumer.releasedebugstaging;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.tv_textview);

        if (BuildConfig.BUILD_TYPE.equals("release")) {
            textView.setText("release" + " " + BuildConfig.IS_DEBUG);
        } else if (BuildConfig.BUILD_TYPE.equals("staging")){
            textView.setText("staging" + " " + BuildConfig.IS_DEBUG);
        } else if (BuildConfig.BUILD_TYPE.equals("debug")){
            textView.setText("debug" + " " + BuildConfig.IS_DEBUG);
        }
    }

    public static boolean isDebugActive(){
        return BuildConfig.BUILD_TYPE.equals("debug"); //true if debug
    }

    public static boolean isStagingActive(){
        return BuildConfig.BUILD_TYPE.equals("staging"); //true if staging
    }
}