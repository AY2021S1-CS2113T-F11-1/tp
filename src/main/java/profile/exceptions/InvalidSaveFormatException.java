package profile.exceptions;

import static profile.components.Constants.MESSAGE_INVALID_SAVE_FORMAT;

/**
 * Represents exception when there is corruption in data save format.
 */
public class InvalidSaveFormatException extends SchwarzeneggerException {

    /**
     * Constructs InvalidSaveFormatException object inheriting abstract class SchwarzeneggerException.
     */
    public InvalidSaveFormatException() {
        super(MESSAGE_INVALID_SAVE_FORMAT);
    }

}