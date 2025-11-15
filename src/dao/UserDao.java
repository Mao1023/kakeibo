package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UserDao {

    // データベース接続情報
    private static final String URL = "jdbc:mysql://localhost:3306/kakeibo_app";
    private static final String USER = "root"; // MySQLユーザー名
    private static final String PASSWORD = "password"; // MySQLパスワード

    // データベース接続を取得するメソッド
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

    // 新規ユーザーをuser_mstテーブルに登録する
    public Boolean insertUser(User user) {
        // SQL文: user_idは自動生成されるので、残りの3項目を登録
        String sql = "INSERT INTO user_mst (user_name, user_password_hash, user_admin) VALUES (?, ?, ?)";

        // try-with-resources で接続やSQL実行を扱う
        try (Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            // 1. SQLの?に値をセットする
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getUserPasswordHash());
            ps.setInt(3, user.getUserAdmin());
            // 2. SQLを実行し、成功した行数を受け取る
            int result = ps.executeUpdate();
            // 3. 結果の判定: 1行登録されたら成功
            return result == 1;
        } catch (SQLException e) {
            String sqlState = e.getSQLState(); // エラーコードを取得
            // 1. ユーザー名の重複チェック (SQLState '23000' は重複などの制約違反を示す)
            if (sqlState != null && sqlState.startsWith("23")) {
                // 例: "ユーザー名が既に登録されています" のようなメッセージを返す
                System.err.println("登録失敗: ユーザー名が既に存在します。");
                e.printStackTrace(); // 詳細なログは残す
                return false;
            }
            // 2. その他のデータベース接続エラーなど
            else {
                System.err.println("登録失敗: データベース処理中に予期せぬエラーが発生しました。");
                e.printStackTrace();
                return false;
            }
        }
    }

    // ユーザー情報を検索する
    public User findUser(String username) {
        // SQL文: user_idは自動生成されるので、残りの3項目を登録
        String sql = "SELECT user_id, user_name, user_password_hash, user_admin FROM user_mst WHERE user_name = ?";

        // try-with-resources で接続やSQL実行を扱う
        try (Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            // ★★★ 修正箇所: ここにsetStringを入れる ★★★
            ps.setString(1, username);

            // 2. SELECT文を実行し、結果セットを受け取る
            try (ResultSet rs = ps.executeQuery()) { // rsをtry-with-resourcesに含める

                // 3. 結果の確認
                if (rs.next()) {
                    // ユーザーを見つけてuserを返す
                    User user = new User(
                            rs.getString("user_name"),
                            rs.getString("user_password_hash"),
                            rs.getInt("user_admin"));
                    user.setUserId(rs.getInt("user_id"));
                    return user;
                }
            } // rsがここで閉じられる

            // ユーザーがいない場合nullを返す
            return null;

        } catch (SQLException e) {
            System.err.println("検索失敗: データベース処理中に予期せぬエラーが発生しました。");
            e.printStackTrace();
            return null;
        }
    }
}
