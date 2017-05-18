<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>

<logic:iterate id="news" property="allNews" name="newsForm">
    <html:link action="/news.do?method=show&id=${news.id}">${news.date}</html:link>
    <html:link action="/news.do?method=edit&id=${news.id}">edit</html:link>
    Delete
    <br/>
</logic:iterate>