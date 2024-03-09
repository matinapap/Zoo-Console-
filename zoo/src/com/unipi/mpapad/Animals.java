package com.unipi.mpapad;
import java.util.Scanner;

 class Animals extends SaveAnimals {
     String name, class_an, order;
     int max_age, code;
     float weight;
     boolean wild_an;

     public Animals() {
         code = 0;
         name = "0";
         weight = 0;
         order = "0";
         class_an = "0";
         max_age = -1;
         wild_an = false;
     }

     public String SetAnimalsID() {
         Scanner scanner = new Scanner(System.in);
         while (code < 100 || code > 999) {
             try {
                 System.out.println("Please give animal's code (min->100 max->999):");
                 String ID = scanner.nextLine();
                 code = Integer.parseInt(ID.trim());
                 if (code < 100 && code > 999) {
                     System.out.println("Attention! Please give a number between 100 and 999") ;
                 }
             } catch (NumberFormatException e) {
                 System.out.println("Attention! Please give an integer between 100 and 999");
             }

         }
         return String.valueOf(code);
     }

     public String SetAnimalsName() {
         Scanner scanner = new Scanner(System.in);
         System.out.println("Please give the animal's name. Use only lowercase(example: dog,cat,bear etc.):");
         boolean repeat = true;
         while (repeat) {
             name = scanner.nextLine();
             if (!name.matches("[a-z]+")) {
                 System.out.println("Attention! Use only lowercase(example: dog,cat,beat etc.)");
                 name = scanner.nextLine();
             } else {
                 repeat = false;
             }
         }
         return name;
     }

     public String SetAnimalsClass() {
         Boolean repeat = true;
         while (repeat) {
             System.out.println("Please give the class of the animal:\nFor Mammals type 1, for Birds type 2, for Reptiles press 3, for " +
                     "Amphibians type 4, for Fish type 5 and for Invertebrates type 6:");
             Scanner scanner = new Scanner(System.in);
             try {
                 switch (scanner.nextInt()) {
                     case 1:
                         class_an = "mammals";
                         repeat = false;
                         break;
                     case 2:
                         class_an = "birds";
                         repeat = false;
                         break;
                     case 3:
                         class_an = "reptiles";
                         repeat = false;
                         break;
                     case 4:
                         class_an = "amphibians";
                         repeat = false;
                         break;
                     case 5:
                         class_an = "fish";
                         repeat = false;
                         break;
                     case 6:
                         class_an = "invertebrates";
                         repeat = false;
                         break;
                     default:
                         System.out.println("Write only integers 1 or 2 or 3 or 4 or 5");
                 }
             } catch (Exception e) {
                 System.out.println("Attention! Write only integers 1 or 2 or 3 or 4 or 5");
             }
         }
         return String.valueOf(class_an);
     }

     public String SetAnimalsAge() {
         Scanner scanner = new Scanner(System.in);
         try {
             while (max_age <= 0) {
                 System.out.println("Please give me average max animal's age in years:");
                 String Age = scanner.nextLine();
                 max_age = Integer.parseInt(Age.trim());
                 if (max_age <= 0) {
                     System.out.println("Attention! Animals can't have zero or negative age!");
                 }
             }
         } catch (Exception e) {
             System.out.println("Attention! You typed wrong number!");
         }
         return String.valueOf(max_age);
     }

     public String SetWildAnimals() {
         String answer = "";
         Scanner scanner = new Scanner(System.in);
         while (!answer.equals("yes") && !answer.equals("no")) {
             System.out.println("Please answer if the animal is a wild animal ONLY with yes or no:");
             answer = scanner.nextLine();
             if (answer.equals("yes")) {
                 wild_an = true;
                 break;
             } else if (answer.equals("no")) {
                 wild_an = false;
                 break;
             } else {
                 System.out.println("Please answer ONLY with yes or no:");
             }
         }
         return String.valueOf(answer);
     }

     public String SetAnimalsOrder() {
         String answer = "";
         Scanner scanner = new Scanner(System.in);
         while (true) {
             System.out.println("Please answer if the order of the animal using only the numbers: 1 for carnivorous, 2 for herbivore and 3 for omnivorous");
             answer = scanner.nextLine();
             if (answer.equals("1") || answer.equals("2") || answer.equals("3")) {
                 if (answer.equals("1")) order = "carnivorous";
                 else if (answer.equals("2")) order = "herbivore";
                 else order = "omnivorous";
                 break;
             } else System.out.println("Attention! Something went wrong! Use only the numbers: 1, 2 or 3");
         }
         return order;
     }

     public String SetAnimalsWeight() {
         Scanner scanner = new Scanner(System.in);
         while (weight <= 0) {
             try {
                 System.out.println("Please give me the weight of the animal in kg");
                 String answer = scanner.nextLine();
                 weight = Float.parseFloat(answer.trim());
                 if (weight <= 0) System.out.println("Attention! Something went wrong! Don't use negative numbers.");
             } catch (Exception NumberFormatException) {
                 System.out.println("Attention! Something went wrong!");
             }
         }
         return String.valueOf(weight);
     }

 }


