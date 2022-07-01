window.addEventListener('load',function (){

    var COLORS = [];
    while(COLORS.length < 100){
        COLORS.push(`rgb(${rand(0,255)},${rand(0,255)},${rand(0,255)})`);
    }
    console.log(COLORS);
    var BlockTitles=["View Claim","Apply Claim","Surveyor Report",
    "FIR Report","Refund Status","Gallery"]
    let k=0;
    var element=document.querySelector("#root");
    var table=document.createElement("table");
    for(let i=0;i<2;i++){
        var tr=document.createElement("tr");
        for(let j=0;j<3;j++){
            var td=document.createElement("td");
            var article = document.createElement("article");
            article.className = "article";
            article.style.backgroundColor=COLORS[k];
            article.setAttribute("id","article"+k);
            var anchor=document.createElement("a");
            anchor.setAttribute("href","#");
            var title=document.createElement("h4");
            var text=document.createTextNode(BlockTitles[k]);
            k++;
            title.className="title"
            title.appendChild(text);

            anchor.appendChild(title);
            article.appendChild(anchor);

            td.appendChild(article);
            tr.appendChild(td);
        }
        table.appendChild(tr);
    }
    element.appendChild(table);

    for(let i=0;i<6;i++) {
        article = document.querySelector("#article"+i);
        article.addEventListener('click', function () {
          if(this.innerText == 'Apply Claim'){
            this.childNodes[0].setAttribute("href","claimform.html");

          }
            if(this.innerText == 'View Claim'){
                this.childNodes[0].setAttribute("href","viewclaim.html");
            }
        })
    }

})

function rand(from,to){
    return ~~((Math.random()*(to-from))+from);
}
