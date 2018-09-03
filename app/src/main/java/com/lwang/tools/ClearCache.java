package com.lwang.tools;

import java.io.File;
import java.text.DecimalFormat;

/**
 * @author lwang
 * @date 2018/9/3
 * @description 清理缓存
 */

public class ClearCache {

    /**
     * 获取目标路径缓存大小
     *
     * @param path
     * @return
     */
    public static long getCacheSize(String path) {
        File file = new File(path);
        if (file == null || file.isFile()) return 0;
        File[] files = file.listFiles();
        if (files == null || files.length == 0) return 0;
        long size = 0;
        for (File f : files) {
            if (f.isFile()) {
                size += f.length();
            }
        }
        return size;
    }

    /**
     * 将对应的大小转化为文字，如10M
     *
     * @param size
     * @return
     */
    public static String fromatSize(long size) {
        DecimalFormat formater = new DecimalFormat("####.00");
        if (size < 1024) {
            return size + "B";
        } else if (size < 1024 * 1024) {
            float kbsize = size / 1024f;
            return formater.format(kbsize) + "K";
        } else if (size < 1024 * 1024 * 1024) {
            float mbsize = size / 1024f / 1024f;
            return formater.format(mbsize) + "M";
        } else if (size < 1024 * 1024 * 1024 * 1024) {
            float gbsize = size / 1024f / 1024f / 1024f;
            return formater.format(gbsize) + "G";
        } else {
            return "size: error";
        }
    }

    /**
     * 删除对应路径下所有的文件
     *
     * @param path
     * @return
     */
    public static boolean delAllFile(String path) {
        boolean flag = false;
        File file = new File(path);
        if (!file.exists()) {
            return flag;
        }
        if (!file.isDirectory()) {
            return flag;
        }
        String[] tempList = file.list();
        File temp = null;
        for (int i = 0; i < tempList.length; i++) {
            if (path.endsWith(File.separator)) {
                temp = new File(path + tempList[i]);
            } else {
                temp = new File(path + File.separator + tempList[i]);
            }
            if (temp.isFile()) {
                temp.delete();
            }
            if (temp.isDirectory()) {
                delAllFile(path + "/" + tempList[i]);
                flag = true;
            }
        }
        return flag;
    }

}
