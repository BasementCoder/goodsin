<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<body>

${message}
<br>
<form action="login" method="post" >

    <table style="with: 50%" align="center">
        <tr>
            <td>Username:</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password"></td>
        <tr/>
    </table>
    <center><input type="submit"></center>
</form>
<br>
<br>
<br>


</body>
</html>
