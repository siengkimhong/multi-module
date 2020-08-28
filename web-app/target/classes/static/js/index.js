$(function (){
    $.ajax({
       url: '/ajax/related-categories',
       method: 'GET',
       success: function (response){
           console.log(response)
           $('#category-related').html(response);
       },
        error:function (error){
           console.log(error);
        }
    });
})