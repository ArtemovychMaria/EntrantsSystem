<!doctype html>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <!-- Required meta tags -->
<%--    <meta charset="utf-8">--%>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Home</title>
    <link href="css/header.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="mySidenav" class="sidenav">
        <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
    <security:authorize access="hasRole('ROLE_ADMIN')">
        <a href="/new">Add new faculty</a>
    </security:authorize>
    <security:authorize access="hasRole('ROLE_ADMIN')">
        <a href="/applications">Confirming applications</a>
    </security:authorize>
    <security:authorize access="hasRole('ROLE_ADMIN')">
        <a href="/newSubject">Add new subject</a>
    </security:authorize>
        <a href="/allFaculties">Faculties</a>
    <security:authorize access="hasRole('ROLE_USER')">
        <a href="/cabinet">Cabinet</a>
    </security:authorize>
    </div>


<div class="topnav">
    <!-- Use any element to open the sidenav -->
        <span onclick="openNav()">Menu</span>

    <div class="mr-2">
        <select id="locates">
            <option value="en">En</option>
            <option value="ua">Ua</option>
        </select>
    </div>

    <security:authorize access="isAuthenticated()">
        <security:authentication property="principal.username" />
        <form action="/logout" method="post">
            <input type="submit" class="btn btn-outline-success ml-2 my-2 my-sm-0" value="Log Out"/>
            <input type="hidden" name="${_csrf.parameterName}"
                   value="${_csrf.token}"/>
        </form>
    </security:authorize>


    <security:authorize access="!isAuthenticated()">
        <div class="now_group">
        <a href="/login">Log In</a>
        <a href="/registration">Sign Up</a>
        </div>
    </security:authorize>


</div>



<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

<script src="js/header.js"></script>
<script src="/js/lang.js"></script>

</body>
</html>