//return type
function depreciation(onRoadPrice, usedYears, drivenKms) {
    return onRoadPrice - (usedYears * 10000) - (drivenKms * 5);
}
console.log(depreciation(5000000, 3, 200000));
//functions with varying number of parameters
function joinSkillSets(name) {
    var skillSet = [];
    for (var _i = 1; _i < arguments.length; _i++) {
        skillSet[_i - 1] = arguments[_i];
    }
    var skill = '';
    if (skillSet.length == 0)
        skill = "Fresher";
    skillSet.forEach(function (skillSet) {
        if (skill.length != 0)
            skill += "," + skillSet;
        else
            skill = skillSet;
    });
    return name + "=>" + skill;
}
console.log(joinSkillSets("Sanjay", "java"));
console.log(joinSkillSets("Anil", "java", "C++"));
console.log(joinSkillSets("Ruchi", "java", "C++", "Python"));
console.log(joinSkillSets("Deepa"));
