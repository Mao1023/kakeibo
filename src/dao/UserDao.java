package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserDao {

    // ① データベース接続情報
    private static final String URL = "jdbc:mysql://localhost:3306/kakeibo_app";
    private static final String USER = "root"; // MySQLユーザー名
    private static final String PASSWORD = "password"; // MySQLパスワード

    /**
     * データベース接続を取得するメソッド
     */
    private Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBCドライバが見つかりません。");
            e.printStackTrace();
            throw new SQLException(e);
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}