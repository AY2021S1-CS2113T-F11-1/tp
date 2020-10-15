package seedu.duke;

import diet.dietmanager.DietManager;
import diet.dietmanager.DietManagerUI;
import workout.workoutmanager.WorkoutManager;

import java.util.Scanner;

public class Duke {
    /**
     * Main entry-point for the java.duke.Duke application.
     */

    private final DietManagerUI dietManagerUI;
    private final DietManager dietManager;

    public Duke() {
        dietManagerUI = new DietManagerUI();
        dietManager = new DietManager();

    }

    public static void main(String[] args) {
        new Duke().run();
    }

    public void run() {
        System.out.println("Hi, this is the Schwarzenegger, "
                + "an app for your daily workout and diet recording.");

        execute();
    }

    public void execute() {
        String response = dietManagerUI.getInput();
        while (!response.equals("exit")) {
            if (response.equals("diet")) {
                dietManager.start();
            }
            response = dietManagerUI.getInput();
        }
        System.out.println("Bye, you have exited the Schwarzenegger.");
    }

    private static void wokroutTest() {
        WorkoutManager wm = new WorkoutManager();
        wm.start();
    }
}
