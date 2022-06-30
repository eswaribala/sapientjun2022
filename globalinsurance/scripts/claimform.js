window.addEventListener('load',function(){

    var form=document.querySelector("form");
    form.addEventListener('submit',function(){
       console.log("form submitted");
        return false;
    })

})
