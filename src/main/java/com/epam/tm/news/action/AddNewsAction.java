package com.epam.tm.news.action;

import com.epam.tm.news.entity.News;
import com.epam.tm.news.form.NewsForm;
import com.epam.tm.news.service.NewsService;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

import static com.epam.tm.news.constant.ConstantHolder.*;


public class AddNewsAction extends Action {


    @Autowired
    private NewsService newsService;

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        NewsForm newsForm = (NewsForm) form;
        News news = newsForm.getNews();
        news.setDate(new Date());
        newsService.saveNews(news);

        newsForm.setNews(new News());
        request.setAttribute(NEWS_ATTRIBUTE,news);
        return mapping.findForward(SHOW_FORWARD);
    }
}
