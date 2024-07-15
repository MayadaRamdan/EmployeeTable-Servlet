package com.example.table;

import java.io.*;
import java.sql.SQLException;
import java.util.List;

import com.example.table.entity.Customer;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/list-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    CustomerRepository con;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1> Employees </h1>");

        CustomerRepository C = new CustomerRepository();
        List<Customer> employees = C.list();

        out.println("<table border=\"1\">");
        out.println("<tr>");
        out.println("<th>#</th>");
        out.println("<th>name</th>");
        out.println("<th>department</th>");
        out.println("<th>salary</th>");
        out.println("</tr>");
        int i =0;
        for (Customer c : employees) {
            i++;
            out.println("<tr>");
            out.println("<td>" + i + "</td>");
            out.println("<td>" + c.getName() + "</td>");
            out.println("<td>" + c.getDepartment() + "</td>");
            out.println("<td>" + c.getSalary() + "</td>");
            out.println("<form action=\"delete?id="+c.getId()+"\" >");
            out.println("<td>" + "<button type=submit value="+c.getId()+" name=id>x</button>  ");
            out.println("</td>");
            out.println("</form>");

            out.println("<form action=\"edit?id="+c.getId()+"\" >");
            out.println("<td>" + "<button type=submit value="+c.getId()+" name=id>Edit</button>  ");
            out.println("</td>");
            out.println("</form>");

            out.println("</tr>");
        }

        out.println("</table>");
        out.println("<form action=\"add\" method=\"get\"> ");
        out.println("<input type=submit value=ADD > ");
        out.println("</form>");
        out.println("</body></html>");

    }

    public void destroy() {
    }






}