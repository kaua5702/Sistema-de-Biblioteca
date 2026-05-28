package com.kauabiscotto.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory  {

    private static final String username = "root";
    private static final String password = "1234";
    private static final String url = "jdbc:mysql://localhost:3306/biblioteca";

    public static Connection createConnectionToMySQL() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }


}
