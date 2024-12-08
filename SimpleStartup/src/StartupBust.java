import java.util.ArrayList;

public class StartupBust {
    private GameHelper gameHelper = new GameHelper();
    private ArrayList<Startup> startups = new ArrayList<>();
    private int numOfGuesses = 0;

    public void setupGame() {
        // create startups
        Startup firstStartup = new Startup();
        firstStartup.setName("apple");
        Startup secondStartup = new Startup();
        secondStartup.setName("microsoft");
        Startup thirdStarup = new Startup();
        thirdStarup.setName("facebook");

        startups.add(firstStartup);
        startups.add(secondStartup);
        startups.add(thirdStarup);

        System.out.println("Your goal is to sink three Startups.");
        System.out.println("apple, microsoft, facebook");
        System.out.println("Try to sink them all in the fewest number of guesses");

        // get locations for startup from game helper class, assign it
        for (Startup startup : startups) {
            ArrayList<String> newLocation = gameHelper.placeStartup(3);
            startup.setLocationCells(newLocation);
        }
    }

    public void startPlaying() {
        // check if startups is not empty then check user guess
        // loop through startup and invoke checkUserGuess method
        while (!startups.isEmpty()) {
            String userGuess = gameHelper.getUserInput("Enter a guess");
            checkUserGuess(userGuess);
        }

        finishGame();
    }

    public void checkUserGuess(String userGuess) {
        numOfGuesses++;

        String result = "miss";
        // invoke checkYourself method => return result
        for (Startup startup : startups) {
             result = startup.checkYourself(userGuess);

            if (result.equals("hit")) {
                break;
            }
            if (result.equals("kill")) {
                startups.remove(startup);
                break;
            }
        }

        System.out.println(result);
    }

    public void finishGame() {
        // print out the result and rate it
        if (numOfGuesses <= 18) {
            System.out.println("Great! You made it look easy! " + numOfGuesses + " is the number of your guesses.");
        } else {
            System.out.println("Not the best result but still impressed! You took " + numOfGuesses + " guesses.");
        }
    }
}
