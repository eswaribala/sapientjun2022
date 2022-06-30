window.addEventListener('load',function (){

    var element=document.querySelector("#root");
    var table=document.createElement("table");
    for(let i=0;i<10;i++){
        var tr=document.createElement("tr");
        for(let j=0;j<3;j++){
            var td=document.createElement("td");
            var article = document.createElement("article");
            article.className = "article";
            td.appendChild(article);
            tr.appendChild(td);
        }
        table.appendChild(tr);
    }
    element.appendChild(table);
})
