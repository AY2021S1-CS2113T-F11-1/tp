package diet;


import diet.dietmanager.DietManagerUI;


import org.junit.jupiter.api.Test;

import java.time.DateTimeException;
import java.time.format.DateTimeParseException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;



public class DietTest {

    @Test
    void extractDate_dateCorrectFormat_returnsDateString() {
        String input = "/d 2020-11-11 /t lunch";
        DietManagerUI ui = new DietManagerUI();
        String dateString = ui.extractDate(input);
        assertEquals(dateString, "11-11-2020");
    }

    @Test
    void extract_dateWrongFormat_expectException() {
        String input = "/d 2020-22-22 /t lunch";
        DietManagerUI ui = new DietManagerUI();
        assertThrows(DateTimeParseException.class, () -> ui.extractDate(input));
    }

    @Test
    void extract_dateNoTag_expectException() {
        String input = "/d 2020-11-11";
        DietManagerUI ui = new DietManagerUI();
        assertThrows(IndexOutOfBoundsException.class, () -> ui.extractDate(input));
    }


}
