package com.thank4.api.statement


import com.alibaba.druid.pool.DruidDataSource
import com.alibaba.druid.pool.DruidDataSourceFactory
import com.mysql.cj.jdbc.Driver
import org.junit.Test
import java.sql.DriverManager
import java.sql.Statement

class Curd {
    @Test
    fun testInset():Unit {


        val connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?user=root&password=root")

        val sql = "Insert into user(username,email,created_at) values(?,?,?)"
        val prepareStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        prepareStatement.setString(1, "thank4")
        prepareStatement.setString(2, "thank4@90.cm")
        prepareStatement.setObject(3, "2023-07-19 13:59:44")
        val executeUpdate = prepareStatement.executeUpdate()
        if (executeUpdate > 0) {
            println("插入成功")
            val resultSet = prepareStatement.generatedKeys
            resultSet.next()
            val index = resultSet.getInt(1)

            println("插入主键id$index")

            prepareStatement.close()
            connection.close()

        }
    }

    @Test
    fun testHard() {
        val druidDataSource = DruidDataSource()
        druidDataSource.driverClassName = "com.mysql.cj.jdbc.Driver"
        druidDataSource.username = "root"
        druidDataSource.password = "root"
        druidDataSource.url = "jdbc:mysql:///jdbc"
        val connection = druidDataSource.connection

        val sql = "Insert into user(username,email,created_at) values(?,?,?)"
        val prepareStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        prepareStatement.setString(1, "thank4")
        prepareStatement.setString(2, "thank4@90.cm")
        prepareStatement.setObject(3, "2023-07-22 15:24:41")
        val executeUpdate = prepareStatement.executeUpdate()
        if (executeUpdate > 0) {
            println("插入成功")
            val resultSet = prepareStatement.generatedKeys
            resultSet.next()
            val index = resultSet.getInt(1)

            println("插入主键id$index")
        }
        prepareStatement.close()
        connection.close()
    }
}