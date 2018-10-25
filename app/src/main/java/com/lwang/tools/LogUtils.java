package com.lwang.tools;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.orhanobut.logger.Logger;

import org.json.JSONObject;

/**
 * @author lwang
 * @date 2018/10/25
 * @description Log工具类
 */
public class LogUtils {

    /**
     * 日志输出级别NONE
     */
    public static final int LEVEL_NONE = 0;//上线级别

    /**
     * 日志输出级别V
     */
    private static final int LEVEL_VERBOSE = 1;

    /**
     * 日志输出级别D
     */
    private static final int LEVEL_DEBUG = 2;

    /**
     * 日志输出级别I
     */
    private static final int LEVEL_INFO = 3;

    /**
     * 日志输出级别W
     */
    private static final int LEVEL_WARN = 4;

    /**
     * 日志输出级别E
     */
    private static final int LEVEL_ERROR = 5;

    /**
     * 日志输出时的TAG
     */
    private static final String M_TAG = "wang";

    /**
     * 是否允许输出log LEVEL_NONE时候不输出日志，在上线时将mDebuggable = LEVEL_NONE
     */
    public static int mDebuggable = LEVEL_ERROR;


    /**
     * 以级别为 v 的形式输出LOG
     */
    public static void v(boolean boo, Object msg) {
        if (mDebuggable >= LEVEL_VERBOSE) {
            if (boo) {
                Logger.t(M_TAG).v(msg + "");
            } else {
                Log.v(M_TAG, msg + "");
            }
        }
    }

    /**
     * 以级别为 d 的形式输出LOG
     */
    public static void d(boolean boo, Object msg) {
        if (mDebuggable >= LEVEL_DEBUG) {
            if (boo) {
                Logger.t(M_TAG).d(msg + "");
            } else {
                Log.d(M_TAG, msg + "");
            }
        }
    }

    /**
     * 以级别为 i 的形式输出LOG
     */
    public static void i(boolean boo, Object msg) {
        if (mDebuggable >= LEVEL_INFO) {
            if (boo) {
                Logger.t(M_TAG).i(msg + "");
            } else {
                Log.i(M_TAG, msg + "");
            }
        }
    }

    /**
     * 以级别为 w 的形式输出LOG
     */
    public static void w(boolean boo, Object msg) {
        if (mDebuggable >= LEVEL_WARN) {
            if (boo) {
                Logger.t(M_TAG).w(msg + "");
            } else {
                Log.w(M_TAG, msg + "");
            }
        }
    }

    /**
     * 以级别为 e 的形式输出LOG
     */
    public static void e(boolean boo, Object msg) {
        if (mDebuggable >= LEVEL_ERROR) {
            if (boo) {
                Logger.t(M_TAG).e(msg + "");
            } else {
                Log.e(M_TAG, msg + "");
            }
        }
    }

    /**
     * 格式化
     *
     * @param jsonObject
     */
    public static void Json(@NonNull JSONObject jsonObject) {
        if (mDebuggable >= LEVEL_ERROR) {
            if (jsonObject != null) {
                Logger.json(jsonObject.toString());
            } else {
                LogUtils.e(true, "json()参数 jsonObject 参数为null，请检查！");
            }
        }
    }

    /**
     * 格式化
     *
     * @param xmlObject
     */
    public static void Xml(@Nullable Object xmlObject) {
        if (mDebuggable >= LEVEL_ERROR) {
            if (xmlObject != null) {
                Logger.xml(xmlObject.toString());
            } else {
                LogUtils.e(true, "xml()参数 xmlObject 参数为null，请检查！");
            }
        }
    }

}
