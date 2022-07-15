window.addEventListener('load',function (){
    ajaxFunction();
})




function ajaxFunction(){
    var ajaxRequest;
    try{
        //creating ajax object
        ajaxRequest = new XMLHttpRequest();
    } catch (e){
        try{
            //ie 7.0
            ajaxRequest = new ActiveXObject("Msxml2.XMLHTTP3.0");
        }
        catch (e){
            alert("Your browser broke!");
            return false;
        }
    }
    //checking the response
    var selectList=document.querySelector("#viewPolicy");
    ajaxRequest.onreadystatechange = function(){
        if(ajaxRequest.readyState == 4 && ajaxRequest.status == 200){
            var data=ajaxRequest.responseText;
            console.log(data);

        }
    }
    //accessing api
    ajaxRequest.open("GET", "http://localhost:7070/globalinsurancejee_war_exploded/PolicyServlet", true);
    ajaxRequest.send();
    //xmlhttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded;");
    //xmlhttp.send("FirstName=krishna&LastName=Kumar");
}
