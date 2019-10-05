<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title> Goods In </title>
</head>
<body>
<center><strong>Goods In, Connecting people...</strong></center>

<center> ${result} </center>
<br>

Software is rented by  <strong>Half Done Industries</strong> <br>

<br>
<form action="goodsInPage" >

    <table style="with: 50%" >
        <tr>
            <td>PO:</td>
            <td><input type="text" name="po"></td>
        </tr>
        <tr>
            <td>WO:</td>
            <td><input type="text" name="wo"></td>
        <tr/>
        <tr>
            <td>SO:</td>
            <td><input type="text" name="so"></td>
        <tr/>
        <tr>
            <td>Customer:</td>
            <td><input type="text" name="customer"></td>
        <tr/>
        <tr>
            <td>Title:</td>
            <td><input type="text" name="title"></td>
        <tr/>
        <tr>
            <td>Location by barcode:</td>
        <tr/>
        <tr>
            <td>Ile  -  Shelf  -  SPosition</td>
        <tr/>
        <tr>
            <td><input type="text" name="ile" style="width:40px;">-<input type="text" name="shelf" style="width:40px;">-<input type="text" name="sposition" style="width:40px;"></td>
        <tr/>

    </table>
    <input type="submit" name = "search" value = "Search">
    <input type="submit" name="addGoods" value = "Add Goods">
    <input type="submit" value = "Edit Goods Details">
    <input type="submit" value = "Remove Goods">
</form>
<br>
</table>

<c:if test="${!empty goodsList}">
    <table>
        <tr>
            <th>Title</th>
            <th>PO</th>
            <th>WO</th>
            <th>SO</th>
            <th>Customer</th>
            <th>Comment</th>
            <th>Rack</th>
            <th>Shelf</th>
            <th>Shelf Position</th>
            <th>Barcode Nr</th>
            <th>In Date</th>
            <th>Out Date</th>
        </tr>

        <c:forEach items="${goodsList}" var="goods">
            <tr>
                <td><c:out value="${goods.po}"/></td>
                <td><c:out value="${goods.wo}"/></td>
                <td><c:out value="${goods.so}"/></td>
            </tr>
        </c:forEach>
    </table>
</c:if>





</body>
</html>