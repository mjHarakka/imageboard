<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Add New Post</h1>  
<form action="uploadServlet" method="post" enctype="multipart/form-data">  
<table>  
<tr><td>Topic:</td><td><input type="text" name="topic"/></td></tr>  
<tr><td>Content:</td><td>

<textarea rows="5" cols="50" name="content">
</textarea>

<br>
Select File:<input type="file" name="fname"/><br/>  
  
<tr><td colspan="2"><input type="submit" value="Publish post"/></td></tr>  
</table>  
</form>

</body>
</html>