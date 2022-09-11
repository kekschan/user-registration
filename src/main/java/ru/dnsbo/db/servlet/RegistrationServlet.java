package ru.dnsbo.db.servlet;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private Connection connection;

    @Override
    public void init() {
        Properties properties = new Properties();

        try {
            properties.load(Files.newInputStream(Paths.get(getServletContext().getRealPath("/WEB-INF/classes/db.properties"))));
            String dbUrl = properties.getProperty("db.url");
            String dbUser = properties.getProperty("db.username");
            String dbPassword = properties.getProperty("db.password");
            String driverClass = properties.getProperty("db.driverClassName");

            Class.forName(driverClass);
            connection = DriverManager.getConnection(dbUrl,dbUser,dbPassword);

        } catch (IOException | ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }


    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String secondNameRegistration = request.getParameter("secondNameRegistration");
        String nameRegistration = request.getParameter("nameRegistration");
        String emailRegistration = request.getParameter("emailRegistration");
        String passwordRegistration = request.getParameter("passwordRegistration");

        try {
           /* Statement statement = connection.createStatement();
            String InsertReferee = "INSERT INTO referee(secondnameregistration, nameregistration, emailregistration, passwordregistration)" +
                    "VALUES ('" + secondNameRegistration + "','" + nameRegistration + "','" + emailRegistration + "','" + passwordRegistration + "');";
            System.out.println(InsertReferee);
            statement.executeUpdate(InsertReferee);*/

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO " + "referee(secondnameregistration, nameregistration, emailregistration, passwordregistration) "
            + "VALUES(?,?,?,?);");
            preparedStatement.setString(1,secondNameRegistration);
            preparedStatement.setString(2,nameRegistration);
            preparedStatement.setString(3,emailRegistration);
            preparedStatement.setString(4,passwordRegistration);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}