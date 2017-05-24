<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@ taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean" %>
<div class="menu container">
    <div class="col-sm-12 menu-title text-center"><bean:message key="news"/> </div>
    <div class="col-sm-2"></div>
    <div class="col-sm-9 menu_list">
        <html:link href="/news.do?method=allNews"><bean:message key="news.list"/> </html:link><br/>
        <html:link href="/news.do?method=addNews"><bean:message key="news.add"/> </html:link>
    </div>
    <div class="col-sm-1"></div>
</div>
