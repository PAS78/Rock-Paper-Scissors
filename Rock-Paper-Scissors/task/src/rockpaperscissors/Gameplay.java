package rockpaperscissors;

import java.util.Objects;
import java.util.Scanner;

public class Gameplay {

    private String optionRandom;
    private Scoreboard scoreboard;
    private Options options;

    public Gameplay() {
        startGame();
    }

    private void startGame() {
        System.out.print("Enter your name: ");
        String name = input();
        System.out.printf("Hello, %s\n", name);

        scoreboard = new Scoreboard(name);

        options = new Options(input().split(","));

        System.out.println("Okay, let's start");

        runGame();
    }

    private void runGame() {
        optionRandom = options.randomAnswer();
        checkInput(input());
    }

    private void checkInput(String userOption) {

        if (Objects.equals(userOption, "!exit")) {
            System.out.print("Bye!");
        } else if (Objects.equals(userOption, "!rating")) {
            System.out.printf("Your rating: %d\n", scoreboard.getRating());
            runGame();
        } else if (!options.contains(userOption)) {
            System.out.println("Invalid input");
            runGame();
        } else {
            checkWin(userOption);
        }

    }

    private void checkWin(String userOption) {

        boolean winUser = false;

        if (Objects.equals(optionRandom, userOption)) {
            System.out.printf("There is a draw (%s)", optionRandom);
            scoreboard.addRating(50);
        } else {
            int count = 0;
            int position = options.getOptionIndex(optionRandom) + 1;
            while (count < options.getLength() / 2) {

                if (position >= options.getLength()) {
                    position = 0;
                }

                if (Objects.equals(userOption, options.getOption(position))) {
                    winUser = true;
                    break;
                } else {
                    count++;
                    position++;
                }
            }

            if (winUser) {
                System.out.printf("Well done. The computer chose %s and failed", optionRandom);
                scoreboard.addRating(100);
            } else {
                System.out.printf("Sorry, but the computer chose %s", optionRandom);
            }
        }

        System.out.println();
        runGame();

    }

    private String input() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
