<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title> Goods In </title>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
</head>
<body>

<ul>
    <li style="color: #4CAF50"><strong>Goods In, Connecting people...</strong></li>
    <li style="float:right"><a href="<c:url value="/logout" />" class="logout-button">Log Out</a></li>
</ul>

<c:if test="${showErrorMessage}">
    <div class="errorMessage"><strong>Error: Please make sure that at least fields of "Customer" and "Location" is populated.</strong></div>
</c:if>

<br>
<center><strong>+Add Goods Menu</strong></center>
<br>
<form action="addGoodsPage" align="center" method="post">

    <table class="main" align="center" >
        <tr>
            <td><strong>PO:</strong></td>
            <td><input type="text" name="po" value="${addedGoods.po}"></td>
        </tr>
        <tr>
            <td><strong>WO:</strong></td>
            <td><input type="text" name="wo" value="${addedGoods.wo}"></td>
        <tr/>
        <tr>
            <td><strong>SO:</strong></td>
            <td><input type="text" name="so" value="${addedGoods.so}"></td>
        <tr/>
        <tr>
            <td><strong>Customer:</strong></td>
            <td><input type="text" name="customer" value="${addedGoods.customer}"></td>
        <tr/>
        <tr>
            <td><strong>Title:</strong></td>
            <td><input type="text" name="title" value="${addedGoods.title}"></td>
        <tr/>
        <tr>
            <td><strong>Location by barcode:</strong></td>
        <tr/>
        <tr>
            <td><strong>Ile  -  Shelf  -  SPosition</strong></td>
        <tr/>
        <tr>
            <td>
                <input type="text" style="width:40px;" name="rack" value="${addedGoods.rack}">
                -<input type="text" style="width:40px;" name="shelf" value="${addedGoods.shelf}">-
                <input type="text" style="width:40px;" name="shelfPosition" value="${addedGoods.shelfPosition}">
            </td>
        <tr/>
        <tr>
            <td><input type="submit" name="addGoods" value = "Complete"></td>
            <td><input type="submit" name = "cancel" value = "Cancel"></td>
        </tr>
    </table>



<br>
</table>
</form>

</body>
</html>