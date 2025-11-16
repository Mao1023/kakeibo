package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import util.DBConnector;

public class UserDao {

    /**
     * 新しいユーザーをデータベースに登録します。
     * 
     * @param username       ユーザー名
     * @param hashedPassword ハッシュ化されたパスワード
     * @param isAdmin        管理者権限 (int: 1または0)
     * @return 登録が成功したらtrue、失敗したらfalse
     */
    public boolean registerUser(String username, String hashedPassword, int isAdmin) {

        // ユーザー名、ハッシュ化されたパスワード、登録日、管理者フラグを登録するSQL
        String sql = "INSERT INTO user_mst (user_name, user_password_hash, user_admin, user_added_date) VALUES (?, ?, ?, NOW())";

        try (Connection conn = DBConnector.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            pstmt.setString(2, hashedPassword);
            pstmt.setInt(3, isAdmin); // 1 (管理者) または 0 (一般) をセット

            int result = pstmt.executeUpdate();
            return result > 0;

        } catch (SQLException e) {
            // 【修正箇所】ログの強制出力とスタックトレースの出力
            System.err.println("--- DB登録処理でSQLExceptionが発生しました ---");
            e.printStackTrace();
            System.err.println("-------------------------------------------------");
            return false;
        }
    }
}