package com.micnubinub.wifidirecttools;

/**
 * Created by root on 9/09/14.
 */
public class WifiDirectThread extends Thread {
    boolean run = true;

    public WifiDirectThread(Runnable runnable) {
        super(runnable);
    }

    @Override
    public void run() {
        super.run();
        while (run){



        }
    }


}
