<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<jsp:directive.page contentType="text/html;charset=UTF-8"/>
<html>
<head>
    <title>Create new</title>
    <jsp:include page="includeFile.jsp"></jsp:include>
</head>
<body>
<jsp:include page="navigationBar.jsp"></jsp:include>
<form:form name="createCart" method="POST">
    <div class="container">
        <h1>Create Cart</h1>
        <div type="div-form">
            <p>Name</p>
            <p><input class = "text-form" type="text" name="cart" /></p>

            <p>Capacity</p>
            <p><input class = "text-form" type="text" name="capacity" /></p>

            <br><input class ="submit-form" type="submit" value="Submit"/>
        </div>
        <div style="color: red"><c:out value="${error}"/></div>
    </div>
</form:form>
</body>
</html>
