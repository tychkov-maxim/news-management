package com.epam.tm.news.action;

;import com.epam.tm.news.entity.News;
import com.epam.tm.news.form.NewsForm;
import com.epam.tm.news.service.NewsService;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.epam.tm.news.constant.ConstantHolder.*;

public class NewsListDeleteAction extends Action {


    @Autowired
    private NewsService newsService;

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        NewsForm newsForm = (NewsForm) form;
        int[] selectedNewsId = newsForm.getSelectedNewsId();
        //TODO use 8 java
        for (int i : selectedNewsId) {
            News news = new News();
            news.setId(i);
            newsService.deleteNewsById(news);
        }
        return mapping.findForward(ALL_NEWS_REDIRECT);
    }
}
