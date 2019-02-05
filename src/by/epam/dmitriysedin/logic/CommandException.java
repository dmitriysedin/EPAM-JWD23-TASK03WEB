package by.epam.dmitriysedin.logic;

import by.epam.dmitriysedin.exception.ProjectException;

public class CommandException extends ProjectException {

	private static final long serialVersionUID = 1L;

	public CommandException(String message, Exception e) {
		super(message, e);

	}

	public CommandException(String message) {
		super(message);

	}

}
