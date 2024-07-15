package com.example.table;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Add" , value = "/add")
public class AddServlet extends HttpServlet {

    private String message;

    public void init() {
        message = "Hello World!";
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<form action=\"ok\" method=\"get\">");
        out.println("Enter the employee name :    " + "<input type=\"text\" name=\"name\"> "+" <br>");
        out.println("Enter the employee salary :    " + "<input type=\"text\" name=\"salary\">"+" <br>");
        out.println("Enter the employee department :    " + "<input type=\"text\" name=\"department\">"+" <br>");

        out.println("<input type=\"submit\" value=\"ok\">");

        out.println("</form>");
        out.println("</body></html>");
    }
}
