<%@ page isELIgnored="false"%>
<%@page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:choose>
	<c:when test="${!empty empList}">
		<h1 style="color: green; text-align: center">Employee Details</h1>
		<table bgcolor="yellow" border="1" align="center">
			<tr>
				<th>Employee Id</th>
				<th>Employee Name</th>
				<th>Job Profile</th>
				<th>Salary</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="emp" items="${empList}">
			<tr >
				<td>${emp.empNo}</td>
				<td>${emp.empName}</td>
				<td>${emp.job}</td>
				<td>${emp.sal}</td>
				<td><a href="editEmp?no=${emp.empNo}"><img src="images/edit.jpg" width="30px" height="30px"></a>
					<a href="deleteEmp?empNo=${emp.empNo}" 
							onclick="return confirm('do you want to delete Employee details  with Id ${emp.empNo}')">
								<img src="images/delete.png" width="30px" height="30px"></a></td>
			</tr>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
	<h2 style="color: green; text-align: center">Employee not found</h2>
	</c:otherwise>
</c:choose>
<br/>
<h2 style="color: green; text-align: center">${resultMsg}</h2>
<br/><br/>
<h2><a href="register"><img src="images/add.jpg" height="40px" width="40px">Register new Employee</a></h2>
<h2><a href="./"><img src="images/home.png" height="40px" width="40px">Home</a></h2>

