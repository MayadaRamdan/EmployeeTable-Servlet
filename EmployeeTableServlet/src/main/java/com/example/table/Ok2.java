package com.example.table;


import com.example.table.entity.Customer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ok2"  ,value = "/ok2")
public class Ok2  extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        String name = req.getParameter("name");
        int salary = Integer.parseInt(req.getParameter("salary"));
        String department = req.getParameter("department");

        Customer customer = new Customer(id,name,department,salary);

        CustomerRepository cr = new CustomerRepository();
        cr.update( customer);

        res.sendRedirect("list-servlet");
    }
}

