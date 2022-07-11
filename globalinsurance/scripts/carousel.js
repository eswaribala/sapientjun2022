$(document).ready(function (){
   $("#linkref").click(function()
   {
      if($("#linkref").text().indexOf("down") != -1)
      {
         $(".curtain").slideUp(3000, function()
         {
            $("#linkref").html("Pull the curtain up");
         });
      }
      else
      {

         $(".curtain").slideDown(3000, function(){
            $("#linkref").html("Pull the curtain down");});


      }



   });
});
