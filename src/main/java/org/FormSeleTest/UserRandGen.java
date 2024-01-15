package org.FormSeleTest;
import java.util.Random;

public class UserRandGen {

    public static int genderAssigner(){
        Random rand = new Random();

        return rand.nextInt(3);

    }

    public static int educationCalc(){
        Random rand = new Random();

        return rand.nextInt(3);
    }

    public static int dayAssigner(){
        Random rand = new Random();

        return rand.nextInt(1, 28);
    }

    public static int monthAssigner(){
        Random rand = new Random();

        return rand.nextInt(1, 13);
    }

    public static int yearAssigner(){
        Random rand = new Random();

        return rand.nextInt(1980, 2005);
    }

    public static int expAssigner(){
        Random rand = new Random();

        return rand.nextInt(11);
    }

}
