package by.epam.dmitriysedin.dao;

import by.epam.dmitriysedin.dao.impl.DomXMLParser;
import by.epam.dmitriysedin.dao.impl.SaxXMLParser;
import by.epam.dmitriysedin.dao.impl.StaxXMLParser;

public class XMLParserFactory {

	private final static XMLParserFactory instance = new XMLParserFactory();

	public static XMLParserFactory getInstance() {

		return instance;
	}

	public XMLParser getParser(XMLParserType type) throws XMLParserException {

		XMLParser parser = null;

		switch (type) {
		case SAX:
			parser = SaxXMLParser.getInstance();
			break;

		case STAX:
			parser = StaxXMLParser.getInstance();
			break;

		case DOM:
			parser = DomXMLParser.getInstance();
			break;

		default:
			throw new XMLParserException("No such Parser");
			
		}

		return parser;
	}

	public enum XMLParserType {

		SAX, STAX, DOM;
	}

}
