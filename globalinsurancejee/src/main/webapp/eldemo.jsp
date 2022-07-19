<%--
  Created by IntelliJ IDEA.
  User: Balasubramaniam
  Date: 19/07/2022
  Time: 09:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="s" uri="http://java.sun.com/jstl/sql"%>
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

</body>
</html>
