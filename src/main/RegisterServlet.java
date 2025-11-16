package main;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.UserDao;
import util.PasswordUtil;

// URLをLogonServletと同じように設定します
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");

        // フォームからユーザー名とパスワードを取得
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 【１】パスワードのハッシュ化
        String hashedPassword = PasswordUtil.hashPassword(password);

        // 【２】管理者フラグの設定
        int isAdmin = 0;

        // 【３】データベース処理の実行 ★この3行が特に重要
        UserDao userDao = new UserDao();
        boolean success = userDao.registerUser(username, hashedPassword, isAdmin);

        if (success) {
            // 登録成功の場合、ログオン画面へリダイレクト
            response.sendRedirect("logon.html");
        } else {
            // 登録失敗の場合、エラーメッセージを表示
            response.getWriter().println("<html><body><h1>登録処理に失敗しました。ユーザー名が既に存在する可能性があります。</h1></body></html>");
        }
    }
}