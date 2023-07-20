package com.thank4.api.statement

import java.sql.DriverManager

fun main() {
    Class.forName("com.mysql.cj.jdbc.Driver")
    val connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?user=root&password=root")

    val sql = "select * from user where username = ?;"
    println(sql)
    val prepareStatement = connection.prepareStatement(sql)
    prepareStatement.setString(1,"user1")

    val resultSet = prepareStatement.executeQuery()

    while (resultSet.next()){
        val id = resultSet.getInt("id")
        val username = resultSet.getString("username")
        val email = resultSet.getString("email")
        val createdAt = resultSet.getDate("created_at")
        println("username=" + username + "email=" + email + "createdAt=" + createdAt)
    }
    prepareStatement.close()
    connection.close()
}