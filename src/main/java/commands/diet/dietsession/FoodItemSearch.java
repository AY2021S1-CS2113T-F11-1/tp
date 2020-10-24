package commands.diet.dietsession;

import commands.Command;
import diet.dietsession.Food;
import logger.SchwarzeneggerLogger;
import storage.diet.DietStorage;
import ui.diet.dietsession.DietSessionUi;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FoodItemSearch extends Command {
    private static Logger logger = SchwarzeneggerLogger.getInstanceLogger();
    DietSessionUi ui = new DietSessionUi();

    /**
     * Overrides execute for search command to search food items.
     *
     * @param input user input for command
     * @param foodList arraylist that stored all the food items
     * @param storage storage for diet session
     */
    @Override
    public void execute(String input, ArrayList<Food> foodList, DietStorage storage) {
        try {
            ui.showToUser("Here are the search results: ");
            int numberOfResults = 0;
            for (Food food : foodList) {
                if (food.toString().contains(input.trim())) {
                    System.out.println("\t" + (++numberOfResults) + ". " + food.toString());
                }
            }
            if (numberOfResults == 0) {
                ui.showToUser("Sorry, there is nothing found in your food list.");
            }
            logger.log(Level.INFO, "Listed all searched foods in Diet Session");
        } catch (NullPointerException e) {
            ui.showToUser("Sorry, there is nothing in your food list.");
            logger.log(Level.WARNING, "No item in food list for search");
        }
    }
}