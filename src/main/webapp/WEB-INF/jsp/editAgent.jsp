<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Edit Agent Details</h1>
       <form:form action="/SpringMvcAgent/agent/editsave">  
      	<table >  
      	<tr>
      	<td>Agent ID :</td>  
         <td><form:input  path="agentId" readonly="readonly" /></td>
         </tr> 
         <tr>  
          <td>Name : </td> 
          <td><form:input path="name"  /></td>
         </tr>  
         <tr>
         	<td>City :</td>
         	<td>
         		<form:input path="city"/>
         	</td>
         </tr>
         <tr>  
          <td>Gender :</td>  
          <td><form:input path="gender" /></td>
         </tr> 
         <tr>  
          <td>MaritalStatus:</td>  
          <td><form:input path="maritalStatus" /></td>
         </tr> 
         <tr>  
          <td>Premium:</td>  
          <td><form:input path="premium" /></td>
         </tr>
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Edit Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
</body>
</html>