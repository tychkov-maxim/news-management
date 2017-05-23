<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>

<html:form action="/news.do?method=add">
    <html:errors/>
<table>
    <tr>
        <td style="width: 20%">News Title</td>
        <td style="width: 80%"><html:text name="newsForm" property="news.title"/> </td>
    </tr>
    <tr>
        <td> News Date</td>
        <td><html:text property="dateString" name="newsForm" disabled="true"/></td>
    </tr>
    <tr>
        <td> Brief</td>
        <td><html:textarea name="newsForm" property="news.brief"/></td>
    </tr>
    <tr>
        <td> Content</td>
        <td><html:textarea name="newsForm" property="news.content"/></td>
    </tr>
</table>
    <html:submit value="Save"/>
    <html:button property="news" onclick="javascript:history.back()">
        Cancel
    </html:button>
</html:form>


