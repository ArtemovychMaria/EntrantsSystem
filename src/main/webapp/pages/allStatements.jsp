<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Statements</title>

</head>
<body>

<jsp:include page="header.jsp"/>

<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Name</th>
        <th scope="col">Last name</th>
        <th scope="col">Summary subjects grade</th>
        <th scope="col">Certificate grade</th>
        <th scope="col">Final Grade</th>
        <th scope="col">Accepted</th>
    </tr>
    </thead>
    <tbody>
<%--    <%--%>
<%--        int i=0;--%>
<%--    %>--%>
    <c:forEach var="statement" items="${statements}" varStatus="loop">
    <tr>
        <c:set var="rating" value="${loop.index + 1}"/>
        <th scope="row">${rating}</th>
        <td>${statement.user.firstName}</td>
        <td>${statement.user.lastName}</td>
        <td>${statement.summarySubjectsGrade}</td>
        <td>${statement.averageGradeOfCertificate}</td>
        <td>${statement.finalGrade}</td>
        <c:set var="budgetSeats" value="${statement.faculty.budgetPlan}"/>
        <c:set var="commercialSeats" value="${statement.faculty.commercialPlan}"/>
        <c:choose>
            <c:when test="${rating<=budgetSeats}">
                <td>+</td>
            </c:when>
            <c:when test="${rating>budgetSeats && rating<=(budgetSeats+commercialSeats)}">
                <td>$</td>
            </c:when>
            <c:when test="${rating>(budgetSeats+commercialSeats)}">
                <td>-</td>
            </c:when>
        </c:choose>
    </tr>
    </c:forEach>
    </tbody>
</table>


<jsp:include page="footer.jsp"/>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>


</body>
</html>