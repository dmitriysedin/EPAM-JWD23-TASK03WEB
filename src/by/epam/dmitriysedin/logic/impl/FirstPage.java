package by.epam.dmitriysedin.logic.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import by.epam.dmitriysedin.controller.JspPageName;
import by.epam.dmitriysedin.controller.RequestParameterName;
import by.epam.dmitriysedin.dao.XMLParser;
import by.epam.dmitriysedin.dao.XMLParserException;
import by.epam.dmitriysedin.dao.XMLParserFactory;
import by.epam.dmitriysedin.dao.XMLParserFactory.XMLParserType;

import by.epam.dmitriysedin.logic.CommandException;
import by.epam.dmitriysedin.logic.ICommand;

public class FirstPage implements ICommand {
	
	private static final Logger logger = LogManager.getLogger(FirstPage.class);

	public static final int rowsByPage = 5;

	@Override
	public String execute(HttpServletRequest request) throws CommandException {
		
		HttpSession session = request.getSession();

		int firstIndex = 0;
		int lastIndex = firstIndex + rowsByPage;

		XMLParser parser = null;
		List<Object> menuList = null;
		XMLParserType parserType = XMLParserType.valueOf(request.getParameter(RequestParameterName.COMMAND_NAME));

		try {
			parser = XMLParserFactory.getInstance().getParser(parserType);
			menuList = parser.parse(request.getParameter(RequestParameterName.FILE_NAME));
		} catch (XMLParserException e) {
			logger.warn("XMLParserException in FirstPage");
			throw new CommandException("Exception in FirstPage", e);
			
		}

		session.setAttribute(RequestParameterName.PARSER_NAME, parserType);
		session.setAttribute(RequestParameterName.RESULT_LIST, menuList);
		session.setAttribute(RequestParameterName.FIRST_ROW, firstIndex);
		session.setAttribute(RequestParameterName.LAST_ROW, lastIndex);

		return JspPageName.USER_PAGE;
	}

}
