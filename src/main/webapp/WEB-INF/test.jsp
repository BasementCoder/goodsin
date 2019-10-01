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
	<form action="login" >

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

<?php
$conn = jdbc:mysql://127.0.0.1:3306/test1("localhost","root", "Wq4sc283!");
if($conn -> connect_error){
die("Connection failed:".$conn-> connect_error);
}

$sql = "SELECT title,po,wo,so,customer,comment,rack,shelf,shelf_position,barcode,in_date,out_date from goods";
$result = $conn-> query($sql);

if($result-> num rows > 0){
while($row = $result-> fetch_assoc()){
   echo "<tr><td>". $row["title"] ."</td><td>". $row["po"] ."</td><td>". $row["wo"] ."</td><td>". $row["so"] ."</td><td>". $row["customer"] ."</td><td>". $row["comment"] ."</td><td>". $row["rack"] ."</td><td>". $row["shelf"] ."</td><td>". $row["shelf_position"]."</td><td>". $row[
   "barcode"] ."</td><td>". $row["in_date"] ."</td><td>". $row["out_date"] ."</td></tr>";
}
echo "</table>" ;
}else{
echo "0 result";
}

$conn-> close();

?>


   </table>



</body>
</html>