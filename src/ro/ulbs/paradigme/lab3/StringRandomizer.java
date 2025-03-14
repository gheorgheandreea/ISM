package ro.ulbs.paradigme.lab3;

import java.security.SecureRandom;
import java.util.Random;

public class StringRandomizer {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static String getRandomString(int length) {
        Random random = new Random() ;
        String result = " ";
        for (int i = 0; i < length; i++) {
            int c = random.nextInt(CHARACTERS.length());
            result += CHARACTERS.charAt(c);
        }

        return result;

    }

}
