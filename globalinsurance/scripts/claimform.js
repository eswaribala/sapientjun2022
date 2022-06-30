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

       //create json object
        claimObject={
            "claimId":claimId,
            "policyNo":policyNo,
            "mobileNo":mobileNo,
            "email":email,
            "claimDate":claimDate,
            "driverType":driverType,
            "driverName":driverName
        }

        console.log(claimObject);
        window.localStorage.setItem("claim",claimObject);

        return false;
    })

})
