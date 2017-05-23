package com.epam.tm.news.form;

import com.epam.tm.news.entity.News;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsForm extends ValidatorForm {

    private News news = new News();
    private List<News> allNews = new ArrayList<>();
    private int[] selectedNewsId;
    private String dateString;

    public NewsForm() {
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    public int[] getSelectedNewsId() {
        return selectedNewsId;
    }

    public void setSelectedNewsId(int[] selectedNewsId) {
        this.selectedNewsId = selectedNewsId;
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

    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        String currentDate = new Date().toString();
        setDateString(currentDate);
        news.setTitle("");
        news.setBrief("");
        news.setContent("");
    }
}
