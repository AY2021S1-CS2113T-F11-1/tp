package diet.dietmanager.command;

import storage.diet.Storage;

import java.util.logging.Logger;

public interface Command {
    Logger logger = Logger.getLogger("java.diet.dietmanager.command");
    public void execute(String input, Storage storage);
}
