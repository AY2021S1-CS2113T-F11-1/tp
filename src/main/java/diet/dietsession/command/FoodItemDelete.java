package diet.dietsession.command;

import diet.dietsession.Food;
import storage.diet.Storage;

import java.util.ArrayList;

public class FoodItemDelete implements Command {

    @Override
    public void execute(String input, ArrayList<Food> foodList, Storage storage) {
        try {
            assert !input.isEmpty();
            int index = Integer.parseInt(input);
            Food temp = foodList.get(index - 1);
            System.out.println("Oh no! You have deleted " + temp.toString());
            foodList.remove(temp);
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Sorry! It seems like you've entered an invalid number or input!");
        }
    }
}
