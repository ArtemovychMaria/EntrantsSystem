<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Add statement</title>
    <link href="css/app.css" rel="stylesheet" type="text/css">

</head>
<body>

<jsp:include page="header.jsp"/>

<form class="wrap" style="height: 570px" action="/addStatement" onsubmit=" return validateForm()" method="post">

    <h3>Add statement</h3>

    <div class="group">
        <input type="hidden" id="id" name="facultyId" value="${faculty.id}">
    </div>

    <div class="group">
        <h4>${faculty.name}</h4>
    </div>
    
    <div class="group">
        <label for="subjectGrade1">${subject1.name}</label>
        <input type="number" id="subjectGrade1" class="form-control" name="subjectGrade1" placeholder="Enter your grade">
        <span id="sg1"></span>
    </div>

    <div class="group">
        <label for="subjectGrade2">${subject2.name}</label>
        <input type="number" id="subjectGrade2" class="form-control" name="subjectGrade2" placeholder="Enter your grade">
        <span id="sg2"></span>
    </div>

    <div class="group">
        <label for="subjectGrade3">${subject3.name}</label>
        <input type="number" id="subjectGrade3" class="form-control" name="subjectGrade3" placeholder="Enter your grade">
        <span id="sg3"></span>
    </div>

    <div class="group">
        <label for="certificateGrade">Grade of Certificate</label>
        <input type="number" id="certificateGrade" class="form-control" name="certificateGrade" placeholder="Enter your grade">
        <span id="cgrade"></span>
    </div>

    <div class="group">
        <input type="submit" value="Apply" class="form-control">
    </div>
    <div>
        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
    </div>

</form>



<jsp:include page="footer.jsp"/>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

<script src="js/addStatement.js"></script>

</body>
</html>