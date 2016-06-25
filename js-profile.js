/**
 * 
 */
	$(document).ready(function(){
			
		$(".action").click(function(){
                    var currentMode = $(this).attr("data-mode");
                    if(currentMode == "readyForEdit")
                    { 
                             $(".preview").hide();
                             $(".editable").show();			
                             $(".action").html("[submit]");
                             $(this).attr("data-mode", "ReadyForSubmit");
                    }

                    if( currentMode == "ReadyForSubmit" ) {
                            $(".preview").show();
                            $(".editable").hide();    
                            $(".action").html("[edit]");        
                            $("#emailView").html( $("#email").val() );
                            $("#streetView").html( $("#street").val() );
                            $("#cityView").html( $("#city").val() );
                            $("#zipView").html( $("#zip").val() );
                            $(this).attr("data-mode", "readyForEdit");
                      }			
		});		
	});