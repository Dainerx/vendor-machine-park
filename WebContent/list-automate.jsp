<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>Vendor machine park</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="https://www.javaguides.net" class="navbar-brand"> Automate
     Vendor machine park Management App </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Automate</a></li>
                    </ul>
                </nav>
            </header>
            <br>

            <div class="row">
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                <div class="container">
                    <h3 class="text-center">List of Automate</h3>
                    <hr>
                    <div class="container text-left">

                        <a href="<%=request.getContextPath()%>/add" class="btn btn-success">Add
     New Automate</a>
                    </div>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
         					<th>Serial Number</th>
							<th>Article Type</th>
							<th>Address</th>
							<th>Area</th>
							<th>Coordinates</th>
							<th>Last update</th>
							<th>State</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--   for (Todo todo: todos) {  -->
                            <c:forEach var="automate" items="${list}">

                                <tr>
								<td><c:out value="${automate.serialNumber}" /></td>
			                    <td><c:out value="${automate.articlesType}" /></td>
			                    <td><c:out value="${automate.address}" /></td>
			                    <td><c:out value="${automate.area}" /></td>
			                    <td><c:out value="${automate.gpsCoordinates}" /></td>
			                    <td><c:out value="${automate.lastUpdate}" /></td>
			                    <td><c:out value="${automate.stateAutomate}" /></td>					                    
                                    <td><a href="edit?serial_number=<c:out value='${automate.serialNumber}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; 
                                    <a href="delete?serial_number=<c:out value='${automate.serialNumber}' />">Delete</a></td>
                                </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                </div>
            </div>
        </body>

        </html>