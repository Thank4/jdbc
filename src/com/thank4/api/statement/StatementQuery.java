package com.thank4.api.statement;


import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.Properties;

public class StatementQuery {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?user=root&password=root");
        Statement statement = connection.createStatement();
        String sql = "select * from user where username = \"user1\"";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String username = resultSet.getString("username");
            String email = resultSet.getString("email");
            Date createdAt = resultSet.getDate("created_at");
            System.out.println("username="+username+"email="+email+"createdAt="+createdAt);
        }
        statement.close();
        connection.close();


    }
}
