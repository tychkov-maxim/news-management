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

public class NewsAction extends DispatchAction {

    private static final String ALL_NEWS_FORWARD = "allNews";
    private static final String SHOW_FORWARD = "show";
    private static final String EDIT_FORWARD = "edit";

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
        newsService.saveNews(news);
        return mapping.findForward(ALL_NEWS_FORWARD);
    }


    private void setNewsByIdFromDB(ActionForm form, HttpServletRequest request){
        NewsForm newsForm = (NewsForm) form;
        String idParam = request.getParameter("id");

        //// TODO: 5/18/2017 how without validator?
        long id;
        try {
            id = Long.parseLong(idParam);
        } catch (NumberFormatException e) {
            id = 0;
        }

        News newsById = newsService.getNewsById(id);
        newsForm.setNews(newsById);
    }


}
