<%--
  Created by IntelliJ IDEA.
  User: Balasubramaniam
  Date: 18/07/2022
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="com.sapient.globalinsurancejee.models.Policy" errorPage="error.jsp" %>
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="styles/theatre.css"/>
</head>
<body>
<%@ include file="header.jsp"%>
<jsp:useBean id="policy" class="com.sapient.globalinsurancejee.models.Policy" scope="session">
    <jsp:setProperty name="policy" property="policyNo" value="2467286"></jsp:setProperty>
    <jsp:setProperty name="policy" property="policyName" value="Vehicle"></jsp:setProperty>

    <jsp:setProperty name="policy" property="sumInsured" value="4353556"></jsp:setProperty>
</jsp:useBean>
<a href="eldemo.jsp">Bean Access</a>


<%--Learning JSP..... --%>
<h1 >Welcome to Express Escape</h1>
<!--Declaring variables -->
<%!
 int count=0;
 Policy policy=new Policy();

%>

<div id="screen">
    <%out.print("<h1>Number of people Visited the page");%>
    <%= count++%>
    <% out.println("</h4>");%>
    <img src="images/screen1.jpg" left="50"/>
</div>
<%
policy.setPolicyNo(4856784L);
int result= (int) (policy.getPolicyNo()/count);
%>

<form  name="f1"   method="post" action="">
    <table>
        <%
            int k=1;
            for(int i=0;i<25;i++)
            {
        %>

        <tr>
            <%
                for(int j=0;j<25;j++)
                {
            %>
            <td><input type="button" name="b<%=k %>" value="<%=k %>"  style="background-color:green; color:white;" onclick="this.style.color='white'; this.style.backgroundColor = 'Red';this.disabled='true' ;test(this.value);" /></td>
            <td>
                <input type="hidden" name="hiddenvalue">
                </input>

            </td>
            <%
                    k=k+1;
                }
            %>
        </tr>

        <%
            }

        %>

        <tr>

            <td>
                <input type="submit" value="submit"/>
            </td>

        </tr>
    </table>

</form>



</body>
</html>
