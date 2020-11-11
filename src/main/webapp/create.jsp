<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/11/2020
  Time: 11:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
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
        <form>
            <div class="form-group">
                <label >ProName</label>
                <input type="text" name="ProName" class="form-control"   placeholder="Enter proname">
            </div>
            <div class="form-group">
                <label >ProPrice</label>
                <input type="text" name="ProPrice" class="form-control" placeholder="Enter price">
            </div>
            <div class="form-group">
                <label >ProQuantity</label>
                <input type="text" name="ProQuantity" class="form-control"  placeholder="Enter quantity">
            </div>
            <div class="form-group">
                <label >ProColor</label>
                <input type="text" name="ProColor" class="form-control"  placeholder="Enter color">
            </div>
            <div class="form-group">
                <label >ProDes</label>
                <input type="text" name="ProDes" class="form-control"   placeholder="Enter description">
            </div>
            <div class="form-group">
                <label >CategoryName</label>
                <input type="text" name="Category" class="form-control"  placeholder="Enter category">
            </div>


            <button type="submit" class="btn btn-primary">Create</button>
        </form>
    </div>
</body>
</html>
