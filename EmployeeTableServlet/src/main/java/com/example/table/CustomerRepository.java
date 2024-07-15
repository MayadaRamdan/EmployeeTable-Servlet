package com.example.table;


import com.example.table.db.DBConnection;
import com.example.table.entity.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerRepository {


    public void update( Customer customer )  {
        Connection conn = DBConnection.getConnection();
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate( " update employee set employee_name = '" +customer.getName()+ "' ,employee_salary = "+customer.getSalary()+" " +
                    ",eployee_department = '"+customer.getDepartment()
                    +"' where employee_id = " + customer.getId() +";");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



    public void delete( int id)  {
        Connection conn = DBConnection.getConnection();
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate( " delete from employee where employee_id = " + id );

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void add(Customer customer)  {
        Connection conn = DBConnection.getConnection();
        try {
            Statement statement = conn.createStatement();
             statement.executeUpdate("insert into employee (employee_name, employee_salary, eployee_department)" +
                    "values ('" + customer.getName() + "'," + customer.getSalary() + ",'" + customer.getDepartment() + "');");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Customer> list() {

        Statement st = null;
        ResultSet rs = null;

        try {
            st = DBConnection.getConnection().createStatement();
            rs = st.executeQuery("select * from employee");

            if (rs == null) {
                return Collections.emptyList();
            }

            List<Customer> customers = new ArrayList<>();

            while (rs.next()) {
                int id = rs.getInt("employee_id");
                String name = rs.getString("employee_name");
                String department = rs.getString("eployee_department");
                int salary = rs.getInt("employee_salary");

                Customer customer = new Customer();
                customer.setId(id);
                customer.setSalary(salary);
                customer.setName(name);
                customer.setDepartment(department);

                customers.add(customer);
            }

            return customers;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
