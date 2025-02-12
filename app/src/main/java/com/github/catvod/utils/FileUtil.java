package com.github.catvod.utils;

import com.github.catvod.spider.Init;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileUtil {

    public static File getExternalCacheDir() {
        return Init.context().getExternalCacheDir();
    }

    public static File getCacheDir() {
        return Init.context().getCacheDir();
    }

    public static File getCacheFile(String fileName) {
        return getExternalCacheDir().canWrite() ? new File(getExternalCacheDir(), fileName) : new File(getCacheDir(), fileName);
    }

    public static void write(File file, String data) {
        write(file, data.getBytes());
    }

    public static void write(File file, byte[] data) {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data);
            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String read(File file) {
        try {
            return read(new FileInputStream(file));
        } catch (Exception e) {
            return "";
        }
    }

    public static String read(InputStream is) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            String text;
            while ((text = br.readLine()) != null) sb.append(text).append("\n");
            br.close();
            return Utils.substring(sb.toString());
        } catch (Exception e) {
            return "";
        }
    }
}
