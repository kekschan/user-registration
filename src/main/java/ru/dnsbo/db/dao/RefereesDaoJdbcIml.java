package ru.dnsbo.db.dao;

import ru.dnsbo.db.referees.Referees;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RefereesDaoJdbcIml implements RefereesDao {

    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM referee";
    //language=SQL
    private final String SQL_SELECT_BY_ID = "SELECT * FROM referee WHERE id = ?";


    private Connection connection;

    public RefereesDaoJdbcIml(DataSource dataSource) throws SQLException {
        this.connection = dataSource.getConnection();
    }


    //поиск через ID
    @Override
    public Referees find(Integer id) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ID);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String secondNameRegistration = resultSet.getString("secondnameregistration");
            String nameRegistration = resultSet.getString("nameregistration");
            String emailRegistration = resultSet.getString("emailregistration");
            String passwordRegistration = resultSet.getString("passwordregistration");

            return new Referees(id, secondNameRegistration, nameRegistration, emailRegistration, passwordRegistration);
        }
        return null;
    }

    @Override
    public void save(Referees model) {

    }

    @Override
    public void update(Referees model) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Referees> findAll() throws SQLException {
        List<Referees> refereesList = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);
        while (resultSet.next()) {
            Integer idRegistration = resultSet.getInt("id");
            String secondNameRegistration = resultSet.getString("secondnameregistration");
            String nameRegistration = resultSet.getString("nameregistration");
            String emailRegistration = resultSet.getString("emailregistration");
            String passwordRegistration = resultSet.getString("passwordregistration");

            Referees referees = new Referees(idRegistration, secondNameRegistration, nameRegistration, emailRegistration, passwordRegistration);
            refereesList.add(referees);
        }

        return refereesList;
    }

    @Override
    public List<Referees> findBySecondNameAndName(String secondName, String name) {
        return null;
    }
}
