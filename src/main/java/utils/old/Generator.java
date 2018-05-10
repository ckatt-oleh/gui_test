package utils.old;

import java.util.Random;

public class Generator {
    private int leftLimit = 97; // letter 'a'
    private int rightLimit = 122; // letter 'z'

    public String givenUsingPlainJava_whenGeneratingRandomStringBounded_thenCorrect(int targetStringLength) {
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();

        return generatedString;
    }
}