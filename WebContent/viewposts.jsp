<!DOCTYPE html>  
  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>View Posts</title>  
</head>  
<body>  
  
<%@page import="dao.PostDao,bean.*,java.util.*"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
  
<h1>Posts</h1>  
  
<%  
List<Post> list = PostDao.getAllPosts();  
request.setAttribute("list", list);  
%>

<c:forEach items = "${list}" var="item">
<div class="ui card">
	<div class="content">
    	<div class="header">${item.getTopic()}</div>
 	</div>
 	<div class="content">
    <img src="${pageContext.request.contextPath}/images/${item.getId()}">
    </div>
    <div class="content">
    <p>${item.getContent()}</p>
    </div>
    <br>
</div> 
</c:forEach>
 
  
</body>  
</html>  