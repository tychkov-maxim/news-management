<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>


<table>
    <tr>
        <td style="width: 20%"><bean:message key="add.news.label.title"/></td>
        <td style="width: 80%">${news.title}</td>
    </tr>
    <tr>
        <td><bean:message key="news.date"/></td>
        <td><bean:write name="news" property="date" format="MM/dd/yyyy"/></td>
    </tr>
    <tr>
        <td><bean:message key="add.news.label.brief"/></td>
        <td>${news.brief}</td>
    </tr>
    <tr>
        <td><bean:message key="add.news.label.content"/></td>
        <td>${news.content}</td>
    </tr>
    <tr>
        <td>
        </td>
        <td>
            <html:link action="/news?method=edit&id=${news.id}">
                <html:submit><bean:message key="edit"/></html:submit>
            </html:link>
            <html:link action="/news?method=delete&id=${news.id}">
                <html:submit><bean:message key="delete"/></html:submit>
            </html:link>
        </td>
    </tr>
</table>




