/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
    
   $("#parent").on('click','#edit',function(){
       $(".qtyInput").attr("readonly",false);
       $(".qtyInput").css("border-style","solid");
       $(".qtyInput").css("border-color","red");
       $("#edit").remove();
       $("#parent").append("<small><a id=\"submit\" class=\"afix-1\" >Submit</a></small>");
         
   });
  
   $("#checkout").click(function(){
        window.location.href = "http://localhost:8080/BookStore/checkOut";
    });
    
    
    $("#parent").on('click','#submit',function(){
        var arr =[];
        var sum = 0;
        $(".qtyInput").each(function() {
          
            var newQty  = $(this).val();
            var price = $(this).attr("name");
            arr.push(newQty);
            sum += parseFloat(price)*newQty;
            if(newQty == 0){
                $(this).parent().parent().parent().parent().remove();
            }else{
                $(this).attr("readonly");
                $(this).css("border-style","none");
            }        
        });
       
        var targetUrl = "http://localhost:8080/BookStore/updateQty";
        $.ajax({
            url:targetUrl,
            type:"POST",
            dataType:'json',
            data: {a:arr}      
        });
 
        window.location.href = "http://localhost:8080/BookStore/cart";
    });
    
   
});


