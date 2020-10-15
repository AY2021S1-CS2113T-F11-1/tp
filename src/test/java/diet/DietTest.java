package diet;


import diet.dietmanager.DietManagerUI;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import diet.dietmanager.command.DietSessionWrong;
import diet.dietsession.Food;
import diet.dietsession.command.Command;
import diet.dietsession.command.FoodItemAdd;
import diet.dietsession.command.FoodItemDelete;
import diet.dietsession.command.FoodItemWrong;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import storage.diet.Storage;

import java.util.ArrayList;

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
    void extract_dateWrongFormat_expectsException() {
        String input = "/d 2020-22-22 /t lunch";
        DietManagerUI ui = new DietManagerUI();
        assertThrows(DateTimeParseException.class, () -> ui.extractDate(input));
    }

    @Test
    void extract_dateNoDate_returnsCurrentDate() {
        String input = "/d";
        DietManagerUI ui = new DietManagerUI();
        String dateString = ui.extractDate(input);
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String outputString =  dtf.format(now);
        assertEquals(dateString, outputString);
    }

    @Test
    void extractMeal_mealCorrectFormat_returnsMealString() {
        String input = "/d 2020-11-11 /t lunch";
        DietManagerUI ui = new DietManagerUI();
        String mealString = ui.extractMeal(input);
        assertEquals(mealString, "lunch");
    }

    @Test
    void extract_dateNoMeal_returnsUnspecified() {
        String input = "/d 2020-11-11 /t";
        DietManagerUI ui = new DietManagerUI();
        String mealString = ui.extractMeal(input);
        assertEquals(mealString, "unspecified");
    }

    @Test
    void toString_correctInput_returnsCorrectString() {
        Food fd = new Food("biscuit", 400.00);
        String output = fd.toString();
        assertEquals(output, "biscuit with calories: 400.0");
    }

    ArrayList<Food> foodList = new ArrayList<>();
    Storage storage = new Storage();

    @Test
    void testAdd_correctInput_returnsMoreFood() {
        Command command = new FoodItemAdd();
        command.execute("melon /c 500", foodList, storage);
        assertEquals(4, foodList.size());
    }

    @Test
    void testDelete_correctInput_returnsFewerFood() {
        Command command = new FoodItemDelete();
        command.execute("1", foodList, storage);
        assertEquals(2, foodList.size());
    }

    private final PrintStream standardOut = System.out;
    private static final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeAll
    public static void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    /*@Test
    void testAdd_noCalories_returnsWarning() {
        storage.add("melon", foodList);
        String warning = "Please specify your food info.";
        assertEquals(warning, outputStreamCaptor.toString().trim());
    }

    @Test
    void testAdd_wrongFormatForCalories_returnsWarning() {
        storage.add("melon /c no calories", foodList);
        String warning = "Please specify your food info.";
        assertEquals(warning, outputStreamCaptor.toString().trim());
    }

    @Test
    void testDelete_IndexTooLarge_returnsWarning() {
        storage.delete(Integer.toString((foodList.size() + 4)), foodList);
        String warning = "Sorry, the index is not found.";
        assertEquals(warning, outputStreamCaptor.toString().trim());
    }

    @Test
    void testDelete_WrongFormatForIndex_returnsWarning() {
        storage.delete("a", foodList);
        String warning = "Sorry, the index is not found.";
        assertEquals(warning, outputStreamCaptor.toString().trim());
    }*/

    @Test
    void processCommandForDietSession_WrongCommand_returnsWarning() {
        Command command = new FoodItemWrong();
        command.execute("hahaha", foodList, null);
        String warning = "Sorry, I do not get what you are saying.";
        assertEquals(warning, outputStreamCaptor.toString().trim());

    }

    @Test
    void processCommandForDietManager_WrongCommand_returnsWarning() {
        diet.dietmanager.command.Command command = new DietSessionWrong();
        command.execute("hahaha", null);
        String warning = "Sorry, I do not get what you are saying.";
        assertEquals(warning, outputStreamCaptor.toString().trim());
    }
}