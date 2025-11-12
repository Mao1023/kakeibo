package model;

public class User {
    private int userId;
    private String userName;
    private String userPasswordHash;
    private int userAdmin;

    // コンストラクタ
    public User(String userName, String userPasswordHash, int userAdmin) {
        this.userName = userName;
        this.userPasswordHash = userPasswordHash;
        this.userAdmin = userAdmin;
    }

    // ゲッターとセッター（すべて記述してください）
    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPasswordHash() {
        return userPasswordHash;
    }

    public int getUserAdmin() {
        return userAdmin;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPasswordHash(String userPasswordHash) {
        this.userPasswordHash = userPasswordHash;
    }

    public void setUserAdmin(int userAdmin) {
        this.userAdmin = userAdmin;
    }
}