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
        document.getElementById("fusername").innerHTML='*field is required';
    }

    if(firstName.value == ""){
        firstName.style.border="1px solid red";
        document.getElementById("ffirstName").innerHTML='*field is required';
    }

    if(lastName.value == ""){
        lastName.style.border="1px solid red";
        document.getElementById("flastName").innerHTML='*field is required';
    }

    if(age.value == ""){
        age.style.border="1px solid red";
        document.getElementById("fage").innerHTML='*field is required';
    }

    if(email.value == ""){
        email.style.border="1px solid red";
        document.getElementById("femail").innerHTML='*field is required';
    }else if(at<1 || dot<at+2 || dot+2>=email.value.length){
        document.getElementById("femail").innerHTML='*enter valid email (example: anna@mail.com';
    }

    if(password.value == ""){
        password.style.border="1px solid red";
        document.getElementById("fpassword").innerHTML='*field is required';
    }else if(password.value.length<6){
        document.getElementById("fpassword").innerHTML='*password must exists atleast 6 character';
    }

    if(username.value == "" || firstName.value == "" || lastName.value == "" || age.value == "" ||
        gender.value == "" || email.value == "" || password.value == "" || password.value.length<6
        || at<1 || dot<at+2 || dot+2>=email.value.length){
        return false;
    }else {
        return true;
    }
}