<%@page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

<h1 style="color: green; text-align: center">Employee Registration
	Page</h1>

<frm:form modelAttribute="emp">
	<table align="center" bgcolor="cyan" border="1">
		<tr>
			<td>Employee Name</td>
			<td><frm:input path="empName"/></td>
		</tr>
		<tr>
			<td>Job Profile</td>
			<td><frm:input path="job"/></td>
		</tr>
		<tr>
			<td>Salary</td>
			<td><frm:input path="sal"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="register" /></td>
			<td><input type="reset" value="cancel" /></td>
		</tr>
	</table>
</frm:form>
