package commands.profile;

import commands.Command;
import commands.CommandResult;
import exceptions.profile.RedundantParamException;
import logger.SchwarzeneggerLogger;
import storage.profile.ProfileStorage;

import java.util.logging.Level;
import java.util.logging.Logger;

import static profile.Constants.ADD_PROFILE_FORMAT;
import static profile.Constants.COMMAND_WORD_ADD;
import static profile.Constants.COMMAND_WORD_DELETE;
import static profile.Constants.COMMAND_WORD_EDIT;
import static profile.Constants.COMMAND_WORD_HELP;
import static profile.Constants.COMMAND_WORD_VIEW;
import static profile.Constants.EDIT_PROFILE_FORMAT;
import static ui.CommonUi.helpFormatter;

public class HelpProfile extends Command {
    private static Logger logger = SchwarzeneggerLogger.getInstanceLogger();

    /**
     * Constructs HelpProfile object inheriting abstract class Command.
     *
     * @param commandArgs Command arguments from user's input.
     * @throws RedundantParamException If parameters are provided to Help Command.
     */
    public HelpProfile(String commandArgs) throws RedundantParamException {
        if (!commandArgs.isEmpty()) {
            throw new RedundantParamException(COMMAND_WORD_HELP);
        }
    }

    /**
     * Overrides execute method of class Command to execute help command requested by user's input.
     *
     * @param storage Profile Storage to load and save data.
     * @return Result of command execution.
     */
    @Override
    public CommandResult execute(ProfileStorage storage) {
        logger.log(Level.INFO, "executing Help Command");

        StringBuilder helpMessage = new StringBuilder();
        helpMessage.append(helpFormatter(COMMAND_WORD_ADD, ADD_PROFILE_FORMAT, "Add your new profile"));
        helpMessage.append(helpFormatter(COMMAND_WORD_VIEW, COMMAND_WORD_VIEW, "View your profile"));
        helpMessage.append(helpFormatter(COMMAND_WORD_EDIT, EDIT_PROFILE_FORMAT, "Edit your existing profile. "
                + "You may edit only 1 field or all fields"));
        helpMessage.append(helpFormatter(COMMAND_WORD_DELETE, COMMAND_WORD_DELETE, "Delete your existing profile"));

        return new CommandResult(helpMessage.toString().trim());
    }
}
