package dto;

import java.time.LocalDateTime;
import java.util.Map;

public class Article {
	private int id;
    private String title;
    private String body;
    private int author;
    private LocalDateTime  regDate;
    private LocalDateTime  updateDate;

    // member table 안의 author
    private String M_author;

    public Article(int id, String title, String body, int author, LocalDateTime  regDate, LocalDateTime  updateDate, String m_author) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.author = author;
        this.regDate = regDate;
        this.updateDate = updateDate;

        this.M_author = m_author;
    }

    public Article(Map<String, Object> articleMap) {
        this.id = (int) articleMap.get("id");
        this.regDate = (LocalDateTime ) articleMap.get("regDate");
        this.updateDate = (LocalDateTime ) articleMap.get("updateDate");
        this.author = (int) articleMap.get("author");
        this.title = (String) articleMap.get("title");
        this.body = (String) articleMap.get("body");

        // get 할 때 고유의 컬럼명으로 해야만 제대로 출력된다.
        // sql.append("SELECT A.*, M.nickname"); 했다고 하더라도
        // "M.nickname"이 아니라 "nickname"으로 해주어야 한다.
        // AS 가 통하지 않아요!
        this.M_author = (String) articleMap.get("nickname");
    }

    public String getM_author() {
        return M_author;
    }

    public void setM_author(String m_author) {
        M_author = m_author;
    }

    public LocalDateTime  getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime  updateDate) {
        this.updateDate = updateDate;
    }

    public LocalDateTime  getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDateTime  regDate) {
        this.regDate = regDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
