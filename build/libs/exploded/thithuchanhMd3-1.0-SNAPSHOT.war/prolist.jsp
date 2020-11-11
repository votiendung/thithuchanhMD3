<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/11/2020
  Time: 10:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--proName,proPrice,proQuantity,proColor,proDes,categoryName--%>

<div class="container">
    <div class="row">
        <div class="col-lg-11"></div>
        <div class="col-lg-1"><a href="/create" style="float: left; margin-right: 70px"><div class="col-lg-1"><button type="button" class="btn btn-primary">AddnewPro</button></div>
        </a></div>
    </div>

    <form action="/product">
        <table class="table">
            <thead>
            <tr>
                <%--            <th scope="col">#</th>--%>
                <th scope="col">ProName</th>
                <th scope="col">proPrice</th>
                <th scope="col">proQuantity</th>
                <th scope="col">proColor</th>
                <th scope="col">proDes</th>
                <th scope="col">categoryName</th>
                <th>EditPro</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${requestScope['listPro']}" var="pro" >
                <tr>
                        <%--                <th scope="row">1</th>--%>
                    <td>${pro.getProName()}</td>
                    <td>${pro.getProPrice()}</td>
                    <td>${pro.getProQuantity()}</td>
                    <td>${pro.getProColor()}</td>
                    <td>${pro.getProDes()}</td>
                    <td>${pro.getCategoryName()}</td>
                    <td>


                            <a href="/edit" style="float: left; margin-right: 70px"><div class="col-lg-1">
                                <button type="button" class="btn btn-primary">edit</button></div>
                            </a>
                         <a href="/delete" style="float: left; margin-right: 70px"><div class="col-lg-1">
                                <button type="button" class="btn btn-primary">delete</button></div>
                            </a>


                    </td>

                </tr>
            </c:forEach>

            </tbody>

        </table>
    </form>
</div>
</body>
</html>
