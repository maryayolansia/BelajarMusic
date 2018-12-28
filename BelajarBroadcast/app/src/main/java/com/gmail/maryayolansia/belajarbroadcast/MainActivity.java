package com.gmail.maryayolansia.belajarbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver battInfoReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int level = intent.getIntExtra("level", 0);
            //koneksi kelas java
            ProgressBar progressBar = (ProgressBar) findViewById(R.id.prgressBar);
            progressBar.setProgress(level);

            TextView textView = (TextView) findViewById(R.id.textstatus);
            textView.setText("Level baterai:" +Integer.toString(level) +"%");

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerReceiver(battInfoReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }
}
