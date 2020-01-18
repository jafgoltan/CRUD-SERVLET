<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: amirs
  Date: 11/20/2019
  Time: 6:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Person Panel</title>
    <link rel="stylesheet" href="/assets/bootstrap.min.css">
    <script src="/assets/jquery.min.js"></script>
    <script src="/assets/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="/menu.jsp"/>
<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading">Person Panel</div>
        <div class="panel-body">
            <form action="/person/save.do">
                <input type="text" placeholder="name" class="form-control" name="name"/>
                <br/>
                <input type="text" placeholder="family" class="form-control" name="family"/>
                <br/>
                <input type="submit" class="btn btn-info" value="SAVE"/>
            </form>

            <table style="width: 100%" class="table table-hover">
                <thead>
                <tr>
                    <td>ID</td>
                    <td>NAME</td>
                    <td>FAMILY</td>
                    <td></td>
                    <td></td>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${requestScope.list}" var="person">
                    <tr>
                        <form action="/person/update.do">
                            <td><input readonly class="form-control" type="text" name="id" value="${person.id}"/></td>
                            <td><input type="text" class="form-control" name="name" value="${person.name}"/></td>
                            <td><input type="text" class="form-control" name="family" value="${person.family}"/></td>
                            <td><input type="submit" class="btn btn-info" value="UPDATE"/></td>
                            <td><input type="button" class="btn btn-danger" value="DELETE"
                                       onclick="removePerson(${person.id})"/></td>
                        </form>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script>
    function removePerson(id) {
        if (confirm('r u sure?'))
            window.location = "/person/remove.do?id=" + id;
    }
</script>
</body>
</html>
