package by.epam.dmitriysedin.logic.impl;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.epam.dmitriysedin.controller.JspPageName;
import by.epam.dmitriysedin.controller.RequestParameterName;

import by.epam.dmitriysedin.logic.CommandException;
import by.epam.dmitriysedin.logic.ICommand;

public class PreviousPage implements ICommand {

	@Override
	public String execute(HttpServletRequest request) throws CommandException {
		
		HttpSession session = request.getSession();

		int lastIndex = Integer.parseInt(session.getAttribute(RequestParameterName.FIRST_ROW).toString());
		int firstIndex = lastIndex - FirstPage.rowsByPage;

		session.setAttribute(RequestParameterName.FIRST_ROW, firstIndex);
		session.setAttribute(RequestParameterName.LAST_ROW, lastIndex);

		return JspPageName.USER_PAGE;
	}

}
