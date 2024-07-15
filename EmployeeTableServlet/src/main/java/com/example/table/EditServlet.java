package com.example.table;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "edit" , value = "/edit")
public class EditServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        out.println("<form action=\"ok2?id="+id+"\"method=\"get\">");
        out.println("Enter the new employee name :    " + "<input type=\"text\" name=\"name\"> "+" <br>");
        out.println("Enter the new employee salary :    " + "<input type=\"text\" name=\"salary\">"+" <br>");
        out.println("Enter the new employee department :    " + "<input type=\"text\" name=\"department\">"+" <br>");
        out.println( "<button type=submit value="+id+" name=id>Edit</button>  ");
        out.println("</form>");

        out.println("</body></html>");
    }


}
