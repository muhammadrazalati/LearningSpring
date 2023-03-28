
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
<link href="webjars/bootstrap/5.2.3/css/bootstrap.min.css"
	rel="stylesheet">
<title>Add Todos Page</title>
</head>


<body>
	<div class="container">
		<h1>Enter Todos Details</h1>
		
		<form:form method="post" modelAttribute="todo">
			Description: <form:input type="text" path="description"/> 
			<input type="submit" class="btn btn-warning"/>
			<form:errors path="description" cssClass="text-warning"/> 
			<form:input type="hidden" path="id"/> 
			<form:input type="hidden" path="done"/> 
		   
		</form:form>
	</div>

	<script src="webjars/bootstrap/5.2.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.4/jquery.min.js"></script>
</body>

</html>