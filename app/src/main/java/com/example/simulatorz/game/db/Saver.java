package com.example.simulatorz.game.db;

import android.content.Context;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Saver {

    public static void saveObject(Context context, Object object, String filName) {
        FileOutputStream fos = null;
        try {
            fos = context.openFileOutput(filName, Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(object);
            Log.i("SAVER", "SAVE SUCCESS: " + filName);
        } catch(IOException e) {
            Log.i("SAVER", "SAVE FAILURE: " + filName + " : " + e.getMessage());
            e.printStackTrace();
        } finally{
            try{
                if(fos!=null) {
                    fos.close();
                }
            } catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    public static Object loadObject(Context context, String fileName) {
        FileInputStream fin = null;
        try {
            fin = context.openFileInput(fileName);
            ObjectInputStream ois = new ObjectInputStream(fin);
            Log.i("SAVER", "LOAD SUCCESS: " + fileName);
            return ois.readObject();
        } catch(Exception e) {
            Log.i("SAVER", "LOAD FAILURE: " + fileName + " : " + e.getMessage());
            e.printStackTrace();
            return null;
        } finally{
            try{
                if(fin!=null)
                    fin.close();
            } catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void deleteObject(Context context, String fileName) {
        context.deleteFile(fileName);
    }

}
