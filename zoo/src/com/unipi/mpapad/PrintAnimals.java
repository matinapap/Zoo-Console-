package com.unipi.mpapad;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PrintAnimals extends SaveAnimals
{
    public static String padRight(String s, int n)
    {
        return String.format("%-" + n + "s", s);
    }

    void ShowAnimals()
    {
        String s="AnimalSave.txt";
        try (BufferedReader bufferedReaderAnimalInfo = new BufferedReader(new FileReader("AnimalSave.txt"))) {
            String line ;
            String[] data;
            System.out.println("|   NAME   | WEIGHT |    ORDER    |   CLASS   | AGE | CODE  | WILD |");
            while ((line = bufferedReaderAnimalInfo.readLine()) != null) {
                data=line.split(",");
                if(!data[0].isEmpty()){
                    //βάζουμε στο data κάθε στοιχείο του ζώου και μετα στις κατάλληλες μεταβλητές ώστε να τα ξεχωρήσουμε
                    String animalName = data[0]; String animalCode= data[5]; String animalClass = data[3];
                    String animalWeight = data[1]; String animalAge = data[4];  String animalOrder = data[2];
                    String animalWild = data[6];
                    System.out.println(
                            "| "+padRight(animalName,9)+ //"n:αριθμός" ο χωρος που θα αφήσει για κενό
                            "| "+padRight(animalWeight,7)+
                            "| "+padRight(animalOrder,12)+
                            "| "+padRight(animalClass,10)+
                            "| "+padRight(animalAge,4) +
                            "| "+padRight(animalCode,6) +
                            "| "+padRight(animalWild,5) + "|");
                }
            }
        }catch (IOException e) {

            System.out.println("Error : file corrupted");
        }
    }
}
