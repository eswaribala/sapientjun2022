window.addEventListener('load',function (){

    var COLORS = [];
    while(COLORS.length < 100){
        COLORS.push(`rgb(${rand(0,255)},${rand(0,255)},${rand(0,255)})`);
    }
    console.log(COLORS);
    let k=0;
    var element=document.querySelector("#root");
    var table=document.createElement("table");
    for(let i=0;i<10;i++){
        var tr=document.createElement("tr");
        for(let j=0;j<3;j++){
            var td=document.createElement("td");
            var article = document.createElement("article");
            article.className = "article";
            article.style.backgroundColor=COLORS[k];
            k++;
            td.appendChild(article);
            tr.appendChild(td);
        }
        table.appendChild(tr);
    }
    element.appendChild(table);
})

function rand(from,to){
    return ~~((Math.random()*(to-from))+from);
}
