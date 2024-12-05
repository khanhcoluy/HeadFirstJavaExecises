import java.util.ArrayList;

public class Startup {
    private ArrayList<String> locationCells;

    public void setLocationCells(ArrayList<String> locs) {
        locationCells = locs;
    }

    public String checkYourself(String userInput) {
        String result = "miss";
        int index = locationCells.indexOf(userInput);

        if (index != -1) {
            locationCells.remove(userInput);
            if (locationCells.isEmpty()) {
                result = "kill";
            } else {
                result = "hit";
            }
        }

        System.out.println(result);
        return result;
    } // end method
} // close class
