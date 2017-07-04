package com.example.lh.aidlservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button Btn_start;
    private TextView textView;
    private AddService mAddservice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.tv1);
        Btn_start = (Button) findViewById(R.id.btn_start);
        Btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AddService.class);
                startService(intent);

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mAddservice != null) {
           mAddservice.stopSelf();
        }
    }
}
