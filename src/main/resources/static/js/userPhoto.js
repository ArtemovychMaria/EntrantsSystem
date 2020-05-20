$("#photo-file").change(function (){
    var fd = new FormData();
    var file = $('#photo-file')[0].files[0];

    if(file === undefined){
        return;
    }

    fd.append('photoFile', file);
    $.ajax({
        url: '/user-photo-files/upload?' + $("#sec-token").attr('name') + '=' + $("#sec-token").val(),
        type: 'post',
        data: fd,
        contentType: false,
        processData: false,
        success: function (photoId) {
            $("#user-photo")
                .attr("src", "/user-photo-files/download/" + photoId);
            $("#photo-id").val(photoId)
        },
    });
});