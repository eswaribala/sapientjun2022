//return type
function depreciation(onRoadPrice:number, usedYears:number,drivenKms):number{
    return onRoadPrice-(usedYears*10000)-(drivenKms*5);
}

console.log(depreciation(5000000,3,200000));


//default parameter
function employeeInfo(name:string,country:string="India"):string{
    return name+"=>"+country;
}

console.log(employeeInfo("Sanjay",));
console.log(employeeInfo("Anil","Singapore"));
console.log(employeeInfo("Ruchi","USA"));
console.log(employeeInfo("Deepa","KSA"));


//functions with varying number of parameters
function joinSkillSets(name:string,country:string="India",...skillSet:string[]):string{
   let skill:string='';
   if (skillSet.length==0)
       skill="Fresher";
    skillSet.forEach(skillSet=>{
        if(skill.length!=0)
         skill+=","+skillSet;
        else
            skill=skillSet;
    })
    return name+"=>"+country+"=>"+skill
}

console.log(joinSkillSets("Sanjay","","java"));
console.log(joinSkillSets("Anil","Singapore","java","C++"));
console.log(joinSkillSets("Ruchi","USA","java","C++","Python"));
console.log(joinSkillSets("Deepa","KSA"));
