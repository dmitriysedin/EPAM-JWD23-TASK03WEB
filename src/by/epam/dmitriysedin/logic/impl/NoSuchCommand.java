package by.epam.dmitriysedin.logic.impl;

import javax.servlet.http.HttpServletRequest;

import by.epam.dmitriysedin.controller.JspPageName;
import by.epam.dmitriysedin.logic.CommandException;
import by.epam.dmitriysedin.logic.ICommand;

public class NoSuchCommand implements ICommand {
	
	@Override
	public String execute(HttpServletRequest request) throws CommandException {

		return JspPageName.ERROR_PAGE;
	}

}
