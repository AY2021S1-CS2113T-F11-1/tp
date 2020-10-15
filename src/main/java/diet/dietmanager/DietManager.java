package diet.dietmanager;

import diet.dietmanager.command.Command;
import storage.diet.Storage;


public class DietManager {

    private final CommandLib cl;
    private final DietManagerParser parser;
    private final DietManagerUI dietManagerUI;
    private final Storage storage;

    public DietManager() {
        storage = new Storage();
        cl = new CommandLib();
        cl.initDietManagerCL();
        parser = new DietManagerParser();
        dietManagerUI = new DietManagerUI();
    }

    public void start() {
        DietManagerUI.printOpening();
        String input = dietManagerUI.getInput();
        while (!input.equals("end")) {
            try {
                processCommand(input);
            } catch (ExitException e) {
                System.out.println(e.getMessage());
                break;
            }
            input = dietManagerUI.getInput();
        }
        System.out.println("you have exited Diet Manager.");
    }

    public void processCommand(String input) throws ExitException {
        String[] commParts = parser.parse(input.trim());
        assert !commParts[0].isEmpty();
        Command command = cl.get(commParts[0]);
        assert !commParts[1].isEmpty();
        command.execute(commParts[1], storage);
    }
}
