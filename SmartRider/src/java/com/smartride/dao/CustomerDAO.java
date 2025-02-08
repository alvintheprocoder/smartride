package com.smartride.dao;

import com.smartride.model.Customer;
import com.smartride.util.PasswordUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    private static final String JDBC_URL = "jdbc:derby://localhost:1527/SmartRideDB"; 
    private static final String JDBC_USER = "app"; 
    private static final String JDBC_PASSWORD = "app"; 

    // Establish a database connection
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    // Register a new customer
    public boolean registerCustomer(Customer customer) {
        String sql = "INSERT INTO customers (username, first_name, last_name, password, email, phone_num, address, gender) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Hash the password using PasswordUtil
            String hashedPassword = PasswordUtil.hashPassword(customer.getPassword());

            stmt.setString(1, customer.getUsername());
            stmt.setString(2, customer.getFirstName());
            stmt.setString(3, customer.getLastName());
            stmt.setString(4, hashedPassword);
            stmt.setString(5, customer.getEmail());
            stmt.setString(6, customer.getPhoneNum());
            stmt.setString(7, customer.getAddress());
            stmt.setString(8, customer.getGender());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Retrieve a customer by username
    public Customer getCustomerByUsername(String username) {
        String sql = "SELECT * FROM customers WHERE username = ?";
        Customer customer = null;

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                customer = new Customer();
                customer.setUsername(rs.getString("username"));
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("last_name"));
                customer.setPassword(rs.getString("password")); // Hashed password
                customer.setEmail(rs.getString("email"));
                customer.setPhoneNum(rs.getString("phone_num"));
                customer.setAddress(rs.getString("address"));
                customer.setGender(rs.getString("gender"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    // Retrieve all customers
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customers";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Customer customer = new Customer();
                customer.setUsername(rs.getString("username"));
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("last_name"));
                customer.setPassword(rs.getString("password"));
                customer.setEmail(rs.getString("email"));
                customer.setPhoneNum(rs.getString("phone_num"));
                customer.setAddress(rs.getString("address"));
                customer.setGender(rs.getString("gender"));
                customers.add(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    // Update customer details
    public boolean updateCustomer(Customer customer) {
        String sql = "UPDATE customers SET first_name = ?, last_name = ?, password = ?, email = ?, phone_num = ?, address = ?, gender = ? WHERE username = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Hash the password using PasswordUtil
            String hashedPassword = PasswordUtil.hashPassword(customer.getPassword());

            stmt.setString(1, customer.getFirstName());
            stmt.setString(2, customer.getLastName());
            stmt.setString(3, hashedPassword);
            stmt.setString(4, customer.getEmail());
            stmt.setString(5, customer.getPhoneNum());
            stmt.setString(6, customer.getAddress());
            stmt.setString(7, customer.getGender());
            stmt.setString(8, customer.getUsername());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Delete a customer by username
    public boolean deleteCustomer(String username) {
        String sql = "DELETE FROM customers WHERE username = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Validate login (checks username and password)
    public boolean validateLogin(String username, String password) {
        String sql = "SELECT password FROM customers WHERE username = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String hashedPassword = rs.getString("password");
                return PasswordUtil.verifyPassword(password, hashedPassword); // Compare passwords
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
