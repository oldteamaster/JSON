package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    final static String PATH_FILE = "d:\\json.txt";
    public static void main(String[] args) {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH_FILE))){
            String line;
            line = bufferedReader.readLine();
            while((line = bufferedReader.readLine()) != null){
                String[] row = line.split(" ");
                Peaple person = new Peaple(row[0],Integer.parseInt(row[1]));
                String json = new GsonBuilder().setPrettyPrinting().create().toJson(person);
                System.out.println(json);
            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }

}
class Peaple{
    private String name;
    private int age;

    Peaple(String name,int age){
        this.name = name;
        this.age = age;
    }
}