<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" %>
<html>
    <head>
        <title>Spitter</title>
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" >
    </head>

    <body>
        <h1>Register</h1>

        <%--<form method="POST">--%>
            <%--Full Name: <input type="text" name="fullName" /><br/>--%>
            <%--Email: <input type="email" name="email" /><br/>--%>
            <%--Username: <input type="text" name="username" /><br/>--%>
            <%--Password: <input type="password" name="password" /><br/>--%>
            <%--<input type="submit" value="Register" />--%>
        <%--</form>--%>

        <%--<sf:form method="POST" commandName="customer">--%>
            <%--Full Name: <sf:input path="fullName" type="text"/>--%>
                <%--<sf:errors path="fullName" element="span" cssClass="error" /><br/>--%>
            <%--Email: <sf:input path="email" type="email"/>--%>
                <%--<sf:errors path="email" element="span" cssClass="error" /> <br/>--%>
            <%--Username: <sf:input path="username" type="text"/>--%>
                <%--<sf:errors path="username" element="span" cssClass="error" /><br/>--%>
            <%--Password: <sf:input path="password" type="password"/>--%>
                <%--<sf:errors path="password" element="span" cssClass="error" /><br/>--%>
            <%--<input type="submit" value="Register" />--%>
        <%--</sf:form>--%>

        <sf:form method="POST" commandName="customer">
            <sf:errors path="*" element="div" cssClass="errors"/>
            <sf:label path="fullName" cssClass="title" cssErrorClass="error">Full Name</sf:label>
                <sf:input path="fullName" type="text" cssErrorClass="error" /><br/>
            <sf:label path="username" cssErrorClass="error">User Name</sf:label>
                <sf:input path="username" type="text" cssErrorClass="error" /><br/>
            <sf:label path="password" cssErrorClass="error">Password</sf:label>
                <sf:input path="password" type="password" cssErrorClass="error" /><br/>
            <sf:label path="email" cssErrorClass="error">Email</sf:label>
                <sf:input path="email" type="email" cssErrorClass="error" /><br/>
            <input type="submit" value="Register" />
        </sf:form>
    </body>
</html>
