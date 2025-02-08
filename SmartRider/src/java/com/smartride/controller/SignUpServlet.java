package com.smartride.controller;

import com.smartride.model.Customer;
import com.smartride.dao.CustomerDAO;
import com.smartride.util.PasswordUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class SignUpServlet extends HttpServlet {
    // Handle GET request for the signup page
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward to the signup form
        request.getRequestDispatcher("signUp.jsp").forward(request, response);
    }

    // Handle POST request for form submission
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String username = request.getParameter("username");
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String email = request.getParameter("email");
        String phoneNum = request.getParameter("phone_num");
        String address = request.getParameter("address");
        String gender = request.getParameter("gender");
        String password = request.getParameter("password");

        // Hash the password before storing it
        String hashedPassword = PasswordUtil.hashPassword(password);

        // Create a new Customer object
        Customer newCustomer = new Customer(username, firstName, lastName, email, phoneNum, address, gender, hashedPassword);

        // Create a DAO to interact with the database
        CustomerDAO customerDAO = new CustomerDAO();

        // Attempt to register the customer
        boolean isRegistered = customerDAO.registerCustomer(newCustomer);

        // Check if registration was successful
        if (isRegistered) {
            // Redirect to the login page
            response.sendRedirect("Login.jsp");
        } else {
            // If registration fails, show an error message
            request.setAttribute("errorMessage", "Username already exists or there was an issue with registration.");
            request.getRequestDispatcher("signUp.jsp").forward(request, response);
        }
    }
}
