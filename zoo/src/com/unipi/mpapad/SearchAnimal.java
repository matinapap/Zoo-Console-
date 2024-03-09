package com.unipi.mpapad;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SearchAnimal extends PrintAnimals
{

    boolean searchForCheckAnimalID(int animalId, String filename) {      //για την επεξεργασια των ζωων
        boolean found = false;
        try (BufferedReader animalFileBr = new BufferedReader(new FileReader(filename))) {
            String line;
            String[] animalInfo;
            while ((line = animalFileBr.readLine()) != null) {
                animalInfo = line.split(",");
                if (Integer.parseInt(animalInfo[5]) == animalId) {
                    //επιστρεφει true αν υπάρχει true
                    found = true;

                }
            }
        } catch (IOException e) {
            found = false;
        }
        return found;
    }

    public void SearchToPrintCode(String findCode,String filename) {
        try
        {
            boolean found =false;
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReaderAnimalInfo = new BufferedReader(fileReader);
            String line;
            String[] data= new String[0];
            while ((line = bufferedReaderAnimalInfo.readLine()) != null) {
                //χωριζουμε το "," για να μπορει να γινει η αναζητηση
                data = line.split(",");
                //αναζητηση data[5] πεδιου οπου αντιστοιχει στο animalCode
                if (data[5].equals(findCode))
                {
                    found = true;
                    break;
                }
            }
            fileReader.close();
            bufferedReaderAnimalInfo.close();
            if (found)
            {
                System.out.println("|   NAME   | WEIGHT |    ORDER    |   CLASS   | AGE | CODE  | WILD |");
                System.out.println(
                        "| "+padRight(data[0],9)+ //"n:αριθμός" ο χωρος που θα αφήσει για κενό
                                "| "+padRight(data[1],7)+
                                "| "+padRight(data[2],12)+
                                "| "+padRight(data[3],10)+
                                "| "+padRight(data[4],4) +
                                "| "+padRight(data[5],6) +
                                "| "+padRight(data[6],5) + "|");
            }
            else
            {
                System.out.println("Sorry, the animal that you've searched doesn't exist in our zoo...");
            }
        } catch (IOException e)
        {
            System.out.println("Error : file corrupted");
        }
    }

    public void SearchToPrintName(String findName,String filename) {
        try
        {
            boolean found =false;
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReaderAnimalInfo = new BufferedReader(fileReader);
            String line;
            String[] data= new String[0];
            while ((line = bufferedReaderAnimalInfo.readLine()) != null) {
                //χωριζουμε το "," για να μπορει να γινει η αναζητηση
                data = line.split(",");
                //αναζητηση data[0] πεδιου οπου αντιστοιχει στο animalName
                if (data[0].equals(findName))
                {
                    found = true;
                    break;
                }
            }
            fileReader.close();
            bufferedReaderAnimalInfo.close();
            if (found)
            {
                System.out.println("|   NAME   | WEIGHT |    ORDER    |   CLASS   | AGE | CODE  | WILD |");
                System.out.println(
                        "| "+padRight(data[0],9)+ //"n:αριθμός" ο χωρος που θα αφήσει για κενό
                                "| "+padRight(data[1],7)+
                                "| "+padRight(data[2],12)+
                                "| "+padRight(data[3],10)+
                                "| "+padRight(data[4],4) +
                                "| "+padRight(data[5],6) +
                                "| "+padRight(data[6],5) + "|");
            }
            else
            {
                System.out.println("Sorry, the animal that you've searched doesn't exist in our zoo...");
            }
        } catch (IOException e)
        {
            System.out.println("Error : file corrupted");
        }
    }
}
