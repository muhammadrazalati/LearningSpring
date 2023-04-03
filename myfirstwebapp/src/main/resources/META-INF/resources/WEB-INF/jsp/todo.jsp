<%@ include file ="common/header.jspf" %>

<%@ include file ="common/navigation.jspf" %>
	
	<div class="container">
		<h1>Enter Todos Details</h1>

		<form:form method="post" modelAttribute="todo">
			<fieldset class="mb-3">
				<!-- all three below belong to description so binded in field as set belong to 1 field -->
				<form:label path="description">Description</form:label>
				<form:input type="text" path="description" />
				<form:errors path="description" cssClass="text-warning" />
			</fieldset>

			<fieldset class="mb-3">
				<form:label path="targetDate">Target Date</form:label>
				<form:input type="text" path="targetDate" />
				<form:errors path="targetDate" cssClass="text-warning" />
			</fieldset>

			<form:input type="hidden" path="id" />

			<form:input type="hidden" path="done" />

			<input type="submit" class="btn btn-warning" />

		</form:form>
	</div>
	
	<%@ include file ="common/footer.jspf" %>
	
	<script type="text/javascript">
	$('#targetDate').datepicker({
		format : 'yyyy-mm-dd'
	})
</script>


