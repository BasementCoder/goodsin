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
		<input type="submit" value = "Search">   <input type="submit" value = "Add Goods">   <input type="submit" value = "Edit Goods Details">   <input type="submit" value = "Show All Goods">   <input type="submit" value = "Remove Goods">
	</form>
   <br>


   </table>



</body>
</html>