package by.epam.dmitriysedin.exception;

public class ProjectException extends Exception {

	private static final long serialVersionUID = 1L;
	private Exception hiddenException;

	public ProjectException() {
		super();

	}

	public ProjectException(String message, Exception e) {
		super(message, e);
		hiddenException = e;

	}

	public ProjectException(String message) {
		super(message);

	}

	public ProjectException(Throwable cause) {
		super(cause);

	}

	public Exception getHiddenException() {
		return hiddenException;
	}

}
