window.addEventListener('load',function(){

    var form=document.querySelector("form");

    var myHeaders = new Headers();
    myHeaders.append("apikey", "Fplo51GdLJDIqKeLZE7b7qroLYC86aJS");

    var requestOptions = {
        method: 'GET',
        redirect: 'follow',
        headers: myHeaders
    };

    fetch("https://api.apilayer.com/currency_data/list", requestOptions)
        .then(response => response.text())
        .then(result => console.log(result))
        .catch(error => console.log('error', error));


    ajaxFunction();



    btnRef=document.querySelector("#claimBtn");
    form.addEventListener('submit',function(){
       console.log("form submitted");
       btnRef.className="disabled";
       btnRef.disabled=true;
        var elements=form.elements;
        var claimObject={};
        for(let i=0;i<elements.length;i++){
            var item=elements.item(i);
            claimObject[item.name]=item.value;
        }
        console.log(claimObject);
/*
       claimId=document.querySelector("#claimId").value;
       policyNo=document.querySelector("#policyNo").value;
       claimDate=document.querySelector("#claimDate").value;
       email=document.querySelector("#email").value;
       mobileNo=document.querySelector("#mobileNo").value;
       driverType=document.querySelector("#driverType").value;
       driverName=document.querySelector("#driverName").value;
       address=document.querySelector("#address").value;
*/
       //read the image
        var fileType=/image.*/

       var docRef=document.querySelector("#doc");
        for(let i=0;i<docRef.files.length;i++){

            if(docRef.files[i].type.match(fileType)){
                console.log("file type matching"+docRef.files[i].name);
                storeFile("doc"+i,docRef.files[i]);
            }

        }

       //create json object
        /*
        claimObject={
            "claimId":claimId,
            "policyNo":policyNo,
            "mobileNo":mobileNo,
            "email":email,
            "claimDate":claimDate,
            "driverType":driverType,
            "driverName":driverName,
            "address":address
        }
*/

        window.localStorage.setItem("claim",JSON.stringify(claimObject));

        return false;
    })





})

function storeFile(key,file){

    var fileReader=new FileReader();
    fileReader.readAsDataURL(file);
    fileReader.onload=function() {
        window.localStorage.setItem(key, fileReader.result);
    }
}

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
    var selectList=document.querySelector("#countryList");
    ajaxRequest.onreadystatechange = function(){
        if(ajaxRequest.readyState == 4 && ajaxRequest.status == 200){
             var countries=ajaxRequest.responseText;
             var countriesArray=JSON.parse(countries);
             countriesArray.forEach(country=>{
                 console.log(country.name);
                 var option=document.createElement("option");
                 var textNode=document.createTextNode(country.name);
                 option.appendChild(textNode);
                 selectList.appendChild(option);
             })

        }
    }
     //accessing api
    ajaxRequest.open("GET", "https://restcountries.com/v2/all", true);
    ajaxRequest.send();
    //xmlhttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded;");
    //xmlhttp.send("FirstName=krishna&LastName=Kumar");
}
