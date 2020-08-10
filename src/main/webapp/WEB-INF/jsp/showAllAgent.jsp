<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
        
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="3" with="60" cellpadding="2">
<tr>
<th>Agent Id</th>
<th>Name</th>
<th>City</th>
<th>Gender</th>
<th>MaritalStatus</th>
<th>Preminum</th>
<th>Edit</th>
<th>Delete</th>
</tr>

	<c:forEach var="agent" items="${list}">
				<tr>
			<td>
				${agent.agentId}
			</td>
			<td>
				${agent.name}
			</td>
			<td>
				${agent.city}
			</td>
			<td>
				${agent.gender}
			</td>
			<td>
				${eagent.maritalstatus}
			</td>
			<td>
				${agent.premium}
			</td>
			 <td><a href="editagent/${agent.agentId}">Edit</a></td>
    <td><a href="deleteagent/${agent.agentId}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="addagent">Add New Employee</a>


</table>

</body>
</html>