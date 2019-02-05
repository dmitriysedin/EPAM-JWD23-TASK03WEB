package by.epam.dmitriysedin.logic.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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

public class NextPage implements ICommand {
	
	private static final Logger logger = LogManager.getLogger(NextPage.class);

	@Override
	public String execute(HttpServletRequest request) throws CommandException {

		int firstIndex = Integer.parseInt(request.getParameter(RequestParameterName.LAST_ROW));
		int lastIndex = firstIndex + FirstPage.rowsByPage;

		XMLParser parser = null;
		List<Object> menuList = null;
		XMLParserType parserType = XMLParserType.valueOf(request.getParameter(RequestParameterName.PARSER_NAME));
		String fileName = request.getParameter(RequestParameterName.FILE_NAME);

		try {
			parser = XMLParserFactory.getInstance().getParser(parserType);
			menuList = parser.parse(request.getParameter(RequestParameterName.FILE_NAME));

		} catch (XMLParserException e) {
			logger.warn("XMLParserException in FirstPage");
			throw new CommandException("Exception in NextPage", e);
		}

		request.setAttribute(RequestParameterName.PARSER_NAME, parserType);
		request.setAttribute(RequestParameterName.FILE_NAME, fileName);
		request.setAttribute(RequestParameterName.RESULT_LIST, menuList);
		request.setAttribute(RequestParameterName.FIRST_ROW, firstIndex);
		request.setAttribute(RequestParameterName.LAST_ROW, lastIndex);

		return JspPageName.USER_PAGE;
	}

}
