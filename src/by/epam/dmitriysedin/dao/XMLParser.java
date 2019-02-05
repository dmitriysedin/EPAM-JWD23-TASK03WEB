package by.epam.dmitriysedin.dao;

import java.util.List;

public interface XMLParser {

	List<Object> parse(String fileName) throws XMLParserException;
}
