<%@page import="bean.LoginDao"%>  
<%@page import="bean.LoginBean"%>  
<jsp:useBean id="obj" class="bean.LoginBean"/>  
  
<jsp:setProperty property="*" name="obj"/>  
  
<%  
boolean status=LoginDao.validate(obj);  
	if (status){  
		out.println("Login succesful!");
		session.setAttribute("session","TRUE");  
	}  
else  
{  
out.print("Wrong email or password");
%>  
<jsp:include page="index.jsp"></jsp:include>  
<%  
}  
%>  