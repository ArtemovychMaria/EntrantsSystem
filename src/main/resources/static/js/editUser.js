function validateForm() {

    var username = document.getElementById("username");
    var firstName = document.getElementById("firstName");
    var lastName = document.getElementById("lastName");
    var age = document.getElementById("age");

    if(username.value == ""){
        username.style.border="1px solid red";
        document.getElementById("fusername").innerHTML='*field is required';
    }

    if(firstName.value == ""){
        firstName.style.border="1px solid red";
        document.getElementById("fFirstName").innerHTML='*field is required';
    }

    if(lastName.value == ""){
        lastName.style.border="1px solid red";
        document.getElementById("fLastName").innerHTML='*field is required';
    }

    if(age.value == ""){
        age.style.border="1px solid red";
        document.getElementById("fage").innerHTML='*field is required';
    }

    if(username.value == ""|| firstName.value == "" || lastName.value == "" || age.value == ""){
        return false;
    }else {
        return true;
    }

}