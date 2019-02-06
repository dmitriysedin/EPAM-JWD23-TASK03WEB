package by.epam.dmitriysedin.controller;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.dmitriysedin.logic.CommandException;
import by.epam.dmitriysedin.logic.CommandHelper;
import by.epam.dmitriysedin.logic.ICommand;

@WebServlet("/ServletForParsers")
public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LogManager.getLogger(Controller.class);

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");

		String commandName = request.getParameter(RequestParameterName.COMMAND_NAME);

		ICommand command = CommandHelper.getInstance().getCommand(commandName);
		
		String page = null;
		try {
			page = command.execute(request);
		} catch (CommandException e) {
			page = JspPageName.ERROR_PAGE;
			logger.warn("CommandException in Controller");		
		} catch (Exception e) {
			page = JspPageName.ERROR_PAGE;
			logger.warn("Exception in Controller");
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		} else {
			errorMessageDirectlyFromResponse(response);
			logger.error("NPE in dispatcher");
		}
	}

	private void errorMessageDirectlyFromResponse(HttpServletResponse response) throws IOException {

		response.setContentType("text/html");
		response.getWriter().println("E R R O R");
	}
}
