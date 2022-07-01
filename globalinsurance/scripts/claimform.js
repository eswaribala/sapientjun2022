window.addEventListener('load',function(){

    var form=document.querySelector("form");

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
