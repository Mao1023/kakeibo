package main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().println("<html><body><h1>認証処理が実行されました！</h1></body></html>");
    }
}