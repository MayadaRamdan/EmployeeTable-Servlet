package com.example.table;

import com.example.table.entity.Customer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(name = "ok"  ,value = "/ok")
public class Ok  extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("name");
        int salary = Integer.parseInt(req.getParameter("salary"));
        String department = req.getParameter("department");

        Customer customer = new Customer(name ,salary,department);
        CustomerRepository cR = new CustomerRepository();
        cR.add(customer);


        res.sendRedirect("list-servlet");
    }
}
