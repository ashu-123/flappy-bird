package codeKamp;

import java.util.Random;

public class RandomNumberGenerator {
    private static Random random;

    public static int next(int upperLimit)
    {
        if(random==null)
        {
            random = new Random();
        }
        return random.nextInt(upperLimit);
    }

}
