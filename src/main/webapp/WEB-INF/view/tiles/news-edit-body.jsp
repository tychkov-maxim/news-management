<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>

<html:form action="/addNews.do">
    <html:errors/>
    <html:hidden property="selectedNewsId" value="pass_validation"/>
<table>
    <html:hidden name="newsForm" property="news.id"/>
    <tr>
        <td style="width: 20%"><bean:message key="add.news.label.title"/> </td>
        <td style="width: 80%"><html:text name="newsForm" property="news.title"/> </td>
    </tr>
    <tr>
        <td><bean:message key="news.date"/> </td>
        <td><html:text property="dateString" name="newsForm" disabled="true"/></td>
    </tr>
    <tr>
        <td><bean:message key="add.news.label.brief"/></td>
        <td><html:textarea name="newsForm" property="news.brief"/></td>
    </tr>
    <tr>
        <td><bean:message key="add.news.label.content"/></td>
        <td><html:textarea name="newsForm" property="news.content"/></td>
    </tr>
</table>
    <html:submit><bean:message key="save"/> </html:submit>
    <html:button property="news" onclick="javascript:history.back()">
        <bean:message key="cancel"/>
    </html:button>
</html:form>


