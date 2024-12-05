import java.util.ArrayList;
import java.util.List;

public class SimpleStartupTestDrive {
    public static void main(String[] args) {
        Startup startup = new Startup();
        ArrayList<String> locations = new ArrayList<>(List.of("2", "3", "4"));
        startup.setLocationCells(locations);
        String userGuess = "1";

        String result = startup.checkYourself(userGuess);
        String testResult = "failed";
        if (result.equals("hit")) {
            testResult = "passed";
        }

        System.out.println(testResult);
    }
}
