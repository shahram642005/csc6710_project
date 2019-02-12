<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Registeration</title>
</head>
<body>
	<center>
        <h1>Registration</h1>
    </center>
    <div align="center">
        <c:if test="${user != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${user == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${user != null}">
                        Modify Existing User's Information
                    </c:if>
                    <c:if test="${user == null}">
                        Register New User
                    </c:if>
                </h2>
            </caption>
                <c:if test="${user != null}">
                    <input type="hidden" name="userId" value="<c:out value='${user.userId}' />" />
                </c:if>            
            <tr>
                <th>User Name </th>
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
            <tr>
                <th>First Name </th>
                <td>
                    <input type="text" name="firstName" size="5"
                            value="<c:out value='${user.firstName}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Last Name </th>
                <td>
                    <input type="text" name="lastName" size="5"
                            value="<c:out value='${user.lastName}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Email </th>
                <td>
                    <input type="text" name="email" size="5"
                            value="<c:out value='${user.email}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Gender </th>
                <td>
                    <input type="text" name="gender" size="5"
                            value="<c:out value='${user.gender}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Age </th>
                <td>
                    <input type="text" name="age" size="5"
                            value="<c:out value='${user.age}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="register" />
                </td>
            </tr>
        </table>
        </form>
    </div>
</body>
</html>