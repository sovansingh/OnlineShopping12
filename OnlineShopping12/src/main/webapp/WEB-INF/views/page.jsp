<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/resources/css" var="css" />
<spring:url value="/resources/js" var="js" />
<spring:url value="/resources/images" var="images" />

<c:set value="${pageContext.request.contextPath }" var="contextRoot" />



<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Shopping - ${title }</title>

<script>
	window.menu = '${title }';
	window.contextRoot = '${contextRoot}';
</script>

<!-- Bootstrap core CSS -->
<link href="${css }/bootstrap.css" rel="stylesheet">

<!-- Bootstrap readable theme -->
<link href="${css }/bootstrap-readable-theme.css" rel="stylesheet">

<!-- Bootstrap DataTables -->
<link href="${css }/dataTables.bootstrap.css" rel="stylesheet">


<!-- Add custom CSS here -->
<link href="${css }/myapp.css" rel="stylesheet">

</head>

<body>
	<div class="wrapper">

		<!-- Navigation Section -->
		<%@include file="./shared/navbar.jsp"%>

		<div class="content">
			<!--Page Content-->
			<!-- Loading the home content -->
			<c:if test="${userClickHome == true }">
				<%@include file="home.jsp"%>
			</c:if>

			<!-- Load only when user click about -->
			<c:if test="${userClickAbout == true }">
				<%@include file="about.jsp"%>
			</c:if>
			<!-- Load only when user click contact -->
			<c:if test="${userClickContact == true }">
				<%@include file="contact.jsp"%>
			</c:if>
			
			<!-- Load only when user click listProducts -->
			<c:if test="${userClickAllProducts == true or userClickCategoryProducts == true}">
				<%@include file="listProducts.jsp"%>
			</c:if>
			
			<!-- Load only when user click show products -->
			<c:if test="${userClickShowProduct == true }">
				<%@include file="singleProduct.jsp"%>
			</c:if>
			<!-- /.container -->
		</div>
		`
		<!-- Footer Section -->
		<%@include file="./shared/footer.jsp"%>
		<!-- /.container -->

		<!-- JQuery -->
		<script src="${js }/jquery-1.10.2.js"></script>
		
		<!-- BootStrap core javaScript -->
		<script src="${js }/bootstrap.js"></script>
		
		
		<!-- DataTable Plugin -->
		<script src="${js }/jquery.dataTables.js"></script>

		<!-- DataTable bootStrap script -->
		<script src="${js }/dataTables.bootstrap.js"></script>


		<!-- Self coded javascript -->
		<script type="${js }/myapp.js"></script>
	</div>
</body>

</html>

