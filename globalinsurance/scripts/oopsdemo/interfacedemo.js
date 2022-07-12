var DamageLevel;
(function (DamageLevel) {
    DamageLevel[DamageLevel["High"] = 0] = "High";
    DamageLevel[DamageLevel["Medium"] = 1] = "Medium";
    DamageLevel[DamageLevel["Low"] = 2] = "Low";
})(DamageLevel || (DamageLevel = {}));
var driverFacade = function (driver, damageDone) {
    console.log(driver);
    console.log("Damage Done" + damageDone);
};
var driver = {
    drivingLicenseNo: "A284942",
    firstName: "Anoop",
    lastName: "Kumar",
    mobileNo: 49659469792
};
driverFacade(driver, DamageLevel.High);
//object
var fir = {
    policeStationCode: "K5",
    siName: "Ajay",
    status: true,
    firDate: new Date(2022, 5, 5),
    location: "chennai",
    //implement abstract
    computeDistance: function () { return Math.random(); }
};
console.log(fir);
console.log(fir.computeDistance());
var ClaimImpl = /** @class */ (function () {
    function ClaimImpl() {
    }
    ClaimImpl.prototype.policyNo = function (policyCode) {
        this.policyId = policyCode;
    };
    ClaimImpl.prototype.isLate = function (date) {
        return undefined;
    };
    return ClaimImpl;
}());
var claimImplObj = new ClaimImpl();
claimImplObj.policyNo(436578346863);
