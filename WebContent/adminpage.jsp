<!DOCTYPE html>  
  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>View Posts</title>  
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.css" />
<style type = text/css> body {background-color:#ffe8c9;}</style>
</head>  
<body>  
  
<%@page import="dao.PostDao, dao.CommentDao, bean.* , java.util.*"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
  
<%  
List<Post> list = PostDao.getAllPosts();  
request.setAttribute("list", list);

%>

<div class="ui equal width grid">


<c:forEach items = "${list}" var="item">

<div class="four wide column">

<div class="ui card">
  <div class="image">
    <img src="${pageContext.request.contextPath}/images/${item.getId()}">
  </div>
  <div class="content">
    <a class="header">${item.getTopic()}</a>
    <div class="meta">
      <span class="date">Posted in: ${item.getTimestamp()}</span>
    </div>
    <div class="content">
    <p>${item.getContent()}</p>
    </div>
  </div>
  <div class="extra content">
    <div class="ui large transparent left icon input">
    
    <form action="deletepost/${item.getId()}" method="post">  
		<button class="ui negative button">
	  	Delete post	
		</button>
	</form>
    
    
    </div>
  </div>


  

<%
Post post = (Post)pageContext.getAttribute("item");
List<Comment> comments = CommentDao.getAllComments(post.getId());
request.setAttribute("comments", comments);  
%>

<div class="ui comments">
<h3 class="ui dividing header">Comments</h3>
<c:forEach items = "${comments}" var="comment">
	
	  
	  <div class="comment">
	    
	    <div class="content">
	      <a class="author">Anonymous</a>
	      <div class="metadata">
	      </div>
	      <div class="text">
	        <p>${comment.getContent()}</p> 
	      </div>
	      <div class="actions">
	      </div>
	    </div>
	    
	    <form action="deletecomment/${comment.getId()}" method="post">  
		<button class="ui yellow basic button">
	  	Delete comment	
		</button>
	</form>
	  </div>
	
</c:forEach>
</div>
  
</div>
</div>
</c:forEach>
</div>

 
  
</body>  
</html>