package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.DBUtil;
import util.SecSql;

@WebServlet("/member/doLogin")
public class MemberDoLoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		// DB 연결
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스 x");
			e.printStackTrace();
		}

		System.out.println("db 드라이버 연결 완료오!!");

		// String url = "jdbc:mysql://localhost:3306/ArticleManager";
		String url = "jdbc:mysql://127.0.0.1:3306/ArticleManager?useUnicode=true&characterEncoding=utf8&autoReconnect=true&serverTimezone=Asia/Seoul";		
		System.out.println(url);
		
		String user = "root";
		String pwd = "";

		Connection conn = null;

		try {
			conn = DriverManager.getConnection(url, user, pwd);
			response.getWriter().append("연결 성고옹!");

			String userId = request.getParameter("userId");
			String password = request.getParameter("password");

//			SELECT * FROM `member` WHERE userId='test01' AND `password`='test01';
			
			SecSql sql = SecSql.from("SELECT count(*) FROM `member`");
			sql.append("WHERE userId= ?", userId);
			sql.append("AND password = ?;", password);

			boolean isMember = DBUtil.selectRowBooleanValue(conn, sql);

			response.getWriter()
					.append(String.format("<script>alert('로그인 여부 : %s'); location.replace('../home/main');</script>", isMember));
		} catch (SQLException e) {
			System.out.println("에러 1-3 : " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}