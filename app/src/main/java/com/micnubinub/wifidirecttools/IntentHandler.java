package com.micnubinub.wifidirecttools;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by root on 9/09/14.
 */
public class IntentHandler extends IntentService {
    public IntentHandler(String name) {
        super(name);
    }

    private static void handleCommandNumber(int command) {
        switch (command) {
            case StaticValues.TOGGLE_TORCH:
                break;
/*
    case StaticValues.TOGGLE_TORCH:
        break;

    case StaticValues.TOGGLE_TORCH:
        break;

    case StaticValues.TOGGLE_TORCH:
        break;

    case StaticValues.TOGGLE_TORCH:
        break;

    case StaticValues.TOGGLE_TORCH:
        break;

    case StaticValues.TOGGLE_TORCH:
        break;

    case StaticValues.TOGGLE_TORCH:
        break;

    case StaticValues.TOGGLE_TORCH:
        break;

    case StaticValues.TOGGLE_TORCH:
        break;

    case StaticValues.TOGGLE_TORCH:
        break;

    case StaticValues.TOGGLE_TORCH:
        break;

    case StaticValues.TOGGLE_TORCH:
        break;*/
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        final String input = intent.getExtras().getString(StaticValues.COMMAND, "null");
        try {
            handleCommandNumber(Integer.parseInt(input));
        } catch (Exception e) {
            Log.e("Failed to handle intent:", input);
        }
    }

}
