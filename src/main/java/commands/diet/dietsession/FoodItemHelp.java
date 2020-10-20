package commands.diet.dietsession;

import commands.Command;
import diet.dietsession.Food;
import storage.diet.Storage;

import java.util.ArrayList;

import static ui.CommonUi.printHelpFormater;

public class FoodItemHelp extends Command {
    public void execute(String input, ArrayList<Food> foodList, Storage storage) {
        printHelpFormater("List", "list",
                "Show all food items");
        printHelpFormater("Add", "add food name /c calories",
                "Add a new food item");
        printHelpFormater("Delete", "delete x",
                "Delete the food item indexed at x");
        printHelpFormater("Clear", "clear",
                "Clear all food items");
        printHelpFormater("End", "end",
                "Go back to diet manager menu");
    }
}