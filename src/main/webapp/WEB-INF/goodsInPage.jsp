<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="body" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false" %>
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
    <div class="errorMessage"><strong>Error: At least one filter field has to be populated.</strong></div>
</c:if>

<br>
<form action="/" method="post">

    <table class="main" align="center">
        <tr>
            <td><strong>PO:</strong></td>
            <td><input type="text" name="po" value="${lastGoodsSearchFilter.po}"></td>
        </tr>
        <tr>
            <td><strong>WO:</strong></td>
            <td><input type="text" name="wo" value="${lastGoodsSearchFilter.wo}"></td>
        <tr/>
        <tr>
            <td><strong>SO:</strong></td>
            <td><input type="text" name="so" value="${lastGoodsSearchFilter.so}"></td>
        <tr/>
        <tr>
            <td><strong>Customer:</strong></td>
            <td><input type="text" name="customer" value="${lastGoodsSearchFilter.customer}"></td>
        <tr/>
        <tr>
            <td><strong>Title:</strong></td>
            <td><input type="text" name="title" value="${lastGoodsSearchFilter.title}"></td>
        <tr/>
        <tr>
            <td><strong>Barcode No:</strong></td>
        <tr/>
        <tr>
            <td><strong>In stock only:</strong></td>
            <td>
                <c:choose>
                <c:when test="${inStockOnly}">
                    <input type="checkbox" name="inStockOnly" checked>
                </c:when>
                <c:otherwise>
                    <input type="checkbox" name="inStockOnly">
                </c:otherwise>
                </c:choose>
            </td>
        <tr/>
        <tr>

        <tr/>
        <tr>
            <td><strong> Ile </strong>-<strong> Shelf </strong>-<strong> SPosition</strong>
                <br>
             <input type="text" name="rack" style="width:40px;" value="${lastGoodsSearchFilter.rack}">
                -<input type="text" name="shelf" style="width:40px;" value="${lastGoodsSearchFilter.shelf}">
                -<input type="text" name="shelfPosition" style="width:40px;" value="${lastGoodsSearchFilter.shelfPosition}"></td>
        <tr/>
        <tr>
            <td align="center"><input type="submit" name="search" value="Search"></td>
            <td align="center"><security:authorize access="hasRole('ROLE_ADMIN')"><input type="submit" name="addGoods" value="+Add Goods"></security:authorize> </td>
        </tr>

    </table>

</form>
<br>
</table>

<c:if test="${!empty goodsList}">
    <table border="10" align="center">
        <tr>
            <th>ID</th>
            <th>Stock Status</th>
            <th>Title</th>
            <th>PO</th>
            <th>WO</th>
            <th>SO</th>
            <th>Customer</th>
            <th>Comment</th>
            <th>Rack</th>
            <th>Shelf</th>
            <th>Shelf P.</th>
            <th>Barcode Nr</th>
            <th>In Date</th>
            <th>Out Date</th>
            <th>Settings</th>
        </tr>

        <c:forEach items="${goodsList}" var="goods">
            <tr>
                <td><c:out value="${goods.id}"/></td>
                <td><c:out value="${goods.inStock}"/></td>
                <td><c:out value="${goods.title}"/></td>
                <td><c:out value="${goods.po}"/></td>
                <td><c:out value="${goods.wo}"/></td>
                <td><c:out value="${goods.so}"/></td>
                <td><c:out value="${goods.customer}"/></td>
                <td><c:out value="${null}"/></td>
                    <%-- comment--%>
                <td><c:out value="${goods.rack}"/></td>
                <td><c:out value="${goods.shelf}"/></td>
                <td><c:out value="${goods.shelfPosition}"/></td>
                <td><c:out value="${null}"/></td>
                    <%-- Barcode Nr--%>
                <td><c:out value="${goods.inDate}"/></td>
                <td><c:out value="${goods.outDate}"/></td>
                    <%-- out date--%>
                <td>
                    <c:choose>
                        <c:when test="${goods.inStock}">
                            <security:authorize access="hasRole('ROLE_ADMIN')">
                                <a href="<c:url value='/${goods.id}/delete'/>" class="delete-button">Delete</a>
                                <a href="<c:url value='/${goods.id}/edit'/>" class="edit-button">Edit</a>
                            </security:authorize>
                        </c:when>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>