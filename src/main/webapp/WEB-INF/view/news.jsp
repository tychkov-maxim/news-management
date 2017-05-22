<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>


<tiles:insert page="tiles/layout.jsp" flush="true">
    <tiles:put name="title" value="All news" />
    <tiles:put name="header" value="header.jsp" />
    <tiles:put name="menu" value="menu.jsp" />
    <tiles:put name="body" value="news-info-body.jsp" />
    <tiles:put name="footer" value="footer.jsp" />
</tiles:insert>