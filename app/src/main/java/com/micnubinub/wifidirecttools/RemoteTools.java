package com.micnubinub.wifidirecttools;

import android.app.AlarmManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.media.MediaRecorder;
import android.os.Environment;
import android.provider.Settings;
import android.view.KeyEvent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Creapackage commicnubinub.wifidirecttools;
 * <p/>
 * import android.app.AlarmManager;
 * import android.app.PendingIntent;
 * import android.content.Context;
 * import android.content.Intent;
 * import android.content.pm.PackageManager;
 * import android.content.pm.ResolveInfo;
 * import android.graphics.Bitmap;
 * import android.hardware.Camera;
 * import android.media.MediaRecorder;
 * import android.os.Environment;
 * import android.provider.Settings;
 * import android.view.KeyEvent;
 * <p/>
 * import java.text.DateFormat;
 * import java.text.SimpleDateFormat;
 * import java.util.ArrayList;
 * import java.util.Calendar;
 * import java.util.List;
 * <p/>
 * /**
 * Created by root on 29/07/14.
 */
public class RemoteTools {

    public static Camera camera;
    private static Context context;

    public RemoteTools(Context c) {
        context = c;
    }

    public static void record(int time_secs) {
        //Todo make it better
        MediaRecorder mediaRecorder = new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setOutputFile(Environment.getExternalStorageDirectory().getAbsolutePath() + "/test/test.mp3");
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        mediaRecorder.setMaxDuration(time_secs);
        try {
            mediaRecorder.prepare();
            mediaRecorder.start();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void record(int time_secs, long when) {
      /*  AlarmManager alarmManager = getAlarmManager();
        Intent intent = new Intent(context(), Remote.class);
        intent.putExtra(StaticValues.SCHEDULED_RECORDING, time_secs);
        PendingIntent pendingIntent = PendingIntent.getService(context(), 0, intent, 0);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (when * 60000), pendingIntent);
        context().startService(intent);
*/
    }

    public static void spoofTouch(int x, int y) {

    }

    public static Bitmap getScreenShot() {
        Bitmap bitmap = null;


        return bitmap;
    }

    public static void takePictureFront() {
        final Camera camera = Camera.open();


    }

    public static void takePictureBack() {


    }

    public static void playMusic() {
        Intent downIntent = new Intent(Intent.ACTION_MEDIA_BUTTON, null);
        KeyEvent downEvent = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE);
        downIntent.putExtra(Intent.EXTRA_KEY_EVENT, downEvent);
        context().sendBroadcast(downIntent);
    }

    public static void skipTrack() {
        Intent downIntent = new Intent(Intent.ACTION_MEDIA_BUTTON, null);
        KeyEvent downEvent = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_NEXT);
        downIntent.putExtra(Intent.EXTRA_KEY_EVENT, downEvent);
        context().sendBroadcast(downIntent);
    }

    public static void previousTrack() {
        Intent downIntent = new Intent(Intent.ACTION_MEDIA_BUTTON, null);
        KeyEvent downEvent = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_PREVIOUS);
        downIntent.putExtra(Intent.EXTRA_KEY_EVENT, downEvent);
        context().sendBroadcast(downIntent);
    }

    public static void setBrightness(int percent) {
        Settings.System.putInt(context().getContentResolver(), Settings.System.SCREEN_BRIGHTNESS_MODE, Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL);
        Settings.System.putInt(context().getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, ((int) ((percent / 100f) * 255)));
    }

    public static void setBrightnessAuto() {
        Settings.System.putInt(context().getContentResolver(), Settings.System.SCREEN_BRIGHTNESS_MODE, Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC);
    }

    public static void setVolumeAll(int percent) {
        setVolumeAlarm(percent);
        setVolumeMedia(percent);
        setVolumeNotification(percent);
        setVolumeRinger(percent);
    }

    public static void setVolumeMedia(int percent) {
        Settings.System.putInt(context().getContentResolver(), Settings.System.VOLUME_MUSIC, ((int) ((percent / 100f) * 15)));
    }

    public static void setVolumeAlarm(int percent) {
        Settings.System.putInt(context().getContentResolver(), Settings.System.VOLUME_ALARM, ((int) ((percent / 100f) * 15)));
    }

    public static void setVolumeNotification(int percent) {
        Settings.System.putInt(context().getContentResolver(), Settings.System.VOLUME_NOTIFICATION, ((int) ((percent / 100f) * 15)));
    }

    public static void setVolumeRinger(int percent) {
        Settings.System.putInt(context().getContentResolver(), Settings.System.VOLUME_RING, ((int) ((percent / 100f) * 15)));
    }

    private static Context context() {
        return context;
    }

    private static AlarmManager getAlarmManager() {
        return (AlarmManager) context().getSystemService(Context.ALARM_SERVICE);
    }

    public static void sendMessage(String message) {

    }

    public static void getPackages(Context context) {

        PackageManager packageManager = context.getPackageManager();
        final Intent i = new Intent(Intent.ACTION_MAIN, null);
        i.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> list = packageManager.queryIntentActivities(i, 0);
        // ArrayList<String> pacs = new ArrayList<String>(list.size());

        for (int ii = 0; ii < list.size(); ii++) {
            //  pacs.add(ii, list.get(ii).activityInfo.packageName);
//Todo print the files here
        }

    }

    public static void launchInt(Context context, int ii) {
        ii = ii - 1 > 0 ? ii - 1 : 0;

        PackageManager packageManager = context.getPackageManager();
        final Intent i = new Intent(Intent.ACTION_MAIN, null);
        i.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> list = packageManager.queryIntentActivities(i, 0);
        Intent LaunchApp = packageManager.getLaunchIntentForPackage(list.get(ii).activityInfo.packageName);
        context.startActivity(LaunchApp);

    }

    public static void launchPackage(Context context, String packageName) {
        PackageManager packageManager = context.getPackageManager();
        Intent LaunchApp = packageManager.getLaunchIntentForPackage(packageName);
        context.startActivity(LaunchApp);
    }

    public static ArrayList<String> getBroadcastRecievers(Context context) {
        //Todo

        PackageManager packageManager = context.getPackageManager();
        final Intent i = new Intent(Intent.ACTION_MAIN, null);
        List<ResolveInfo> list = packageManager.queryBroadcastReceivers(i, 0);
        ArrayList<String> pacs = new ArrayList<String>(list.size());

        for (int ii = 0; ii < list.size(); ii++) {

            pacs.add(ii, list.get(ii).loadLabel(packageManager).toString() + " (" + list.get(ii).activityInfo.packageName + ")");
        }

        return pacs;
    }


    public static void toggleTorch(Context context) {
        try {

            if (camera == null)
                camera = Camera.open();
            else
                camera.reconnect();

            final PackageManager packageManager = context.getPackageManager();

            if (packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA)) {

                if (packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)) {
                    Camera.Parameters p = camera.getParameters();
                    if (p.getFlashMode().equals(Camera.Parameters.FLASH_MODE_TORCH)) {
                        p.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                        camera.setParameters(p);
                        camera.stopPreview();
                        camera.release();
                        camera = null;
                    } else {
                        p.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                        camera.setParameters(p);
                        camera.startPreview();
                    }
                } else {
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static String fileSize(long size) {
        String s = String.valueOf(size) + "Bytes";

        if (size < 1024)
            return s;

        if (size > 1024 && size < Math.pow(2, 20)) {
            s = String.format("%.3f", size / 1024) + "KB";
            return s;
        }

        if (size > Math.pow(2, 20) && size < Math.pow(2, 30)) {
            s = String.format("%.3f", size / Math.pow(2, 20)) + "MB";
            return s;
        }

        if (size > Math.pow(2, 30) && size < Math.pow(2, 40)) {
            s = String.format("%.3f", size / Math.pow(2, 30)) + "GB";
            return s;
        }

        if (size > Math.pow(2, 40)) {
            s = String.format("%.3f", size / Math.pow(2, 40)) + "TB";
            return s;
        }

        return s;
    }

    public static String getDate(long date) {
        // Create a DateFormatter object for displaying date in specified format.
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

        // Create a calendar object that will convert the date and time value in milliseconds to date.
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(date);
        return formatter.format(calendar.getTime());
    }

}

