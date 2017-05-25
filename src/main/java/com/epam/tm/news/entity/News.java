package com.epam.tm.news.entity;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


@NamedQueries({
        @NamedQuery(name = "findById", query = "from News where id = :id"),
        @NamedQuery(name = "delete", query = "delete News where id = :id"),
        @NamedQuery(name = "getListByDate", query = "from News order by date desc"),
})
@NamedNativeQueries({
        @NamedNativeQuery(name = "insert", query = "insert into News values(NEWS_SEQ.nextval, :title, :datetime, :brief, :content)"),
        @NamedNativeQuery(name = "update", query = "UPDATE News SET title = :title, dateapp = :datetime," +
                "brief = :brief, content = :content WHERE id = :id"),
        @NamedNativeQuery(name = "lastId", query = "SELECT NEWS_SEQ.currval FROM dual")
})
@Entity
@Table(name = "NEWS")
public class News extends BaseEntity{
    @Column(name = "TITLE", nullable = false, length = 64)
    private String title;
    @Column(name = "dateApp", nullable = false)
    private Date date;
    @Column(name = "BRIEF", length = 512)
    private String brief;
    @Column(name = "CONTENT", length = 2048)
    private String content;

    public News() {
        title = "";
        date = new Time(0);
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", date=" + date +
                '}';
    }
}
