window.addEventListener('load',function(){

    if(navigator.geolocation) {
        console.log("Geo API supported");
        navigator.geolocation.getCurrentPosition(success,failure);

    }
    else
        console.log("Geo API not supported");



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
    var docsRef=document.querySelector("#docs");

    for(let i=0;i<window.localStorage.length;i++)
    {
        if (window.localStorage.getItem("doc"+i) != undefined) {


            retrieveData(docsRef,window.localStorage.getItem("doc"+i));


        }
    }

})

function  retrieveData(docsRef,file){

    var img =new Image();
    img.width=100;
    img.height=100;
    img.src=file;
    docsRef.appendChild(img);

}


function success(position) {
    console.log(position.coords.latitude);
    console.log(position.coords.longitude);
    console.log(position.coords.altitude);
    console.log(position.coords.accuracy);
    console.log(position.coords.altitudeAccuracy);
    console.log(position.coords.speed);
    var sectionref = document.getElementById("geoinfo");
    sectionref.innerHTML =
        "<p> Latitude=<mark>" + position.coords.latitude + "</mark></p><br/>" +
        "<p> Longitude=<mark>" + position.coords.longitude + "</mark></p>";



    googleloc = new google.maps.LatLng
    (position.coords.latitude,position.coords.longitude);

    //alert(googleloc);
    var mapoptions={
        center:googleloc,
        zoom:12,
        mapTypeId:google.maps.MapTypeId.ROADMAP,
        mapTypeControl:true,
        mapTypeControlOptions:google.maps.MapTypeControlStyle.DEFAULT

    };

    var gmaparea=document.getElementById("maparea");
    gmap = new google.maps.Map(gmaparea,mapoptions);
    marker = new google.maps.Marker
    ({
        position:googleloc,
        map:gmap,
        title:"I am Here"

    });
    // alert("done");

}

function failure(msg)
{
    console.log(msg);
}
