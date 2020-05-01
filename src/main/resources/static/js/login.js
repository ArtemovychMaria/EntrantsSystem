function validateForm(){

    var username = document.getElementById("username");
    var password = document.getElementById("password");


    if(username.value == ""){
        username.style.border="1px solid red";
        document.getElementById("fusername").innerHTML='*field is required';
    }

    if(password.value == ""){
        password.style.border="1px solid red";
        document.getElementById("fpassword").innerHTML='*field is required';
    }

    if(username.value == ""|| password.value == ""){
        return false;
    }else {
        return true;
    }
}