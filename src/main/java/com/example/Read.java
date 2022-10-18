package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Read
{   
    public static JSONArray ReadJson(){
        String jdata = "";
        try {
            File jsonF = new File("C:/Users/James Bushek/Documents/Class Work/OSPD/Project1/ssg_porject/resources/stock_transations-3.by.account.holder.json");
            Scanner fReader = new Scanner(jsonF);
            while (fReader.hasNextLine()) {
              jdata = jdata + fReader.nextLine();
            }
            fReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
          JSONParser parser = new JSONParser();
          JSONArray jArray;
        try {
            jArray = (JSONArray) parser.parse(jdata);
            return jArray;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static JSONArray ReadJsonPiece(String jdata){
        JSONParser parser = new JSONParser();
        JSONArray jArray;
        try {
            jArray = (JSONArray) parser.parse(jdata);
            return jArray;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
