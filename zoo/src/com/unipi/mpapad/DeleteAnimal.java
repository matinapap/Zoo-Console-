package com.unipi.mpapad;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class DeleteAnimal
{
    void deleteAnimalInfo(String setIdForDeleteAnimal,String filename) {
        try {
            //Δημιουργουμε ενα temporary αρχείο για να μπορέσουμε να βαλουμε μεσα τα στοιχεια που θα μείνουν
            FileReader fileAnimalReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileAnimalReader);
            FileWriter fileAnimalWriter = new FileWriter("TemporaryAnimal.tmp");
            BufferedWriter bufferedWriter = new BufferedWriter(fileAnimalWriter);
            String line;
            String[] data;
            //ελεγχος αν υπαρχει o κωδικός
            while ((line = bufferedReader.readLine()) != null) {
                data = line.split(",");
                if (!data[5].equals(setIdForDeleteAnimal)) {
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                }
            }
            //κλείσιμο αρχείων
            bufferedReader.close();
            fileAnimalReader.close();
            bufferedWriter.close();
            fileAnimalWriter.close();
            Path to = Paths.get(filename);
            //μεταφορά στοιχείων στο παλιό αρχείο
            Path from = Paths.get("TemporaryAnimal.tmp");
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
            File temporaryAnimalFile = new File("TemporaryAnimal.tmp");
            //διαγραφή temporary αρχείου
            temporaryAnimalFile.delete();
        }
        catch (IOException e) {
            System.out.println("Error : file corrupted");
        }
    }
}
