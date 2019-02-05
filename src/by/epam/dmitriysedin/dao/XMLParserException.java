package by.epam.dmitriysedin.dao;

import by.epam.dmitriysedin.exception.ProjectException;

public class XMLParserException extends ProjectException {

	private static final long serialVersionUID = 1L;

	public XMLParserException() {
		super();

	}

	public XMLParserException(String message, Exception e) {
		super(message, e);

	}

	public XMLParserException(String message) {
		super(message);

	}

	public XMLParserException(Throwable cause) {
		super(cause);

	}

}
