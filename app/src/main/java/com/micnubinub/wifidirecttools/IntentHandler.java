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

            case StaticValues.SET_TORCH:


                break;

            case StaticValues.CHAT_MESSAGE:


                break;

            case StaticValues.DELETE_FILE:


                break;

            case StaticValues.DOWNLOAD_FILE:


                break;

            case StaticValues.OPEN_FILE:


                break;

            case StaticValues.GET_FILE_TREE:


                break;

            case StaticValues.MOVE_FILE:


                break;

            case StaticValues.STREAM_FILE:


                break;

            case StaticValues.GET_FILE_DETAILS:


                break;

            case StaticValues.MEDIA_CONTROL_PLAY_PAUSE:


                break;

            case StaticValues.MEDIA_CONTROL_PREVIOUS:


                break;

            case StaticValues.MEDIA_CONTROL_SKIP:


                break;

            case StaticValues.TAKE_PICTURE_FRONT:


                break;

            case StaticValues.TAKE_PICTURE_BACK:


                break;

            case StaticValues.CREATE_DIRECTORY:


                break;

            case StaticValues.PRESS_BACK:


                break;

            case StaticValues.PRESS_HOME:


                break;

            case StaticValues.PRESS_VOLUME_DOWN:


                break;

            case StaticValues.PRESS_VOLUME_UP:


                break;

            case StaticValues.PRESS_MENU:


                break;

            case StaticValues.RECORD_AUDIO:


                break;

            case StaticValues.RECORD_VIDEO_BACK:


                break;

            case StaticValues.RECORD_VIDEO_FRONT:


                break;

            case StaticValues.SET_BLUETOOTH:


                break;

            case StaticValues.SET_BRIGHTNESS:


                break;

            case StaticValues.SET_BRIGHTNESS_MODE:


                break;

            case StaticValues.SET_NOTIFICATION_VOLUME:


                break;

            case StaticValues.SET_MEDIA_VOLUME:


                break;

            case StaticValues.SET_RINGER_VOLUME:


                break;

            case StaticValues.SPOOF_TOUCH:


                break;

            case StaticValues.SPOOF_TOUCH_FINGER_2:


                break;


        }
    }

    @Override
    public void setIntentRedelivery(boolean enabled) {
        super.setIntentRedelivery(enabled);
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
