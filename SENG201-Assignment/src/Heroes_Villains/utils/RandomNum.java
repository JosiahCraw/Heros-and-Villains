package Heroes_Villains.utils;

import java.util.Random;

public class RandomNum {

    public static int getNum(int bound) {
        int output;
        Random number = new Random();
        output = number.nextInt(bound);
        return output;
    }
}
