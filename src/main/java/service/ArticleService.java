package service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import dao.ArticleDao;
import dto.Article;
import jakarta.servlet.http.HttpSession;
import util.DBUtil;
import util.SecSql;

public class ArticleService {

	private Connection conn;
	private ArticleDao articleDao;

	public ArticleService(Connection conn) {
		this.conn = conn;
		this.articleDao = new ArticleDao(conn);
	}
	
	public int getTotalCnt() {
		return articleDao.getTotalCnt();
	}

	public List<Article> getForPrintArticles(int limitFrom, int itemsInAPage) {
		return articleDao.getForPrintArticles(limitFrom, itemsInAPage);
	}

}
