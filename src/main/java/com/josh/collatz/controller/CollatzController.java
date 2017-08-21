package com.josh.collatz.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.josh.collatz.model.Collatz;
import com.josh.collatz.model.CollatzWrapper;

/**
 * Servlet implementation class CollatzController
 */
@Controller
public class CollatzController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ApplicationContext context;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CollatzController() {
        super();
		context = new ClassPathXmlApplicationContext("annotation/collatz.xml");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @RequestMapping(value="doGet.collatz", method=RequestMethod.GET)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		String input = request.getParameter("number");
    		long num = Long.parseLong(input);
    		Collatz collatz = (Collatz) context.getBean("Collatz");
    		CollatzWrapper cw = collatz.calculateCollatz(num);
    		request.setAttribute("cw", cw);
    		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
    		rd.forward(request, response);
//    		response.sendRedirect("index.jsp");
    		
//    		response.setContentType("text/html");
//    		PrintWriter writer = response.getWriter();
//    		writer.println(num);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
