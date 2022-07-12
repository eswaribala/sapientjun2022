//return type
function depreciation(onRoadPrice:number, usedYears:number,drivenKms):number{
    return onRoadPrice-(usedYears*10000)-(drivenKms*5);
}

console.log(depreciation(5000000,3,200000));

//functions with varying number of parameters

function joinSkillSets(name:string,...skillSet:string[]):string{
   let skill:string='';
   if (skillSet.length==0)
       skill="Fresher";
    skillSet.forEach(skillSet=>{
        if(skill.length!=0)
         skill+=","+skillSet;
        else
            skill=skillSet;
    })
    return name+"=>"+skill
}

console.log(joinSkillSets("Sanjay","java"));
console.log(joinSkillSets("Anil","java","C++"));
console.log(joinSkillSets("Ruchi","java","C++","Python"));
console.log(joinSkillSets("Deepa",));
