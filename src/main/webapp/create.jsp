<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/11/2020
  Time: 11:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
      integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>
    <a href="/product">List All Pro</a>
</h2>
<div class="container">
    <form method="post" action="/create">
        <table>
            <tr>
                <th>ProName</th>
                <td><input type="text" name="name" id="name" ></td>
            </tr>
            <tr>
                <th>ProPrice</th>
                <td><input type="text" name="price" id="price" ></td>
            </tr>
            <tr>
                <th>ProQuantity</th>
                <td><input type="text" name="quantity" id="quantity" ></td>
            </tr>
            <tr>
                <th>ProColor</th>
                <td><input type="text" name="color" id="color" ></td>

            </tr>
            <tr>
                <th>ProDes</th>
                <td><input type="text" name="des" id="des"></td>
            </tr>
            <tr>
                <th>Category</th>
                <td><input type="text" name="cateID" id="category"></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="SAVE"></td>
            </tr>


        </table>


    </form>
</div>
</body>
</html>
