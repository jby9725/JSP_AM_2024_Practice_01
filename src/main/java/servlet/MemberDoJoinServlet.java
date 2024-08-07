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

@WebServlet("/member/doJoin")
public class MemberDoJoinServlet extends HttpServlet {

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

		System.out.println("db 드라이버 연결 완료!!");

		// String url = "jdbc:mysql://localhost:3306/ArticleManager";
		String url = "jdbc:mysql://127.0.0.1:3306/ArticleManager?useUnicode=true&characterEncoding=utf8&autoReconnect=true&serverTimezone=Asia/Seoul";		
		System.out.println(url);
		
		String user = "root";
		String pwd = "";

		Connection conn = null;

		try {
			conn = DriverManager.getConnection(url, user, pwd);
			response.getWriter().append("연결 성공!");

			String userId = request.getParameter("userId");
			String password = request.getParameter("password");
			String nickname = request.getParameter("nickname");

//			INSERT INTO `member` (`regDate`, `userId`, `password`, `nickname`)
//			VALUES (NOW(), 'test01', 'test01', '홍길동');
			
			SecSql sql = SecSql.from("INSERT INTO `member`");
			sql.append("SET regDate = NOW(),");
			sql.append("userId = ?,", userId);
			sql.append("password = ?,", password);
			sql.append("nickname = ?;", nickname);

			int id = DBUtil.insert(conn, sql);

			response.getWriter()
					.append(String.format("<script>alert('%d번 멤버가 생성됨'); location.replace('../home/main');</script>", id));
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