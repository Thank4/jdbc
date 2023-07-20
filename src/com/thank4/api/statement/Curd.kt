package com.thank4.api.statement

import org.junit.Test
import java.sql.DriverManager

class Curd {
    @Test
    fun testInset():Unit{
        Class.forName("com.mysql.cj.jdbc.Driver")
        val connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?user=root&password=root")

        val sql = "Insert into user(username,email,created_at) values(?,?,?)"
        val prepareStatement = connection.prepareStatement(sql)
        prepareStatement.setString(1,"thank4")
        prepareStatement.setString(2,"thank4@90.cm")
        prepareStatement.setObject(3, "2023-07-19 13:59:44" )
        val executeUpdate = prepareStatement.executeUpdate()
        if (executeUpdate>0){
            println("插入成功")
        }
        prepareStatement.close()
        connection.close()
    }
}