<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/11/2020
  Time: 12:22 PM
  To change this template use File | Settings | File Templates.
--%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
      integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <form method="post" action="/edit">

            <input type="text" name="id" value="${product.getProID()}" hidden>
        <div class="form-group">
            <label >ProName</label>
            <input type="text" value="${product.getProName()}" name="ProName" class="form-control"   placeholder="Enter proname">
        </div>
        <div class="form-group">
            <label >ProPrice</label>
            <input type="text" value="${product.getProPrice()}" name="ProPrice" class="form-control" placeholder="Enter price">
        </div>
        <div class="form-group">
            <label >ProQuantity</label>
            <input type="text" value="${product.getProQuantity()}" name="ProQuantity" class="form-control"  placeholder="Enter quantity">
        </div>
        <div class="form-group">
            <label >ProColor</label>
            <input type="text" value="${product.getProColor()}" name="ProColor" class="form-control"  placeholder="Enter color">
        </div>
        <div class="form-group">
            <label >ProDes</label>
            <input type="text" value="${product.getProDes()}" name="ProDes" class="form-control"   placeholder="Enter description">
        </div>
        <div class="form-group">
            <label >CategoryName</label>
            <input type="text" value="${product.getCategoryName()}" name="Category" class="form-control"  placeholder="Enter category">
        </div>
        <div>
            <input type="submit" class="btn btn-primary">SAVE</input>
        </div>


    </form>
</div>
</body>
</html>
