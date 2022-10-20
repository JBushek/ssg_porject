package com.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Write {
    public static void MakeFile(){
        try {
            File webFile = new File("C:\\Users\\James Bushek\\Documents\\Class Work\\OSPD\\Project1\\ssg_porject\\resources\\stock_transactions.txt");
            if (webFile.delete()) { 
                System.out.println("Deleted the file: " + webFile.getName());
              } else {
                System.out.println("No file to delete.");
              } 
            if (webFile.createNewFile()) {
              System.out.println("File created: " + webFile.getName());
            } else {
              System.out.println("File already exists.");
            }
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }

    public static void WriteHTML(String fullHTML){
        try {
            FileWriter myWriter = new FileWriter("C:/Users/James Bushek/Documents/Class Work/OSPD/Project1/ssg_porject/resources/stock_transactions.txt");
            myWriter.write(fullHTML);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }
}
