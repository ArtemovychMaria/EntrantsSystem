function validateForm(){
    var subjectGrade1 = document.getElementById("subjectGrade1");
    var subjectGrade2 = document.getElementById("subjectGrade2");
    var subjectGrade3 = document.getElementById("subjectGrade3");
    var certificateGrade = document.getElementById("certificateGrade");


    if(subjectGrade1.value == ""){
        subjectGrade1.style.border="1px solid red";
        document.getElementById("sg1").innerHTML='*field is required';
    }

    if(subjectGrade2.value == ""){
        subjectGrade2.style.border="1px solid red";
        document.getElementById("sg2").innerHTML='*field is required';
    }

    if(subjectGrade3.value == ""){
        subjectGrade3.style.border="1px solid red";
        document.getElementById("sg3").innerHTML='*field is required';
    }

    if(certificateGrade.value == ""){
        certificateGrade.style.border="1px solid red";
        document.getElementById("cgrade").innerHTML='*field is required';
    }

    if(subjectGrade1.value == "" || subjectGrade2.value == "" || subjectGrade3.value == ""
        || certificateGrade.value == "") {
        return false;
    }else{
        return true;
    }
}