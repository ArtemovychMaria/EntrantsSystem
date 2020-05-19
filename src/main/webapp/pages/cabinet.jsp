<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Home</title>
    <link href="css/cabinet.css" rel="stylesheet" type="text/css">
</head>
<body>

<jsp:include page="header.jsp"/>


<div class="main">
    <div class="left">
            <img src="/user-photo-files/download/${user.photoId}">
    </div>
    <div class="right">
        <div class="userInfo">
            <table>
                <tr><td class="name"><i>${user.firstName} ${user.lastName}</i></td>
                    <td><a href="/editUser?userId=${user.id}" class="btn btn-primary">edit</a></td>
                </tr>
                <tr><td class="one">Age:</td><td class="two">${user.age}</td></tr>
                <tr><td class="one">Email:</td><td class="two">${user.email}</td></tr>
                <tr><td class="one">Gender:</td><td class="two">${user.gender}</td></tr>
            </table>
        </div>
        <div class="applications">
            <h4>My rejected applications</h4>
            <c:forEach var="statement" items="${rejectedStatements}">
                <p>You have rejected application to faculty ${statement.faculty.name}</p>
            </c:forEach>
        </div>
    </div>
</div>


<jsp:include page="footer.jsp"/>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>