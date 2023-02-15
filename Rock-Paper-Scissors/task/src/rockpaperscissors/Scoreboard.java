package rockpaperscissors;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Scoreboard {

    private String userName;
    private int rating;
//    private final String fileName = "C:\\JAVA\\Rock-Paper-Scissors\\Rock-Paper-Scissors\\task\\src\\rockpaperscissors\\rating.txt";
    private final String fileName = "rating.txt";
    private final File file = new File(fileName);

    public Scoreboard(String userName) {
        this.userName = userName;
        this.rating = readFileRating();
    }

    public int getRating() {
        return rating;
    }

    private int readFileRating() {
        int rating = 0;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                if (scanner.next().equals(userName)) {
                    rating = scanner.nextInt();
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void addRating(int rating) {
        this.rating = getRating() + rating;
    }

}
