<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Login</title>
</head>
<body>
    <h1 style="text-align:center">Welcome to Jokes website!</h1>
    <div align="center">
        <form action="login" method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Please login or register!</h2>
            </caption>            
            <tr>
                <th>UserName </th>
                <td>
                    <input type="text" name="userName" size="45"
                            value="<c:out value='${user.userName}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Password </th>
                <td>
                    <input type="text" name="password" size="45"
                            value="<c:out value='${user.password}' />"
                    />
                </td>
            </tr>
        </table>
        <table cellpadding="5">
            <tr>
            	<td align="center">
                    <input type="submit" value="login" />
                </td>
                <td align="center">
                    <a href="new">register now!</a>
                </td>
            </tr>
        </table>
        </form>
    </div>
</body>
</html>