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

<form name="registerForm" action="/create" onsubmit="return validateForm()" method="post">

    <h3>Sign Up</h3>
<%--    <div class="main">--%>
<%--    <div class="wraper">--%>
    <div class="group">
        <label for="username">Username:</label>
        <input class="form-control" type="text" id="username" name="username" placeholder="Username">
        <span id="fusername"></span>
    </div>
    <div class="group">
        <label for="firstName">Name:</label>
        <input class="form-control" type="text" id="firstName" name="firstName" placeholder="First name">
        <span id="ffirstName"></span>
    </div>
    <div class="group">
        <label for="lastName">Surame:</label>
    <input class="form-control" type="text" id="lastName" name="lastName" placeholder="Last name">
        <span id="flastName"></span>
    </div>
    <div class="group">
        <label for="age">Age:</label>
    <input class="form-control" type="text" id="age" name="age" placeholder="Age">
        <span id="fage"></span>
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
    <div class="group">
        <label for="email">Email:</label>
    <input type="email" id="email" class="form-control" name="email" placeholder="Email">
        <span id="femail"></span>
    </div>
    <div class="group">
        <label for="password">Password:</label>
    <input type="password" id="password" class="form-control" name="password" placeholder="Password">
        <span id="fpassword"></span>
    </div>
<%--    </div>--%>
<%--    </div>--%>

    </div><div class="group">
    <input type="submit" value="Sign Up" class="form-control">
    <div>
        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
    </div>
    </div>

</form>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

<script src="js/register.js"></script>

</body>
</html>