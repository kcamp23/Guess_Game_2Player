package com.careerdevs;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        System.out.println("\n \nWELCOME TO THE WORD GUESS GAME\n \n ");
        mainMenu();
    }

    public static void mainMenu() {
        System.out.println("____________________");
        System.out.println("      MAIN MENU");
        System.out.println("_____________________");
        //  System.out.println("What would you like to do?");
        System.out.println("1) Play Game");
        System.out.println("2) Read Rules");
        System.out.println("3) Exit Program");

        int userGuess = CLI.readInt("What would you like to do? \n ", 1, 3);

        if (userGuess == 1) {
            howManyPlayers();
        } else if (userGuess == 2) {
            readRules();
        } else if (userGuess == 3) {
            System.out.print("Thank you for playing, please come back again soon");
        }
        //System.out.print("Please try again:");
        //mainMenu();

    }

    public static void howManyPlayers() {
        System.out.println("1) Single Player ");
        System.out.println("2) Two Players ");
        System.out.println("3) Main Menu");
        int numPlayers = CLI.readInt("which option would you like to choose?", 1, 3);

        if (numPlayers == 1) {
            singlePlay();
        } else if (numPlayers == 2) {
            twoPlay();
        } else if (numPlayers == 3) {
            mainMenu();
        }
        // System.out.println("Please try your selection again:");

    }

    public static void singlePlay() {
        System.out.println(" A Random word has been choosen:");
        String word = new RandomWord().getWord();
        //System.out.print(word);
        playGame(word);

    }

    public static void twoPlay() {
        String word = CLI.readString("Player one please choose a word:\n");
        System.out.println("__________________________");
        System.out.println("__________________________");
        System.out.println("__________________________");
        System.out.println("__________________________");
        System.out.println("__________________________");
        System.out.println("__________________________");
        System.out.println("__________________________");
        System.out.println("__________________________");
        System.out.println("__________________________");
        System.out.println("__________________________");
        System.out.println("No PEEEEEEEEEEKING!!!!!!");
        System.out.println("It is now player 2's turn: ");

        playGame(word);
    }

    public static void playGame(CharSequence word) {
        int numOfWrongGuesses = 0;
        boolean iterated = false;
        String temp = "";
        String currentCorrect = "";
        ArrayList<String> alreadyChoosen = new ArrayList<>();


        //System.out.print(word);
        while (numOfWrongGuesses <= 10) {
            String wordGuess = CLI.readString("What would you like to guess?");

            for (int i = 0; i < alreadyChoosen.size(); i++) {
                while (alreadyChoosen.containsAll(Collections.singleton(wordGuess))) {
                    System.out.println("Sorry thats already been choosen, please try again:");
                    wordGuess = CLI.readString("What would you like to guess?");
                }
            }
            alreadyChoosen.add(wordGuess);
            for (int i = 0; i < word.length(); i++) {

                if (wordGuess.equals(Character.toString(word.charAt(i)))) {
                    // correct answer method
                    if (!iterated) {
                        temp += Character.toString(word.charAt(i));
                    } else {

                        currentCorrect = Character.toString(temp.charAt(i)).replace("-", wordGuess);
                        temp = temp.substring(0, i) + currentCorrect + temp.substring(i + 1, temp.length());

                    }
                } else {
                    if (!iterated) {
                        temp += "-";
                        //change to only count WRONG guesses

                    }
                    if (temp.equals(word)) {
                        System.out.println("YOU GUESSED CORRECTLY!!!!");
                        mainMenu();

                    }
                }
            }
            numOfWrongGuesses++;
            iterated = true;
            System.out.println(temp + "\n" + alreadyChoosen);
            System.out.println("You have made " + numOfWrongGuesses+"/10 guesses");
        }
        System.out.println(word + "  was your word");
        System.out.println("Better luck next time");
        mainMenu();
    }

    public static void readRules() {
        //system print all the rules
    }


    public static void endGame() {

    }
}


