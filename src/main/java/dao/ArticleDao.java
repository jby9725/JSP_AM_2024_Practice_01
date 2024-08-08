package dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dto.Article;
import util.DBUtil;
import util.SecSql;

public class ArticleDao {
	private Connection conn;

	public ArticleDao(Connection conn) {
		this.conn = conn;
	}

	public int getTotalCnt() {

		SecSql sql = SecSql.from("SELECT COUNT(*) AS cnt");
		sql.append("FROM article");
		return DBUtil.selectRowIntValue(conn, sql);
	}

	public List<Article> getForPrintArticles(int limitFrom, int itemsInAPage) {
		SecSql sql = SecSql.from("SELECT A.*, M.nickname");
		sql.append("FROM article AS A");
		sql.append("INNER JOIN `member` AS M");
		sql.append("ON A.author = M.id");
		sql.append("ORDER BY id DESC");
		sql.append("LIMIT ?, ?;", limitFrom, itemsInAPage);
//		return DBUtil.selectRows(conn, sql);
		
		List<Map<String, Object>> articleRows = DBUtil.selectRows(conn, sql);

		List<Article> articles = new ArrayList<>();

		for (Map<String, Object> articleMap : articleRows) {
			articles.add(new Article(articleMap));
		}

		return articles;
	}
}
