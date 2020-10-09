<%@ page import="java.util.Map" %>
<%@ page import="rest.service.VariableBean" %>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://xmlns.jcp.org/jsf/html"
      xmlns:f="http://xmlns.jcp.org/jsf/core">
<head>


</head>
<body>






<table>
<%  Map<String,String> map = new VariableBean().getSystemVariable();
    for (Map.Entry<String, String> entry : map.entrySet()) {
%>


<tr>
    <td><%=entry.getKey()%></td>


    <td><%=entry.getValue()%></td>
</tr>
<% }; %>
</table>
</body>
</html>