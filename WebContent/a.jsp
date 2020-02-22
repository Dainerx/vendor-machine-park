<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
 <title>User Management Application</title>
</head>
<body>

    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Users</h2></caption>
            <tr>
                <th>street number</th>
                <th>street</th>
                <th>city</th>
                <th>postCode</th>
            </tr>
            <c:forEach var="address" items="${listA}">
                <tr>
                    <td><c:out value="${address.streetNumber}" /></td>
                    <td><c:out value="${address.street}" /></td>
                    <td><c:out value="${address.city}" /></td>
                    <td><c:out value="${address.postCode}" /></td>
                </tr>
            </c:forEach>
         </table>
     </div>
     <h2> Saisie d'un Automate</h2>
     <c:forEach var="insertAutomate" items="${newAutomate}">
     	<form method="get" action="insertAutomate">
     		<input type="text" id="serialNumber" name="serialNumber" value='<c:out value="${insertAutomate.serialNumber}"/>' size="3">
     	</form>
     </c:forEach>
     </body>
     </html>