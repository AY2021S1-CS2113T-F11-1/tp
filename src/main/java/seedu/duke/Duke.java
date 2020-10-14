package seedu.duke;

import diet.dietmanager.DietManager;
import diet.dietmanager.DietManagerUI;
import profile.ProfileSession;

import static profile.components.Constants.SCANNER;

/**
 * The Schwarzenegger program implements an application that keeps track of the user's gym and diet record.
 */
public class Duke {

    /**
     * Main entry-point for the java.duke.Duke application.
     *
     * @param args Unused in Duke.
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


    /**
     * Runs Schwarzenegger.
     */
    private void run() {
        System.out.println("Which session do you want to enter?");
        String session = SCANNER.nextLine().toLowerCase();

        if (session.equals("profile")) {
            System.out.println("Entering Profile Session...");

            ProfileSession profileSession = new ProfileSession();

            while (!profileSession.hasExit) {
                profileSession.run();
            }
        }

        System.out.println("back");
    }
}
