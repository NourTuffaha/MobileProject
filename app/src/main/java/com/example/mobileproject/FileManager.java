package com.example.mobileproject;

import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.nio.file.Watchable;
import java.util.Scanner;


public class FileManager implements Serializable {
    static Watch [] watchArray = new Watch[10];


    public static void read() throws FileNotFoundException {
        File f = new File("C:\\Users\\noura\\Desktop\\Uni\\MobileProject\\app\\src\\main\\java\\com\\example\\mobileproject\\data.txt");
        Scanner sc = new Scanner(f);
        Watch watch = new Watch();

        for (int i = 0; sc.hasNextLine(); i++) {
            String line = sc.nextLine();
            String[] details = line.split(", ");
            String watch_id = details[0];
            String brand = details[1];
            String model = details[2];
            String gender = details[3];
            Double cost = Double.valueOf(details[4]);
            String aspect1 = details[5];
            String aspect2 = details[6];
            String aspect3 = details[7];

            watch.setWatch_id(watch_id);
            watch.setBrand(brand);
            watch.setModel(model);
            watch.setGender(gender);
            watch.setCost(cost);
            watch.setAspect1(aspect1);
            watch.setAspect2(aspect2);
            watch.setAspect3(aspect3);

            watchArray[i] = watch;
        }


    }


//    public void read(){
//        ObjectInputStream input;
//        String filename = "testFilemost.srl";
//
//        try {
//            input = new ObjectInputStream(new FileInputStream(new File(new File(getFilesDir(),"")+File.separator+filename)));
//            Watch myPersonObject = (Watch) input.readObject();
//            Log.v("serialization","Watch brand="+myPersonObject.getBrand());
//            input.close();
//        } catch (StreamCorruptedException e) {
//            e.printStackTrace();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
}
