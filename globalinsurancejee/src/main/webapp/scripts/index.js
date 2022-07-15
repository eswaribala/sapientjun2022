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
    var div=document.querySelector("#viewPolicy");
    var table=document.createElement('table');

    ajaxRequest.onreadystatechange = function(){
        if(ajaxRequest.readyState == 4 && ajaxRequest.status == 200){
            var data=ajaxRequest.responseText;
            var parsedData=JSON.parse(data);
            parsedData.forEach(policy=>{
                var tr=document.createElement('tr');
                td=document.createElement("td");
                text=document.createTextNode(policy.policyNo);
                td.appendChild(text);
                tr.appendChild(td);
                td=document.createElement("td");
                text=document.createTextNode(policy.policyName);
                td.appendChild(text);
                tr.appendChild(td);
                td=document.createElement("td");
                text=document.createTextNode(policy.fromDate);
                td.appendChild(text);
                tr.appendChild(td);
                td=document.createElement("td");
                text=document.createTextNode(policy.toDate);
                td.appendChild(text);
                tr.appendChild(td);
                td=document.createElement("td");
                text=document.createTextNode(policy.sumInsured);
                td.appendChild(text);
                tr.appendChild(td);
                table.appendChild(tr);
                console.log(policy);
            })

           div.appendChild(table);

        }
    }
    //accessing api
    ajaxRequest.open("GET", "http://localhost:7070/globalinsurancejee_war_exploded/PolicyServlet", true);
    ajaxRequest.send();
    //xmlhttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded;");
    //xmlhttp.send("FirstName=krishna&LastName=Kumar");
}
