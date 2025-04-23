package model;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Jerry
 * @create 2025/4/22下午 10:06
 * @desc：
 */
public class DBUtil {
    private static final String URL ="jdbc:mysql://localhost:3306/jdbcwupie?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "Pa$$w0rd";

    public static Connection getConnection()throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }
}
