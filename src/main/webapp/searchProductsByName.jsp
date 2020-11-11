<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/11/2020
  Time: 1:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <h2>
        <a href="/product">List All Pro</a>
    </h2>
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
                <c:forEach items="${requestScope['listProproductCate']}" var="pro" >
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
</head>
<body>

</body>
</html>
