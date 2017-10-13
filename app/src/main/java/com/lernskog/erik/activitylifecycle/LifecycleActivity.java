package com.lernskog.erik.activitylifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.text.format.Time;
import android.widget.TextView;

public class LifecycleActivity extends Activity {
    private TextView textview = null;

    private void print(String text) {
        Time now = new Time();
        now.setToNow();
        String timeString = now.format("%H:%M:%S");
        String line = timeString + ": " + text + "\n";
        textview.setText(textview.getText() + line);
        textview.invalidate();
        textview.postInvalidate();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textview = new TextView(this);
        if (savedInstanceState != null) {
            print("onCreate restore");
            textview.setText(savedInstanceState.getString("LOG"));
        } else {
            textview.setText("");
        }
        setContentView(textview);
        print("onCreate");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        textview.setText(savedInstanceState.getString("LOG"));
        print("onRestoreInstanceState");
    }

    @Override
    protected void onStart() {
        super.onStart();
        print("onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        print("onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        print("onResume");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        print("onSaveInstanceState");
        outState.putString("LOG", textview.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onPause() {
        super.onPause();
        print("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        print("onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        print("onDestroy");
    }
}
