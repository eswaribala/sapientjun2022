window.addEventListener('load',function(){

    form=document.querySelector("form");
    form.addEventListener('submit',function(){
       console.log("form submitted");
       claimId=document.querySelector("#claimId").value;
       policyNo=document.querySelector("#policyNo").value;
       claimDate=document.querySelector("#claimDate").value;
       email=document.querySelector("#email").value;
       mobileNo=document.querySelector("#mobileNo").value;
       driverType=document.querySelector("#driverType").value;
       driverName=document.querySelector("#driverName").value;
       address=document.querySelector("#address").value;
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

        console.log(claimObject);
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
