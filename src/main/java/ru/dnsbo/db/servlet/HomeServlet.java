package ru.dnsbo.db.servlet;

import ru.dnsbo.db.referees.Referees;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    private Connection connection;
    //language=SQL

    @Override
    public void init() throws ServletException {
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
    private final String SQL_SELECT_BY_ID = "SELECT * FROM referee";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String LoginSecondName = request.getParameter("LoginSecondName");
        String LoginName = request.getParameter("LoginName");
        String LoginPassword = request.getParameter("LoginPassword");

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ID);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String secondNameRegistration = resultSet.getString("secondnameregistration");
                String nameRegistration = resultSet.getString("nameregistration");
                String passwordRegistration = resultSet.getString("passwordregistration");

                if(LoginSecondName.equals(secondNameRegistration)&(LoginName.equals(nameRegistration))&(LoginPassword.equals(passwordRegistration))){
                    request.getServletContext().getRequestDispatcher("/jsp/home.jsp").forward(request,response);
                }else {
                    request.getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(request,response);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }






    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
