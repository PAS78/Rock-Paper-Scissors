package rockpaperscissors;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Options {

    private static final Random RANDOM = new Random();

    private String[] options;

    public Options(String[] options) {
        if (options.length <= 1) {
            options = new String[3];
            options[0] = "rock";
            options[1] = "paper";
            options[2] = "scissors";
        }

        this.options = options;
    }

    public String getOption(int index) {
        return options[index];
    }

    public int getOptionIndex(String option) {
        for (int i = 0; i < options.length; i++) {
            if (Objects.equals(options[i], option)) return i;
        }
        return 0;
    }

    public int getLength() {
        return options.length;
    }

    public boolean contains(String option) {
        for (String s: options) {
            if (Objects.equals(s, option)) {
                return true;
            }
        }

        return false;
    }

    public String randomAnswer() {
        return String.valueOf(Arrays.stream(options).toList().get(RANDOM.nextInt(options.length)));
    }

}
