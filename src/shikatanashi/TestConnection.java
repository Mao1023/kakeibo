package shikatanashi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {

    // ★★★ 接続情報 ★★★
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    // JDBC URL：データベースに接続するためのアドレス
    // ※ まだ家計簿用のデータベースを作っていませんが、これで接続テストは可能です
    private static final String DB_URL = "jdbc:mysql://localhost:3306/";
    // ★★★ 接続情報 ここまで ★★★

    public static void main(String[] args) {
        Connection conn = null;
        try {
            System.out.println("データベースに接続を試みます..");

            // データベースへの接続を確立
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            if (conn != null) {
                System.out.println("✅ データベースへの接続に成功しました！");
                System.out.println("これでJavaからMySQLの操作が可能です。");
            }

        } catch (SQLException e) {
            System.out.println("❌ データベース接続エラーが発生しました。");
            System.out.println("以下の情報をもとに設定を確認してください。");
            System.out.println("---------------------------------");
            System.out.println("エラー内容: " + e.getMessage());

        } finally {
            // 接続を閉じる
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}