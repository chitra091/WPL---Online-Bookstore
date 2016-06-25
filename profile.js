/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
  
    $(".action").click(function() {
    var type = $(this).attr("data-type");
    if( type == "edit" ) {
        $(".preview").hide();
        $(".editable").show();    
        $(".action").html("[submit]");
        $(this).attr("data-type", "send");
    }    
    if( type == "send" ) {
        $(".preview").show();
        $(".editable").hide();    
        $(".action").html("Edit Profile");
        
        
        
        $("#emailPreview").html( $("#email").val() );
	$("#StreetPreview").html( $("#street").val() );
        $("#CityPreview").html( $("#city").val() );
        $("#ZipPreview").html( $("#ZipCode").val() );
        $(this).attr("data-type", "edit");
    }
});
  
});
