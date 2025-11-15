// src/main/App.java (または src/App.java)

package main;

import model.User;
import util.PasswordUtil;
import dao.UserDao;

public class App {
    public static void main(String[] args) {

        // ----------------------------------------------------
        // 【テスト1: 新規ユーザーの登録】
        // ----------------------------------------------------
        // 1. UserDaoインスタンスの作成
        UserDao dao = new UserDao();

        // 2. パスワードをハッシュ化する
        String hashedPassword = PasswordUtil.hashPassword("hashedpassword12");

        if (hashedPassword != null) {
            User newUser = new User("testuser2", hashedPassword, 0);

            // 3. ハッシュ化されたパスワードをDBに登録
            boolean success = dao.insertUser(newUser);

            if (success) {
                System.out.println("✅ 安全なユーザー登録に成功しました！");
            } else {
                System.out.println("❌ ユーザー登録に失敗しました。(ユーザー名重複の可能性)");
            }
        } else {
            System.out.println("❌ ハッシュ化に失敗したため登録できませんでした。");
        }

        // ----------------------------------------------------
        // 【テスト3: 安全なログイン認証】
        // ----------------------------------------------------

        String loginUsername = "testuser2"; // 認証するユーザー名
        String inputPassword = "hashedpassword12"; // 入力された平文のパスワード

        System.out.println("\n--- ログイン認証テスト開始 ---");

        // 1. ユーザー名でデータベースを検索
        User authenticatedUser = dao.findUser(loginUsername);

        if (authenticatedUser != null) {
            // 2. DBのハッシュ値を使って、入力パスワードを検証
            boolean isVerified = PasswordUtil.verifyPassword(
                    inputPassword,
                    authenticatedUser.getUserPasswordHash());

            if (isVerified) {
                System.out.println("✅ ログインに成功しました！");
                System.out.println("ようこそ、" + authenticatedUser.getUserName() + "さん。");
            } else {
                // パスワードが一致しない
                System.out.println("❌ ログイン失敗: パスワードが違います。");
            }
        } else {
            // ユーザーが見つからなかった
            System.out.println("❌ ログイン失敗: ユーザーが見つかりません。");
        }
    }
}