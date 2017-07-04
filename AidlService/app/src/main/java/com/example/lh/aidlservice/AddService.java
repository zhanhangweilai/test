package com.example.lh.aidlservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.lh.aidlservice.IMyAidlInterface;
/**
 * Created by lihang on 17-6-16.
 */

public class AddService extends Service{
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mIBinder;

    }

    IMyAidlInterface.Stub mIBinder = new IMyAidlInterface.Stub() {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public int add(int a, int b) throws RemoteException {
            Log.i("lihang","excute add");
            return a+b;
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent,  int flags, int startId) {
        Log.i("lihang","onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("lihang","onDestory");
    }
}
