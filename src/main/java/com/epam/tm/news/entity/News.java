package com.epam.tm.news.entity;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "NEWS")
public class News extends BaseEntity{
    private String title;
    private Time date;
    private String brief;
    private String content;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID", nullable = false, precision = 0)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TITLE", nullable = false, length = 64)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "dateApp", nullable = false)
    public Time getDate() {
        return date;
    }

    public void setDate(Time date) {
        this.date = date;
    }

    @Basic
    @Column(name = "BRIEF", nullable = true, length = 512)
    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    @Basic
    @Column(name = "CONTENT", nullable = true, length = 2048)
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
