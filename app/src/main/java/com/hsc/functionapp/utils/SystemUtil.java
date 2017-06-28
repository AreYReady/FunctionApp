package com.hsc.functionapp.utils;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.InputFilter;
import android.widget.TextView;


import java.lang.reflect.Field;


/**
 * @author xjunda
 * @date 2016-08-08
 */
public class SystemUtil {
    /**
     * 当前activity是否在最前面
     *
     * @param context
     * @param activityName
     * @return
     */
    public static boolean isTopActivity(Context context, String activityName) {
        boolean isTop = false;
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        ComponentName cn = am.getRunningTasks(1).get(0).topActivity;
        if (cn.getClassName().contains(activityName)) {
            isTop = true;
        }
        return isTop;
    }

    /**
     * 是否锁屏
     * @param context
     * @return
     */
    public static boolean isScreenOn(Context context){
        KeyguardManager mKeyguardManager = (KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE);
        boolean flag = mKeyguardManager.inKeyguardRestrictedInputMode();
        return !flag;
    }


    /**
 　　* 获取设置的最大长度
 　　*
 　　* @return
 　　*/
    public static int getMaxLength(TextView tv) {
        int length = 0;
        try {
            InputFilter[] inputFilters = tv.getFilters();
            for (InputFilter filter : inputFilters) {
                Class<?> c = filter.getClass();
                if (c.getName().equals("android.text.InputFilter$LengthFilter")) {
                    Field[] f = c.getDeclaredFields();
                    for (Field field : f) {
                        if (field.getName().equals("mMax")) {
                            field.setAccessible(true);
                            length = (Integer) field.get(filter);
                            }
                        }
                    }
                }
            } catch (Exception e) {
            e.printStackTrace();
            }
        return length;
        }

    public static String getTAG(Class className){
        return "hsc : "+ className.getSimpleName();
    }
    public static String getTAG(Object object){
        return "hsc : "+ object.getClass().getSimpleName();
    }

}
