package com.example;

import net.pwall.json.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Read
{   
    public static void ReadJson(){
        String jdata = "";
        try {
            File jsonF = new File("C:/Users/James Bushek/Documents/Class Work/OSPD/Project1/ssg_porject/resources");
            Scanner fReader = new Scanner(jsonF);
            while (fReader.hasNextLine()) {
              jdata = fReader.nextLine();
            }
            fReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
        
        Object jRaw = JSONSimple.parse(jdata);
        System.out.println(jRaw);
    }
}
