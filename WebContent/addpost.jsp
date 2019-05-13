<%@page import="dao.PostDao"%>  
<jsp:useBean id="u" class="bean.Post"></jsp:useBean>  
<jsp:setProperty property="*" name="u"/>  
  
<%  
PostDao.save(u);
response.sendRedirect("index.jsp");
%>  