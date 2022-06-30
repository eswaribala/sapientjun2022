window.addEventListener('load',function(){

    var table=document.querySelector("#claimtbl");

    tr=document.createElement("tr");

    if(window.localStorage.getItem("claim")!=undefined){
        claimObject=JSON.parse(window.localStorage.getItem("claim"));
        console.log(claimObject.claimId);
        td=document.createElement("td");
        text=document.createTextNode(claimObject.claimId);
        td.appendChild(text);
        tr.appendChild(td);
        td=document.createElement("td");
        text=document.createTextNode(claimObject.policyNo);
        td.appendChild(text);
        tr.appendChild(td);
        td=document.createElement("td");
        text=document.createTextNode(claimObject.claimDate);
        td.appendChild(text);
        tr.appendChild(td);
        td=document.createElement("td");
        text=document.createTextNode(claimObject.email);
        td.appendChild(text);
        tr.appendChild(td);
        td=document.createElement("td");
        text=document.createTextNode(claimObject.mobileNo);
        td.appendChild(text);
        tr.appendChild(td);
        td=document.createElement("td");
        text=document.createTextNode(claimObject.driverType);
        td.appendChild(text);
        tr.appendChild(td);
        td=document.createElement("td");
        text=document.createTextNode(claimObject.driverName);
        td.appendChild(text);
        tr.appendChild(td);
        td=document.createElement("td");
        text=document.createTextNode(claimObject.address);
        td.appendChild(text);
        tr.appendChild(td);
    }
    table.appendChild(tr);


})
