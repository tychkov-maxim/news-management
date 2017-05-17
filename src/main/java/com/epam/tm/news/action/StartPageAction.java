package com.epam.tm.news.action;

import com.epam.tm.news.dao.NewsDao;
import com.epam.tm.news.entity.News;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class StartPageAction extends Action {

    @Autowired
    private NewsDao newsDao;

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {


        List<News> allNewsOrderByDate = newsDao.getAllNewsOrderByDate();

        request.setAttribute("string", allNewsOrderByDate);

        return mapping.findForward("startPage");
    }
}
