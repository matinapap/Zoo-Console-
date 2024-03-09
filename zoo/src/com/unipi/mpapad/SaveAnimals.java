package com.unipi.mpapad;
import java.io.*;

interface SAnimal {
     void AnimalSave(String name, String code, String max_age, String class_an, String wild_an, String order,String weight);
}
public class SaveAnimals implements SAnimal
{
    public void AnimalSave (String name, String code, String max_age, String class_an, String wild_an, String order,String weight)
    {
        String InfoSave;
        InfoSave = name+","+weight+","+order+","+class_an+","+max_age+","+code+","+wild_an+"\n";
        try
        {
            FileWriter fileWriter = new FileWriter("AnimalSave.txt",true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            //γραφουμε το string στο txt αρχειο μας
            bufferedWriter.write(InfoSave);
            //κλείνουμε το αρχείο
            bufferedWriter.close();
            fileWriter.close();
        }catch(IOException ex )
        {
            System.out.println("Error! File not found!");
        }
    }
}
