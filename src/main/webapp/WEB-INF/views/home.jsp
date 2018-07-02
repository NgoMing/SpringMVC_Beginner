<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Spitter</title>
    <link rel="stylesheet"
          type="text/css"
          href="<c:url value="/resources/style.css" />" >
</head>
<body>
    <h1>Welcome to Login Page</h1>

    <a href="<c:url value="/customer/register" />">Register</a>
</body>
</html>
