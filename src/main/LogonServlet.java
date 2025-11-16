package main;

import java.io.IOException;
import jakarta.servlet.ServletException; // ★javax -> jakarta
import jakarta.servlet.annotation.WebServlet; // ★javax -> jakarta
import jakarta.servlet.http.HttpServlet; // ★javax -> jakarta
import jakarta.servlet.http.HttpServletRequest; // ★javax -> jakarta
import jakarta.servlet.http.HttpServletResponse; // ★javax -> jakarta
// このアノテーションで、HTMLフォームからのアクセスURLを指定します

@WebServlet("/LogonServlet")
public class LogonServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // フォームからデータがPOST送信されたときに実行されるメソッド
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 【手順 1: HTMLフォームからのデータ取得】
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 【手順 2: Java認証ロジックの呼び出し】
        // ここにUserDaoを使った認証ロジックを実装します

        // 【手順 3: 結果に応じた画面遷移】
        // ログイン成功なら menu.htmlへ、失敗なら logon.htmlへ戻る

        // 絶対パスでリダイレクト先を指定することで、確実にメニュー画面に遷移させます
        // getContextPath() で Webアプリ名 (/kakeibo) を取得し、それに menu.html を連結します
        String contextPath = request.getContextPath(); // /kakeibo を取得
        String redirectURL = contextPath + "/menu.html";
        response.sendRedirect(redirectURL); // ★このリダイレクトが成功します★
    }
}