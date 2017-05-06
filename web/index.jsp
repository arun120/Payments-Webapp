<%-- 
    Document   : index
    Created on : 24 Jan, 2017, 7:24:38 PM
    Author     : Home
--%>

<%@page import="Database.Transaction"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Transfer Amount</title>
    </head>
    <body>
        <%
        for(Transaction t:Transaction.getAll()){
        if(t.getStatus().equals("New")){
        %>
       <br>
        Transfer <%=t.getAmount() %> from <%=t.getNumber() %> to <%=t.getAcc() %> IFSC(<%=t.getIfsc() %>)
        <br>
        <%
        }}
        %>
    </body>
</html>
