<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<div class="menu container">
    <div class="col-sm-12 menu-title text-center">News</div>
    <div class="col-sm-2"></div>
    <div class="col-sm-9 menu_list">
        <html:link href="/news.do?method=allNews"> News List</html:link><br/>
        <html:link href="/news.do?method=addNews"> Add News</html:link>
    </div>
    <div class="col-sm-1"></div>
</div>
