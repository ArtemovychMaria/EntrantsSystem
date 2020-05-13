<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Edit faculty</title>
    <link href="css/app.css" rel="stylesheet" type="text/css">

</head>
<body>

<jsp:include page="header.jsp"/>

<form action="/update" method="post">

    <h3>Edit faculty</h3>

    <div class="group">
    <input type="hidden" value="${faculty.id}" class="form-control" id="id" name="id">
    </div>

    <div class="group">
        <label for="name">Name:</label>
        <input class="form-control" type="text" value="${faculty.name}" id="name" name="name" placeholder="Name">
    </div>
    <div class="group">
        <label for="budgetPlan">Number of students:</label>
        <input type="number" id="budgetPlan" value="${faculty.budgetPlan}" class="form-control" name="budgetPlan" placeholder="Budget plan">
    </div>

    <div class="group">
        <label for="commercialPlan">Number of students:</label>
        <input type="number" id="commercialPlan" value="${faculty.commercialPlan}" class="form-control" name="commercialPlan" placeholder="Commercial plan">
    </div>

    <div class="group">
        <p>Required Subjects:</p>
        <ul>
            <c:forEach var="requiredSubject" items="${faculty.requiredSubjects}">
            <li>${requiredSubject.name}</li>
            </c:forEach>
        </ul>
    </div>

    <div class="group">
        <label for="subjectName1">First required subject name:</label>
        <select name="subjectName1" id="subjectName1">
            <c:forEach var="subject" items="${subjects}">
            <option value="${subject.name}">${subject.name}</option>
            </c:forEach>
        </select>
    </div>

    <div class="group">
        <label for="subjectName2">Second required subject name:</label>
        <select name="subjectName2" id="subjectName2">
            <c:forEach var="subject" items="${subjects}">
                <option value="${subject.name}">${subject.name}</option>
            </c:forEach>
        </select>
    </div>

    <div class="group">
        <label for="subjectName3">Third required subject name:</label>
        <select name="subjectName3" id="subjectName3">
            <c:forEach var="subject" items="${subjects}">
                <option value="${subject.name}">${subject.name}</option>
            </c:forEach>
        </select>
    </div>

    <div class="group">
        <input type="submit" value="Add" class="form-control">
    </div>
    <div>
        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
    </div>

</form>



<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>


</body>
</html>