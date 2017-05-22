package com.epam.tm.news.action;

import com.epam.tm.news.entity.News;
import com.epam.tm.news.form.NewsForm;
import com.epam.tm.news.service.NewsService;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class NewsAction extends DispatchAction {

    private static final String ALL_NEWS_FORWARD = "allNews";
    private static final String SHOW_FORWARD = "show";
    private static final String EDIT_FORWARD = "edit";
    private static final String ID = "id";

    @Autowired
    private NewsService newsService;

    public ActionForward allNews(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception {

        NewsForm newsForm = (NewsForm) form;
        newsForm.setAllNews(newsService.getAllNewsByDate());
        return mapping.findForward(ALL_NEWS_FORWARD);
    }

    public ActionForward show(ActionMapping mapping, ActionForm form,
                              HttpServletRequest request, HttpServletResponse response) throws Exception {
        setNewsByIdFromDB(form,request);
        return mapping.findForward(SHOW_FORWARD);
    }


    public ActionForward edit(ActionMapping mapping, ActionForm form,
                              HttpServletRequest request, HttpServletResponse response) throws Exception{
        setNewsByIdFromDB(form,request);
        return mapping.findForward(EDIT_FORWARD);
    }

    public ActionForward add(ActionMapping mapping, ActionForm form,
                              HttpServletRequest request, HttpServletResponse response) throws Exception{
        NewsForm newsForm = (NewsForm) form;
        News news = newsForm.getNews();
        news.setDate(new Time(new Date().getTime()));
        newsService.saveNews(news);
        //newsForm.setAllNews(newsService.getAllNewsByDate());
        return mapping.findForward(ALL_NEWS_FORWARD);
    }


    public ActionForward delete(ActionMapping mapping, ActionForm form,
                             HttpServletRequest request, HttpServletResponse response) throws Exception{
        NewsForm newsForm = (NewsForm) form;
        int[] selectedNewsId = newsForm.getSelectedNewsId();

        for (int i : selectedNewsId) {
            News news = new News();
            news.setId(i);
            news.setDate(new Time(0));
            news.setTitle("");
            newsService.deleteNewsById(news);
        }

        newsForm.setAllNews(newsService.getAllNewsByDate());
        return mapping.findForward(ALL_NEWS_FORWARD);
    }



    public ActionForward addNews(ActionMapping mapping, ActionForm form,
                             HttpServletRequest request, HttpServletResponse response) throws Exception{
        NewsForm newsForm = (NewsForm) form;
        newsForm.setNews(new News());
        newsForm.setDateString(new Date().toString());
        return mapping.findForward(EDIT_FORWARD);
    }

    private void setNewsByIdFromDB(ActionForm form, HttpServletRequest request){
        NewsForm newsForm = (NewsForm) form;
        String idParam = request.getParameter(ID);
        long id;
        try {
            id = Long.parseLong(idParam);
        } catch (NumberFormatException e) {
            id = 0;
        }
        News newsById = newsService.getNewsById(id);
        newsForm.setDateString(new Date(newsById.getDate().getTime()).toString());
        newsForm.setNews(newsById);
    }


}
