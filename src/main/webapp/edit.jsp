<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/11/2020
  Time: 12:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>
    <a href="/product">List All Pro</a>
</h2>
<div class="container">
    <form>
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


        <button type="submit" class="btn btn-primary">Create</button>
    </form>
</div>
</body>
</html>
