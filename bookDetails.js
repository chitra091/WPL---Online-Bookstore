/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){    
    $( "#dialog" ).dialog({
        autoResize: true,
        hide: "clip",
        height: '200',
        width: '300',
        autoOpen: false,
        buttons:[
                { 
                    id:"checkout",
                    text: "Check Out", 
                    click: function(){checkout();}
                },
                {
                    id:"continue",
                    text: "Continue Shopping",  
                    click: function(){continueShopping();}
                }
        ]
    });
    
    
    $( "#addToCart" ).click(function() {
            $( "#dialog" ).dialog( "open" );
    });
   
});

function checkout(){
    var price = $("#price").html();
    var title = $("#title").html();
    var qty = $("#qty").val();
    var href = $("#href").attr("src");
    var targetUrl = "http://localhost:8080/BookStore/addToCart";
    $.post(targetUrl,{price: price,title:title,href:href, qty:qty});
    $( "#dialog" ).dialog( "close" );
    window.location.href = "http://localhost:8080/BookStore/cart";
}

function continueShopping(){
    var price = $("#price").html();
    var title = $("#title").html();
    var qty = $("#qty").val();
    var href = $("#href").attr("src");
    var targetUrl = "http://localhost:8080/BookStore/addToCart";
    $.post(targetUrl,{price: price,title:title,href:href, qty:qty});
    $( "#dialog" ).dialog( "close" );
    window.location.href = "http://localhost:8080/BookStore/showBooks";
}

