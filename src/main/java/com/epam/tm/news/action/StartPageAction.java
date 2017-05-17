package com.epam.tm.news.action;

import com.epam.tm.news.dao.NewsDao;
import com.epam.tm.news.entity.News;
import com.epam.tm.news.service.NewsService;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Time;
import java.util.List;

public class StartPageAction extends Action {

    @Autowired
    private NewsService service;

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        News news = new News();
        news.setId(7);
        news.setTitle("HelloWorld");
        news.setDate(new Time(0));
        news.setContent("It's Content");
        news.setBrief("It's Brief");

        News news1 = service.saveNews(news);

        /*List<News> allNewsOrderByDate = newsDao.getAllNewsOrderByDate();

        request.setAttribute("string", allNewsOrderByDate);*/
        request.setAttribute("string", news1.getId());

        return mapping.findForward("startPage");
    }
}
