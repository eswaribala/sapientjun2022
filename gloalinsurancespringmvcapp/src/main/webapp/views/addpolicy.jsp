<%--
  Created by IntelliJ IDEA.
  User: Balasubramaniam
  Date: 20/07/2022
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Add policy</title>

    <link type="text/css" rel="stylesheet" href="../gloalinsurancespringmvcapp_war_exploded/styles/addpolicy.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<form:form action="policies" method="post"  modelAttribute="policy">
    <fieldset>
        <legend class="multicolortext">
            Add Policy
        </legend>
        <form:input type="number" path="policyNo" placeholder="Policy No" required="true"></form:input>
        <form:input type="text" path="policyName" placeholder="Policy Name" required="true"></form:input>
        <form:input type="date" path="fromDate" placeholder="From Date" required="true"></form:input>
        <form:input type="date" path="toDate" placeholder="To Date" required="true"></form:input>
        <form:input type="number" path="sumInsured" placeholder="SumInsured" required="true"></form:input>
        <input type="submit" value="Submit">
    </fieldset>

</form:form>
</body>
</html>
