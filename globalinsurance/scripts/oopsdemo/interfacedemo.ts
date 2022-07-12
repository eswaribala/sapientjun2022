interface Driver{
    firstName:string,
    lastName:string,
    drivingLicenseNo:string,
    mobileNo:number
}
enum DamageLevel{High, Medium, Low}

interface DriverFacade{
    //parameterized abstract Function
    (driver: Driver, damageDone:DamageLevel): void;
}

let driverFacade:DriverFacade=function(driver: Driver, damageDone: DamageLevel) {
    console.log(driver);
    console.log("Damage Done"+damageDone);
}

let driver:Driver={
    drivingLicenseNo:"A284942",
    firstName:"Anoop",
    lastName:"Kumar",
    mobileNo:49659469792
}
driverFacade(driver,DamageLevel.High);
interface FIR{
    policeStationCode:string,
    siName:string,
    status:boolean,
    firDate:Date,
    location:string,
    //optional
    comments?:string
    //abstract function
    computeDistance: ()=>number;

}
//object
let fir:FIR={
    policeStationCode:"K5",
    siName:"Ajay",
    status:true,
    firDate:new Date(2022,5,5),
    location:"chennai",
    //implement abstract
    computeDistance: ():number =>{return Math.random()},

}
console.log(fir)
console.log(fir.computeDistance());

interface Claim{
    claimId: number;
    claimAmount: number;
    policyNo?: Function;
    isLate?(date: Date): Function;
}

class ClaimImpl implements Claim{
    claimAmount: number;
    claimId: number;
    policyId:number
    policyNo(policyCode) {
        this.policyId=policyCode;
    }

    isLate(date: Date): Function {
        return undefined;
    }



}


let claimImplObj=new ClaimImpl();
claimImplObj.policyNo(436578346863);
