<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="logic" uri="http://jakarta.apache.org/struts/tags-logic" %>


<logic:notEmpty name="newsForm" property="allNews">
<html:form action="/deleteList.do">

<logic:iterate id="news" property="allNews" name="newsForm">

    <html:errors/>
    <html:hidden property="news.title" value="pass_validation"/>
    <html:hidden property="news.brief" value="pass_validation"/>
    <html:hidden property="news.content" value="pass_validation"/>

    <table id="allNews">
        <tr>
            <td style="width: 90%">${news.title}</td>
            <td style="width: 10%;"><bean:write name="news" property="date" format="dd/MM/yyyy"/></td>
        </tr>
        <tr>
            <td>
                    ${news.content}
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <html:link action="/news.do?method=show&id=${news.id}"><bean:message key="view"/></html:link>
                <html:link action="/news.do?method=edit&id=${news.id}"><bean:message key="edit"/></html:link>
                <html:multibox property="selectedNewsId" name="newsForm" value="${news.id}"/>
            </td>
        </tr>
    </table>



</logic:iterate>
    <html:submit><bean:message key="delete"/> </html:submit>
</html:form>
</logic:notEmpty>

<logic:empty name="newsForm" property="allNews">
    <bean:message key="sorry.empty"/>
</logic:empty>