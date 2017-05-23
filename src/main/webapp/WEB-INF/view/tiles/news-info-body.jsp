<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>


<table>
    <tr>
        <td style="width: 20%">News Title</td>
        <td style="width: 80%"><bean:write name="newsForm" property="news.title"/></td>
    </tr>
    <tr>
        <td> News Date</td>
        <td><bean:write name="newsForm" property="news.date" format="dd/MM/yyyy"/></td>
    </tr>
    <tr>
        <td> Brief</td>
        <td><bean:write name="newsForm" property="news.brief"/></td>
    </tr>
    <tr>
        <td> Content</td>
        <td><bean:write name="newsForm" property="news.content"/></td>
    </tr>
    <tr>
        <td>
        </td>
        <td>
            <html:link action="/news?method=edit&id=${newsForm.news.id}">
                <html:submit value="edit"/>
            </html:link>
            <html:link action="/news?method=delete&id=${newsForm.news.id}">
                <html:submit value="delete"/>
            </html:link>
        </td>
    </tr>
</table>




