package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
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

		System.out.println("db 드라이버 연결 완료오다!!");

		// String url = "jdbc:mysql://localhost:3306/ArticleManager";
		String url = "jdbc:mysql://127.0.0.1:3306/ArticleManager?useUnicode=true&characterEncoding=utf8&autoReconnect=true&serverTimezone=Asia/Seoul";		
		System.out.println(url);
		
		String user = "root";
		String pwd = "";

		Connection conn = null;

		try {
			conn = DriverManager.getConnection(url, user, pwd);
			response.getWriter().append("연결 성고옹이다!");

			String userId = request.getParameter("userId");
			String password = request.getParameter("password");

//			SELECT * FROM `member` WHERE userId='test01' AND `password`='test01';
			
			SecSql sql = SecSql.from("SELECT *");
			sql.append("FROM `member`");
			sql.append("WHERE userId= ?;", userId);
//			sql.append("AND password = ?;", password);

			Map<String, Object> memberRow = DBUtil.selectRow(conn, sql);

			
			if(memberRow.isEmpty()) {
				response.getWriter()
				.append(String.format("<script>alert('%s는 없는 아이디입니다.'); location.replace('../member/login');</script>", userId));				
				
				return;
			}
			
			
			
			if(memberRow.get("password").equals(password) == false) {
				response.getWriter()
				.append(String.format("<script>alert('비밀번호가 틀렸습니다.'); location.replace('../member/login');</script>"));				
				
				return;
			}
			
			/////////////////////////// 여기부터
			HttpSession session = request.getSession();
			session.setAttribute("loginedMemberId", memberRow.get("id"));
			session.setAttribute("loginedMemberUserId", memberRow.get("userId"));
			session.setAttribute("loginedMember", memberRow);

			
			response.getWriter()
			.append(String.format("<script>alert('%s님 환영합니다.'); location.replace('../home/main');</script>", memberRow.get("nickname")));
			
		
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