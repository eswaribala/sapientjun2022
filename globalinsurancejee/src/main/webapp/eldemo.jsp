<%--
  Created by IntelliJ IDEA.
  User: Balasubramaniam
  Date: 19/07/2022
  Time: 09:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="policy" class="com.sapient.globalinsurancejee.models.Policy" scope="session"/>
    <jsp:getProperty name="policy" property="policyNo"/>
    <jsp:getProperty name="policy" property="policyName"/>

    <jsp:getProperty name="policy" property="sumInsured"/>


</body>
</html>
