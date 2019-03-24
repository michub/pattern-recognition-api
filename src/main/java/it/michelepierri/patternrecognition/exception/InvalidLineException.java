package it.michelepierri.patternrecognition.exception;

public class InvalidLineException extends Exception {

	public InvalidLineException(final String message) {
        super(message);
    }

	public InvalidLineException(InvalidLineException e) {
		super(e);
	}

}
