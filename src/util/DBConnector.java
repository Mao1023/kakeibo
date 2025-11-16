package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    // 【設定情報】データベースに応じて変更してください
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/kakeibo_app"; // データベース名を設定
    private static final String USER = "root"; // MySQLのユーザー名
    private static final String PASS = "password"; // MySQLのパスワード

    public static Connection getConnection() throws SQLException {
        try {
            // JDBCドライバのロード
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new SQLException("データベースドライバーが見つかりません。", e);
        }

        // 接続を確立
        return DriverManager.getConnection(URL, USER, PASS);
    }
}