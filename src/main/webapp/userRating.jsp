<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="" href="Assets/logo.png">
<title>user show all rating</title>

<link rel='stylesheet' href="assets/css/showAllRatings.css">

</head>
<body>

	<h1 class="title">Ratings</h1>

	<h3>
		<a href="userPage.jsp">Go To Home</a>
	</h3>

	<br>


	<c:forEach items="${userratings}" var="rating">

		<a></a>
		<div class="container">
			<h2 class="name">
				<c:out value="${rating.getUserName()}"></c:out>
			</h2>
			<h3>${ rating.getPackageName()}Trip</h3>

			<c:choose>
				<c:when test="${rating.getRating()==5.0}">
					<h1 class="rate">&#11088;&#11088;&#11088;&#11088;&#11088;</h1>
				</c:when>

				<c:when test="${rating.getRating()==4.0}">
					<h1 class="rate">&#11088;&#11088;&#11088;&#11088;</h1>
				</c:when>

				<c:when test="${rating.getRating()==3.0}">
					<h1 class="rate">&#11088;&#11088;&#11088;</h1>
				</c:when>

				<c:when test="${rating.getRating()==2.0}">
					<h1 class="rate">&#11088;&#11088;</h1>
				</c:when>

				<c:when test="${rating.getRating()==1.0}">
					<h1 class="rate">&#11088;</h1>
				</c:when>
			</c:choose>

			<c:if test="${rating.getDescribtion()!=null}">
				<p>${rating.getDescribtion()}</p>
			</c:if>

		</div>
		<br>
		<br>
	</c:forEach>

</body>
</html>