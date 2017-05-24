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
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.epam.tm.news.constant.ConstantHolder.*;

public class NewsAction extends DispatchAction {


    @Autowired
    private NewsService newsService;

    private SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

    public ActionForward allNews(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception {

        NewsForm newsForm = (NewsForm) form;
        newsForm.setAllNews(newsService.getAllNewsByDate());
        return mapping.findForward(ALL_NEWS_FORWARD);
    }

    public ActionForward show(ActionMapping mapping, ActionForm form,
                              HttpServletRequest request, HttpServletResponse response) throws Exception {
        News news = setNewsByIdFromDB(form, request);
        request.setAttribute(NEWS_ATTRIBUTE,news);
        return mapping.findForward(SHOW_FORWARD);
    }


    public ActionForward edit(ActionMapping mapping, ActionForm form,
                              HttpServletRequest request, HttpServletResponse response) throws Exception {
        setNewsByIdFromDB(form, request);
        return mapping.findForward(EDIT_FORWARD);
    }

    public ActionForward delete(ActionMapping mapping, ActionForm form,
                                HttpServletRequest request, HttpServletResponse response) throws Exception {
        NewsForm newsForm = (NewsForm) form;
        int[] selectedNewsId = newsForm.getSelectedNewsId();
        long idFromReq = Long.parseLong(request.getParameter(ID));
        News news = new News();
        news.setId(idFromReq);
        newsService.deleteNewsById(news);
        return mapping.findForward(ALL_NEWS_REDIRECT);
    }


    public ActionForward addNews(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception {
        NewsForm newsForm = (NewsForm) form;
        newsForm.setNews(new News());
        newsForm.setDateString(formatter.format(new Date()));
        return mapping.findForward(EDIT_FORWARD);
    }

    private News setNewsByIdFromDB(ActionForm form, HttpServletRequest request) {
        NewsForm newsForm = (NewsForm) form;
        News newsById = newsService.getNewsById(Long.parseLong(request.getParameter(ID)));
        newsForm.setDateString(formatter.format(newsById.getDate()));
        newsForm.setNews(newsById);
        return newsById;
    }


}
