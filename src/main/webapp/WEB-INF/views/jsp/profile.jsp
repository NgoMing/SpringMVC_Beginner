<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<h1>Your Profile</h1>
<c:out value="${customer.username}" /><br/>
<c:out value="${customer.fullName}" /><br/>
<c:out value="${customer.email}" />
