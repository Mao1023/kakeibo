// src/main/App.java (または src/App.java)

package main;

import model.User;
import dao.UserDao;

public class App {
    public static void main(String[] args) {

        // ----------------------------------------------------
        // 【テスト1: 新規ユーザーの登録】
        // ----------------------------------------------------

        // 1. 登録したいユーザー情報を作成
        User newUser = new User("testuser2", "hashedpassword12", 0);

        // 2. UserDaoインスタンスの作成
        UserDao dao = new UserDao();

        // 3. ユーザー登録メソッドの実行
        boolean success = dao.insertUser(newUser);

        // 4. 結果の判定と出力
        if (success) {
            System.out.println("✅ ユーザー登録テストに成功しました！");
            System.out.println("データベースの user_mst テーブルを確認してください。");
        } else {
            System.out.println("❌ ユーザー登録テストに失敗しました。");
            System.out.println("・UserDao.java の接続情報が正しいか確認してください。");
            System.out.println("・同じユーザー名で2回実行すると、データベースの制約により失敗します。");
        }

        // ----------------------------------------------------
        // 【テスト2: ユーザーログイン認証】
        // ----------------------------------------------------
        String loginUsername = "testuser2"; // 登録済みのユーザー名
        String loginPasswordHash = "hashedpassword123"; // 登録済みのパスワードハッシュ

        System.out.println("\n--- ログイン認証テスト開始 ---");

        // 1. ユーザー名でデータベースを検索
        User authenticatedUser = dao.findUser(loginUsername); // findUserに名前を修正

        if (authenticatedUser != null) {
            // 2. ユーザーが見つかった場合、パスワードが一致するか比較
            // 今回はテストのため、ハッシュ化された文字列がそのまま一致するか確認
            if (authenticatedUser.getUserPasswordHash().equals(loginPasswordHash)) {

                System.out.println("✅ ログインに成功しました！");
                System.out.println("ようこそ、" + authenticatedUser.getUserName() + "さん。");
                System.out.println("ユーザーID: " + authenticatedUser.getUserId());

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