package ru.netology.data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;


import java.sql.Connection;
import java.sql.DriverManager;


public class DBHelper {
    private DBHelper() {
    }

    private final static Connection conn = establishConnection();
    private final static QueryRunner runn = new QueryRunner();

    @SneakyThrows
    private static Connection establishConnection() {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
    }

    @SneakyThrows
    public static String getStatusOperationActual() {
        String statusSQL = "SELECT status FROM payment_entity WHERE created=(SELECT MAX(created) FROM payment_entity);";
        String statusOperationActual = runn.query(conn, statusSQL, new ScalarHandler<>());
        return statusOperationActual;
    }

    @SneakyThrows
    public static void deleteDataBase() {
        runn.execute(conn, "TRUNCATE payment_entity");
        runn.execute(conn, "TRUNCATE credit_request_entity;");
        runn.execute(conn, "TRUNCATE order_entity;");
    }

}
