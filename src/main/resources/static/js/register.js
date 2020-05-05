function validateForm(){
    var username = document.getElementById("username");
    var firstName = document.getElementById("firstName");
    var lastName = document.getElementById("lastName");
    var age = document.getElementById("age");
    var gender = document.getElementById("gender");
    var email = document.getElementById("email");
    var password = document.getElementById("password");

    var at=email.value.indexOf('@');
    var dot=email.value.indexOf('.');


    if(username.value == ""){
        username.style.border="1px solid red";
    }

    if(firstName.value == ""){
        firstName.style.border="1px solid red";
    }

    if(lastName.value == ""){
        lastName.style.border="1px solid red";
    }

    if(age.value == ""){
        age.style.border="1px solid red";
    }

    if(email.value == ""){
        email.style.border="1px solid red";
    }

    if(password.value == "") {
        password.style.border = "1px solid red";
    }
        return true;
}