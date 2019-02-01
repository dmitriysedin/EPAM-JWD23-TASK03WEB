package by.epam.dmitriysedin.model.dao;

import java.util.List;

public interface XMLParser {
	
	List<Object> parse(String fileName) throws Exception;
}
