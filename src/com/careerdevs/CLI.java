package com.careerdevs;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class CLI {
    private static  Scanner scanner  = new Scanner(System.in);

    public static String readString (String question ) {
        while (true) {
            System.out.print(question);
            String inputString = scanner.nextLine();

            if (!inputString.trim().equals("")) {
                return inputString;
            }

            System.out.print(question);
            return scanner.nextLine();
        }
    }

    public static int readInt (String question, int min, int max){
        try {
            System.out.print(question);
            System.out.print("Number( " + min + "- " + max + ")");
            int temp = scanner.nextInt();
            scanner.nextLine();

            if (temp >= min && temp <= max){
                return temp;
            }
            System.out.println("Number outside of the valid range, Please try again");
            return readInt(question, min,max);

        }catch(InputMismatchException e){
            System.out.print("Must enter a valid integer, please try again");
            scanner.nextLine();
            return readInt(question,min,max);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.print("Must enter a valid selection, please try again");
            scanner.nextLine();
            return readInt(question,min,max);
        }


    }

    public static boolean  yesOrNo (String question){
        while(true){
            System.out.print("\n" + question + "\n yes or no:");
            String readInputString = scanner.nextLine();
            char finalInput = readInputString.toLowerCase(Locale.ROOT).trim().charAt(0);

            if( finalInput == 'y'){
                return true;
            }else if ( finalInput == 'n'){
                return false;
            }
            System.out.print("Input must be Y or N");
        }

    }

}



