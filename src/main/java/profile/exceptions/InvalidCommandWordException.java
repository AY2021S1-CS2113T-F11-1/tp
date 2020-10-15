package profile.exceptions;

import static profile.components.Constants.MESSAGE_INVALID_COMMAND_WORD;

/**
 * Represents exception when command word is invalid.
 */
public class InvalidCommandWordException extends SchwarzeneggerException {

    /**
     * Constructs InvalidCommandException object inheriting abstract class SchwarzeneggerException.
     */
    public InvalidCommandWordException() {
        super(MESSAGE_INVALID_COMMAND_WORD);
    }
}
