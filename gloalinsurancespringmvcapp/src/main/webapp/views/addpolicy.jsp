<%--
  Created by IntelliJ IDEA.
  User: Balasubramaniam
  Date: 20/07/2022
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add policy</title>
    <link type="text/css" rel="stylesheet" href="../gloalinsurancespringmvcapp_war_exploded/styles/addpolicy.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<form >
    <fieldset>
        <legend class="multicolortext">
            Add Policy
        </legend>
        <input type="number" name="policyNo" placeholder="Policy No" required>
        <input type="text" name="policyName" placeholder="Policy Name" required>
        <input type="date" name="fromDate" placeholder="From Date" required>
        <input type="date" name="toDate" placeholder="To Date" required>
        <input type="number" name="sumInsured" placeholder="SumInsured" required>
        <input type="submit" value="Submit">
    </fieldset>

</form>
</body>
</html>
