import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int numOfGuesses = 0;
        GameHelper helper = new GameHelper();

        Startup theStartup = new Startup();
        int randomNum = (int) (Math.random() * 5);

        ArrayList<String> locations = new ArrayList<>(List.of(String.valueOf(randomNum), String.valueOf(randomNum + 1), String.valueOf(randomNum + 2)));
        theStartup.setLocationCells(locations);
        boolean isAlive = true;

        while (isAlive) {
            String guess = helper.getUserInput("enter a number");
            String result = theStartup.checkYourself(guess);
            numOfGuesses++;
            if (result.equals("kill")) {
                isAlive = false;
                System.out.println("You took " + numOfGuesses + " guesses");
            } // close if
        }
    }
}