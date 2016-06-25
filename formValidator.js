/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var showmsg = false;
$(document).ready(function(){
    $("#userName").blur(function(){
        var input = $(this).val();
        if(input != ""){
            checkUserNameExist(input);
        }
            
    });    
    

    $('#userName').on('input',function(e){
        if(showmsg){
            $("#msg").remove();
            showmsg = false;
        }
    });
        
});

function checkUserNameExist(userName){
    var targetUrl = "http://localhost:8080/BookService/webresources/customers/"+userName;
    $.get(
          targetUrl, 
          function(data, status){
                if(status === "success"){
                    //user exits
                    handleUserExist();
                    //var info = JSON.stringify(data);
                }
    },"json");
  
}

function handleUserExist(){  
    if(!showmsg){
        $("<label id=\"msg\" style=\"color:red\">UserName exits</label>").insertAfter("#userName");
        showmsg = true;
        $("#userName").focus();
    }
}

