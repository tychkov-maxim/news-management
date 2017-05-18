package com.epam.tm.news.form;

import com.epam.tm.news.entity.News;
import org.apache.struts.action.ActionForm;

import java.util.List;

public class NewsForm extends ActionForm {

    private News news;
    private List<News> allNews;


    public NewsForm() {
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public List<News> getAllNews() {
        return allNews;
    }

    public void setAllNews(List<News> allNews) {
        this.allNews = allNews;
    }

}
