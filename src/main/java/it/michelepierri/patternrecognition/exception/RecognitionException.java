package it.michelepierri.patternrecognition.exception;

public abstract class RecognitionException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;

	public RecognitionException(String msg) {
		this.message = msg;
	}

	public String getMessage() {
		return message;
	}
}
