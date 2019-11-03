<%--<jsp:useBean id="goods" scope="request" type="com.garagonic.goodsin.repository.Goods"/>--%>
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

<br>
<center><strong>Editing Mode:</strong></center>
<br>
<form action="/${goods.id}/edit/submit" align="center" method="post" >

    <table class="main" align="center">
        <tr>
            <td><strong>PO:</strong></td>
            <td><input type="text" name="po" value=${goods.po}></td>
        </tr>
        <tr>
            <td><strong>WO:</strong></td>
            <td><input type="text" name="wo" value=${goods.wo}></td>
        <tr/>
        <tr>
            <td><strong>SO:</strong></td>
            <td><input type="text" name="so" value=${goods.so}></td>
        <tr/>
        <tr>
            <td><strong>Customer:</strong></td>
            <td><input type="text" name="customer" value=${goods.customer}></td>
        <tr/>
        <tr>
            <td><strong>Title:</strong></td>
            <td><input type="text" name="title" value=${goods.title}></td>
        <tr/>
        <tr>
            <td><strong>Location by barcode:</strong></td>
        <tr/>
        <tr>
            <td><strong>Ile  -  Shelf  -  SPosition</strong></td>
        <tr/>
        <tr>
            <td >
                <input type="text" style="width:40px;" name="rack" value ="${goods.rack}" >-
                <input type="text" style="width:40px;" name="shelf" value="${goods.shelf}" >-
                <input type="text" style="width:40px;" name="shelfPosition" value="${goods.shelfPosition}">
            </td>
        <tr/>

        <tr>
            <td><input type="submit" name = "submit" value = "Complete"></td>
            <td><input type="submit" name="cancel" value = "Cancel"></td>
        </tr>
    </table>

</form>
<br>
</table>

</body>
</html>