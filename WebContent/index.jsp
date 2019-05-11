<%
if (request.getAttribute("users") == null){
	response.sendRedirect("GetUsers");	
	return;
}

%>
<%@ page import="model.User"%>  
<%@ page import="java.util.ArrayList"%>  
<%! @SuppressWarnings("unchecked") %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of users</title>
</head>
<body>

<%
ArrayList<User> users = (ArrayList<User>)request.getAttribute("users");
for(int i = 0; i < users.size(); i++){
	out.println(users.get(i).getUsername() + "<br>");
}
%>

</body>
</html>