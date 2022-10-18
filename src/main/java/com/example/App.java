package com.example;
import org.json.simple.JSONArray;

public class App 
{
    public String fullStatement;
    public String fullHTML;
    public static void main( String[] args )
    {
        int i = 0;
        JSONArray jArray = Read.ReadJson();
        //While(i<300){
            Sort1(jArray, i);
            i++;
        //};
    }

    public static void Sort1(JSONArray jArray, int loopNum){
        String transfer = "[" + String.valueOf(jArray.get(loopNum)) + "]";
        JSONArray indiArray = Read.ReadJsonPiece(transfer);
        System.out.println(indiArray.get(0,0));
    }

    public static void Some2(){
        
    }

    public static void Some3(){
        
    }

    public static void Some4(){
        
    }
}
