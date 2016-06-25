/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
    $('#showmore').click(function(e){  
        var targetUrl = "http://localhost:8080/BookService/webresources/books";
        var index=3;
        $.ajax({
            type: 'GET',
            dataType:'json',
            url: targetUrl,
            success: function(data){
               var id = document.getElementById("bookid");
               var str = "";
               for(i=3; i<data.length;i++){
                 var books = data[i];
                 var j=i%index;
                   if((i%index) == 0){
                      str += '<div class="row stylish-panel">' ;
                   }
                   str += '<div class="col-md-4">';
                   str += '<img src="'+books['href']+'" alt="Book cover" class="img-rounded" width="200" height="200"/>';
                   str += '<h2>'+books['category']+'</h2>';
                   var bown = books['booksPK'];
                   str += '<a href="bookDetails/?owner'+bown['owner']+'&isbn='+bown['ISBN']+'" class="btn btn-primary" title="See more">Book Details</a>';
                   str += '</div>';
                   if((j%index) == (index-1)){
                       str += '</div>';
                       str += '<br/>';
                   }
               }
                id.innerHTML +=str;
            }
        });
        $("#showmore").hide();
     });
});

