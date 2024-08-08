package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/article/write")
public class ArticleWriteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		if(session != null) {
			System.out.println("널이 아니야");
			response.getWriter().append("널이 아니야");
			String str = (String) session.getAttribute("isLogined");
			response.getWriter().append(str);
			System.out.println(str);
		}
		else {
			System.out.println("널이야");
			response.getWriter().append("널이야");
		}
		
		request.getRequestDispatcher("/jsp/article/write.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
}