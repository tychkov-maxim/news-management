package com.epam.tm.news.action;

import org.apache.struts.Globals;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class LocaleAction extends Action{
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String region = request.getParameter("lang");

        Locale locale = new Locale(region);
        request.getSession().setAttribute(Globals.LOCALE_KEY, locale);

        return mapping.findForward("allNewsRedirect");
    }
}
