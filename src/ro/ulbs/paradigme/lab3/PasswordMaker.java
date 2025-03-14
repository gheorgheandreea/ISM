package ro.ulbs.paradigme.lab3;

import java.util.Random;

public class PasswordMaker {
    private static final int MAGIC_NUMBER = new Random().nextInt(6) + 5; ;
    private final String magicString;
    private final String name;
    public PasswordMaker(String name) {
        this.name = name;
        this.magicString = StringRandomizer.getRandomString(20);
    }

        public String getPassword () {
            Random random = new Random();
            String s1 = StringRandomizer.getRandomString(MAGIC_NUMBER);
            StringBuilder s2 = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                int index = random.nextInt(magicString.length());
                s2.append(magicString.charAt(index));
            }
            String s3 = String.valueOf(name.length());
            int s4 = random.nextInt(51);
            return s1 + s2 + s3 + s4;
        }
    }