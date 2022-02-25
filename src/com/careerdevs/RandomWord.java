package com.careerdevs;
import java.util.Random;

public class RandomWord {

    public String[] playableWords = new String[]{
            "guessing", "these", "words",
            "is", "very", "easy"
    };
    public Random rand = new Random();

    public String getWord() {
        return playableWords[rand.nextInt(playableWords.length)];
    }


}
