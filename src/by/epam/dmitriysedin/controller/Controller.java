package by.epam.dmitriysedin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.dmitriysedin.model.dao.XMLParserFactory;
import by.epam.dmitriysedin.model.dao.XMLParserFactory.XMLParserType;
import by.epam.dmitriysedin.model.logic.Paginator;


@WebServlet("/ServletForParsers")
public class Controller extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final String fileName = "C:/Users/HP/eclipse-workspace/task03web/resources/restaurant_perl_menu.xml";
	
    public Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		List<Object> menuList = new ArrayList<>();
		
		int[] index = new Paginator().measureIndex(request);
		request.setAttribute("firstRow", index[0]);
		request.setAttribute("lastRow", index[1]);
		
		String parserType = request.getParameter("parser");
		
		XMLParserType type = XMLParserType.valueOf(parserType);
			
			try {
				menuList = XMLParserFactory.getInstance().getParser(type).parse(fileName);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		request.setAttribute("parser", parserType);
		request.setAttribute("menus", menuList);
		request.getRequestDispatcher("/WEB-INF/jsp/MenuTable.jsp").forward(request, response);
		
	}

}
