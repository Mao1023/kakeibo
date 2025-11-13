package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import model.User;

public class PasswordUtil {

    // ハッシュ化
    public static String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256"); // SHA-256アルゴリズムを取得
            byte[] hash = digest.digest(password.getBytes()); // パスワードをハッシュ化
            StringBuilder hexString = new StringBuilder(); // ハッシュ値を16進数に変換するためのStringBuilder
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b); // バイトを16進数に変換
                if (hex.length() == 1) {
                    hexString.append('0'); // 1桁の場合は0を追加
                }
                hexString.append(hex); // 16進数を追加
            }
            return hexString.toString(); // ハッシュ値を返す
        } catch (NoSuchAlgorithmException e) {
            System.err.println("ハッシュ化失敗: 指定された暗号アルゴリズムが見つかりません。");
            e.printStackTrace();
            return null;
        }
    }

    public static boolean verifyPassword(String inputPassword, String storedHash) {
        // 1. 入力されたパスワード（平文）をハッシュ化する
        String inputHash = hashPassword(inputPassword);

        // 2. 新しく生成したハッシュ値と、DBから取得したハッシュ値が一致するか比較する
        return inputHash != null && inputHash.equals(storedHash);
    }
}
