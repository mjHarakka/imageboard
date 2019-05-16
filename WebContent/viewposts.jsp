<!DOCTYPE html>  
  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>View Posts</title>  
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
      

		<form action="Post/${item.getId()}" method="post">  
			<input type="text" name="commentContent" placeholder="Add Comment...">
			<button type="submit"class="ui icon button">
		  		<i class="comment icon"></i>
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
	  </div>
	
</c:forEach>
</div>
  
</div>
</div>
</c:forEach>
</div>

 
  
</body>  
</html>  