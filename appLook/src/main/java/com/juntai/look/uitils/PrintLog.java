package com.juntai.look.uitils;

import android.util.Log;

public class PrintLog {
    public static boolean printLog = true;
    public static void printlog(String message){
        String title = "hcb_Logcat";
        printlog(title,message);

    }

    public static void printlog(String title, String message){
        if(printLog)
        Log.d(title,message);
    }
}
