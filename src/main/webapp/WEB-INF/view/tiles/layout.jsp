<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%@ taglib prefix="tiles" uri="http://jakarta.apache.org/struts/tags-tiles" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title><tiles:getAsString name="title" ignore="true"/></title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid col-sm-12 header">
    <tiles:insert attribute="header" ignore="true"/>
</div>
<div class="container-fluid">
    <div class="content">
        <div class="col-sm-2 sidenav ourmenu text-center">
            <tiles:insert attribute="menu"/>
        </div>

        <div class="col-sm-10 text-center body">
            <tiles:insert attribute="body"/>
        </div>
    </div>
</div>

<footer class="container-fluid text-center">
    <tiles:insert attribute="footer"/>
</footer>

</body>
</html>
