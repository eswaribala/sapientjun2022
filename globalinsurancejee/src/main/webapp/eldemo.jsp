<%--
  Created by IntelliJ IDEA.
  User: Balasubramaniam
  Date: 19/07/2022
  Time: 09:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='f'%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/functions' prefix='fn'%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/sql' prefix='sql'%>
<sql:setDataSource var="dataSource" driver="org.postgresql.Driver"
                   url="jdbc:postgresql://localhost:5432/globalinsdb" user="postgres" password="vignesh" />
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="policy" class="com.sapient.globalinsurancejee.models.Policy" scope="session"/>
    <%--<jsp:getProperty name="policy" property="policyNo"/>
    <jsp:getProperty name="policy" property="policyName"/>

    <jsp:getProperty name="policy" property="sumInsured"/>
--%>
<!--Expression Language -->

<br>
PolicyNo:  ${policy.policyNo}
<br>
Policy Name: ${policy.policyName}
<br>
Sum Insured: ${policy.sumInsured}

<c:set var="vehicleNo" value="TN-32-5437" />
<c:set var="color" value="blue" />
<h4>Vehicle No:
<c:out value="${vehicleNo}"></c:out>
</h4>
<h4>Vehicle Color:
    <c:out value="${color}"></c:out>
</h4>

<c:if test="${fn:containsIgnoreCase(vehicleNo,'TN-32' )}">
    <p>Found the Vehicle</p>
</c:if>



<sql:query var="policies" dataSource="${dataSource}">
    select* from admin."Policy";
</sql:query>
<table>
    <c:forEach var="row" items="${policies.rows}">
        <tr>
            <td><c:out value="${row.policy_no}" /></td>
            <td><c:out value="${row.name}" /></td>


        </tr>
    </c:forEach>
</table>


</body>
</html>
