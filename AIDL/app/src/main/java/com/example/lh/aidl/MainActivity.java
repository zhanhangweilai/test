package com.example.lh.aidl;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.lh.aidlservice.IMyAidlInterface;

public class MainActivity extends Activity implements Button.OnClickListener{
    private TextView textView;
    EditText editTextNum1,editTextNum2;
    private Button button;
    int num1,num2;
    int total;
    private IMyAidlInterface myAidlInterface =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.btn_add);
        textView = (TextView)findViewById(R.id.tv);
        editTextNum1 = (EditText) findViewById(R.id.tv2);
        editTextNum2 = (EditText) findViewById(R.id.tv3);
        Log.i("lihang",editTextNum1.getText().toString());
        Log.i("lihang",editTextNum2.getText().toString());
        Intent intent = new Intent();
        intent.setAction("com.MyService");
        intent.setPackage("com.example.lh.aidlservice");
        bindService(intent,serviceConnection, Context.BIND_AUTO_CREATE);
        button.setOnClickListener(this);
    }
    public void onClick (View view){
        num1 = Integer.parseInt(editTextNum1.getText().toString());
        num2 = Integer.parseInt(editTextNum2.getText().toString());
        try {
            int total = myAidlInterface.add(num1,num2);
            textView.setText("total="+total);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            myAidlInterface = IMyAidlInterface.Stub.asInterface(iBinder);
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(serviceConnection);
    }
}
