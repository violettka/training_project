package utils;

import java.util.Random;

public class GenerateRandomNumber {

    private static String randomNumber;

    public static String getRandomNumber() {
        return randomNumber;
    }

    public static String generateRandomNumber() {
        Random rand = new Random();
        randomNumber = String.valueOf(rand.nextInt());
        return randomNumber;
    }
}