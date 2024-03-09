package com.unipi.mpapad;
import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner scanner ;
        //αρχικοποίηση αντικειμένων
        Animals animalsObjects= new Animals();
        Animals callClass = new Animals();
        SearchAnimal printInfo = new SearchAnimal();
        PrintAnimals print= new PrintAnimals();
        DeleteAnimal AnimalDel= new DeleteAnimal();
        Integer answer=0;
        do {
            try {
                System.out.println("1.Show animals");
                System.out.println("2.Add new animal");
                System.out.println("3.Search animal by name");
                System.out.println("4.Search animal by code");
                System.out.println("5.Process animal by code");
                System.out.println("6.Delete animal by code");
                System.out.println("7.Exit");
                System.out.println("Please give me a number:");
                scanner = new Scanner(System.in);
                answer = Integer.valueOf(scanner.nextLine());
                if (answer.equals(1))
                {
                    print.ShowAnimals();
                } else if (answer.equals(2))
                {

                  String MainAnimalName = animalsObjects.SetAnimalsName();
                  String MainAnimalCode = animalsObjects.SetAnimalsID();
                  boolean found=false;
                   do           //ελέγχουμε αν υπάρχει ήδη ο κωδικός
                   {
                       if (printInfo.searchForCheckAnimalID(Integer.parseInt(MainAnimalCode), "AnimalSave.txt")==true) {
                           System.out.println("We are sorry! This code already exists...");
                           System.out.println("Try another code:");
                           scanner = new Scanner(System.in);
                           MainAnimalCode = scanner.nextLine();
                       }else found=true;
                   }while(found==false);
                    String MainAnimalAge = animalsObjects.SetAnimalsAge();
                    String MainAnimalClass = animalsObjects.SetAnimalsClass();
                    String MainAnimalWildAnimals = animalsObjects.SetWildAnimals();
                    String MainAnimalOrder = animalsObjects.SetAnimalsOrder();
                    String MainAnimalWeight = animalsObjects.SetAnimalsWeight();
                    callClass.AnimalSave(MainAnimalName, MainAnimalCode, MainAnimalAge, MainAnimalClass, MainAnimalWildAnimals, MainAnimalOrder, MainAnimalWeight);
                }
                else if (answer.equals(3))
                {
                    System.out.println("Give the name of the animal you want to search:");
                    Scanner scanner1 = new Scanner(System.in);
                    String findName = scanner1.nextLine();
                    printInfo.SearchToPrintName(findName,"AnimalSave.txt");
                }
                else if (answer.equals(4))
                {
                    System.out.println("Give the code of the animal you want to search:");
                    Scanner scanner1 = new Scanner(System.in);
                    String findCode = scanner1.nextLine();
                    printInfo.SearchToPrintCode(findCode,"AnimalSave.txt");
                }
                else if (answer.equals(5))
                {
                    System.out.println("Give the code of the animal you want to edit:");
                    Scanner scanner1 = new Scanner(System.in);
                    String editAnimal = scanner1.nextLine();
                    if(printInfo.searchForCheckAnimalID(Integer.parseInt(editAnimal), "AnimalSave.txt")==true)
                    {
                        printInfo.SearchToPrintCode(editAnimal,"AnimalSave.txt"); //δείχνουμε το ζώο με τον αντίστοιχο κωδικό
                        AnimalDel.deleteAnimalInfo(editAnimal, "AnimalSave.txt");   // το διαγράφουμε
                        System.out.println("Please enter again all the animal's characteristics:");     //ξαναγράφουμε τα στοιχεια του όπως θέλουμε
                        String MainAnimalName = animalsObjects.SetAnimalsName();
                        String MainAnimalCode = animalsObjects.SetAnimalsID();
                        String MainAnimalAge = animalsObjects.SetAnimalsAge();
                        String MainAnimalClass = animalsObjects.SetAnimalsClass();
                        String MainAnimalWildAnimals = animalsObjects.SetWildAnimals();
                        String MainAnimalOrder = animalsObjects.SetAnimalsOrder();
                        String MainAnimalWeight = animalsObjects.SetAnimalsWeight();
                        callClass.AnimalSave(MainAnimalName, MainAnimalCode, MainAnimalAge, MainAnimalClass, MainAnimalWildAnimals, MainAnimalOrder, MainAnimalWeight);
                    }else System.out.println("Sorry, there is no animal with this code "+editAnimal);
                }
                else if (answer.equals(6))
                {
                    System.out.println("Give the code of the animal you want to delete:");
                    Scanner scanner1 = new Scanner(System.in);
                    String deleteAnimal = scanner1.nextLine();
                    if(printInfo.searchForCheckAnimalID(Integer.parseInt(deleteAnimal), "AnimalSave.txt")==true) {
                        printInfo.SearchToPrintCode(deleteAnimal, "AnimalSave.txt");
                        AnimalDel.deleteAnimalInfo(deleteAnimal, "AnimalSave.txt");
                        System.out.println("The animals on the zoo are:");
                        print.ShowAnimals();
                    }else System.out.println("Sorry, there is no animal with code " +deleteAnimal);
                }
            } catch (Exception e)
            {
                System.out.println("Please choose 1 or 2 or 3 or 4 or 5 or 6 or 7!");
            }
        } while (!(answer.equals(7)));
        System.out.println("Program Ended");
    }
    }
