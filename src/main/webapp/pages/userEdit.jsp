<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Registration</title>

    <link href="css/app.css" rel="stylesheet" type="text/css">

</head>
<body>

<form name="registerForm" action="/updateUser" method="post">

    <h3>Sign Up</h3>

<%--    <div class="main">--%>
<%--    <div class="wraper">--%>

    <img src="/user-photo-files/download/${user.photoId}" id="user-photo"
         width="200px">
    <input type="hidden" value="${user.id}" class="form-control" id="id" name="id"/>

    <div class="group">
        <label for="photo-file">Download your photo</label>
        <input id="photo-file" type="file" />
    </div>

    <input type="hidden" value="" class="form-control" id="photo-id" name="photoId"/>

    <div class="group">
        <label for="username">Username:</label>
        <input class="form-control" type="text" value="${user.username}" id="username" name="username" placeholder="Username"/>
<%--        <form:errors path="username"/>--%>
    </div>

    <div class="group">
        <label for="firstName">Name:</label>
        <input class="form-control" type="text" value="${user.firstName}" id="firstName" name="firstName" placeholder="First name"/>
<%--        <form:errors path="firstName"/>--%>
    </div>

    <div class="group">
        <label for="lastName">Surame:</label>
    <input class="form-control" type="text" value="${user.lastName}" id="lastName" name="lastName" placeholder="Last name"/>
<%--        <form:errors path="lastName"/>--%>
    </div>

    <div class="group">
        <label for="age">Age:</label>
    <input class="form-control" type="text" value="${user.age}" id="age" name="age" placeholder="Age"/>
<%--        <form:errors path="age"/>--%>
    </div>

    <div class="group">
        <label>Gender:</label>
    <div class="form-check form-check-inline">
        <input class="form-check-input" type="radio" name="gender" id="male" value="male">
        <label class="form-check-label" for="male">male</label>
    </div>
    <div class="form-check form-check-inline">
        <input class="form-check-input" type="radio" name="gender" id="female" value="female">
        <label class="form-check-label" for="female">female</label>
    </div>
        <span id="fgender"></span>
    </div>
<%--    </div>--%>
<%--    <div class="wraper">--%>
<%--    <div class="group">--%>
<%--        <label for="email" path="email">Email:</label>--%>
<%--    <input type="email" path="email" id="email" class="form-control" name="email" placeholder="Email"/>--%>
<%--        <form:errors path="email"/>--%>
<%--    </div>--%>

<%--    <div class="group">--%>
<%--        <form:label  for="password" path="password">Password:</form:label>--%>
<%--    <form:input type="password" path="password" id="password" class="form-control" name="password" placeholder="Password"/>--%>
<%--        <form:errors path="password"/>--%>
<%--    </div>--%>
<%--    </div>--%>
<%--    </div>--%>

<%--    </div>--%>
    <div class="group">

        <div>
            <input type="hidden" name="${_csrf.parameterName}"
                   value="${_csrf.token}" id="sec-token"/>
        </div>

    <input type="submit" value="Sign Up" class="form-control">
    </div>

</form>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<%--<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>--%>
<%--<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>--%>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

<script src="js/register.js"></script>
<script src="js/userPhoto.js"></script>

</body>
</html>