<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/resources/css" var="css" />
<spring:url value="/resources/js" var="js" />
<spring:url value="/resources/images" var="images" />

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Shopping - ${title }</title>
<style>
window.menu='${title}';
</style>
<!-- Bootstrap core CSS -->
<link href="${css }/bootstrap.css" rel="stylesheet">
<!-- BootStrap Readable Theme -->
<link href="${css }/bootstrap.min.theme.css" rel="stylesheet">

<!-- Add custom CSS here -->
<link href="${css }/myapp.css" rel="stylesheet">

</head>

<body>
	<div class="wrapper">
		<!-- Navigation -->
		<%@include file="./shared/navbar.jsp"%>

		<div class="content">
			<!-- Home Page contain -->
			<c:if test="${userClickHome == true }">
				<%@include file="home.jsp"%>
			</c:if>

			<c:if test="${userClickAbout == true }">
				<%@include file="about.jsp"%>
			</c:if>

			<c:if test="${userClickContact == true }">
				<%@include file="contact.jsp"%>
			</c:if>
			<!-- /.container -->
		</div>
		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>
		<!-- /.container -->

		<!-- JavaScript -->
		<script src="${js }/jquery-1.10.2.js"></script>
		<!-- BootStrap Core JavaScript -->
		<script src="${js }/bootstrap.js"></script>
		<!-- Self Coded javascript -->
		<script src="${js }/myapp.js"></script>
	</div>
</body>

</html>
