<%--
  Created by IntelliJ IDEA.
  User: Balasubramaniam
  Date: 18/07/2022
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 >Welcome to Express Escape</h1>

    <img src="images/screen1.jpg" left="50"/>



<form  name="f1"   method="post" action="">
    <table>
        <%
            int k=1000;
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
