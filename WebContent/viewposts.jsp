<!DOCTYPE html>  
  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>View Posts</title>  
</head>  
<body>  
  
<%@page import="dao.PostDao, dao.CommentDao, bean.* , java.util.*"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
  
<h1>Posts</h1>  
  
<%  
List<Post> list = PostDao.getAllPosts();  
request.setAttribute("list", list);

%>


<c:forEach items = "${list}" var="item">



<div class="ui card">
  <div class="image">
    <img src="${pageContext.request.contextPath}/images/${item.getId()}">
  </div>
  <div class="content">
    <a class="header">${item.getTopic()}</a>
    <div class="meta">
      <span class="date">Posted in 2009</span>
    </div>
    <div class="content">
    <p>${item.getContent()}</p>
    </div>
  </div>
  <div class="extra content">
    <div class="ui large transparent left icon input">
      

		<form action="Post/20" method="post">  
			<input type="text" name="commentContent" placeholder="Add Comment...">
			<button type="submit"class="ui icon button">
		  		<i class="comment icon"></i>
			</button>
		</form>  
      
      
      
		
    </div>
  </div>


<%
int id = 22;
List<Comment> comments = CommentDao.getAllComments(id);
request.setAttribute("comments", comments);  
%>

<c:forEach items = "${comments}" var="comment">
	<div class="ui comments">
	  <h3 class="ui dividing header">Comments</h3>
	  <div class="comment">
	    
	    <div class="content">
	      <a class="author">Anonymous</a>
	      <div class="metadata">
	        <span class="date">Today at 5:42PM</span>
	      </div>
	      <div class="text">
	        ${comment.getContent()} 
	      </div>
	      <div class="actions">
	        <a class="reply">Reply</a>
	      </div>
	    </div>
	  </div>
	</div>
</c:forEach>
  
</div>

</c:forEach>


 
  
</body>  
</html>  