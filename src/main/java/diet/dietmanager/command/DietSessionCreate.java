package diet.dietmanager.command;

import diet.dietmanager.DietManagerUI;
import diet.dietsession.DietSession;
import storage.diet.Storage;
import workout.workoutmanager.WorkoutManagerUI;

import java.io.IOException;

public class DietSessionCreate implements Command {


    @Override
    public void execute(String input, Storage storage) {
        DietManagerUI ui = new DietManagerUI();

        try {
            DietSession ds = new DietSession(ui.extractMeal(input), ui.extractDate(input));
            ds.start();
        } catch (IOException e) {
            System.out.println("It seems like we ran into some problems saving your session...");
//        } catch (NullPointerException e) {
//            System.out.println("It seems like you have not recorded anything.");
//        }
        }
    }
}
