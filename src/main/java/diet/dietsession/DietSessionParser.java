package diet.dietsession;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DietSessionParser {
    public String[] parse(String comm) {
        if (comm.contains(" ")) {
            return comm.split(" ", 2);
        } else {
            return new String[]{comm, "filler"};
        }
    }

    public String processFoodName(String food) throws IndexOutOfBoundsException {
        String[] temp = food.trim().split("/c", 2);
        return temp[0];
    }

    public double processFoodCalories(String food) throws NumberFormatException {
        String[] temp = food.trim().split("/c", 2);
        return Double.parseDouble(temp[1]);
    }

    /**
     * Converts the date and time into a LocalDate object
     *
     * @param dateInput Date input string
     * @return LocalDate object
     */
    public LocalDate parseDate(String dateInput) {

        // formatters for dates with time
        DateTimeFormatter formatterA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatterB = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        DateTimeFormatter formatterC = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        LocalDate date = null;
        try {
            date = LocalDate.parse(dateInput, formatterA);
        } catch (DateTimeParseException e) {
            // puts the date and time through all available formatters
        }
        try {
            if (date == null) {
                date = LocalDate.parse(dateInput, formatterB);
            }
        } catch (DateTimeParseException e) {
            // puts the date and time through all available formatters
        }
        try {
            if (date == null) {
                date = LocalDate.parse(dateInput, formatterC);
            }
        } catch (DateTimeParseException e) {
            // puts the date and time through all available formatters
        }
        try {
            if (date == null) {
                // this uses default formatter of yyyy-MM-dd
                date = LocalDate.parse(dateInput);
            }
        } catch (DateTimeParseException e) {
            // puts the date and time through all available formatters
        }
        // returns null if all the available formatters could not be used
        return date;
    }
}
