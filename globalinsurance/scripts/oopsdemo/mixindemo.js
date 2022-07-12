var Driver = /** @class */ (function () {
    function Driver() {
    }
    Driver.prototype.canDrive = function () {
        return true;
    };
    return Driver;
}());
var Owner = /** @class */ (function () {
    function Owner() {
    }
    Owner.prototype.canBuyInsurance = function () {
        return true;
    };
    return Owner;
}());
var Vehicle = /** @class */ (function () {
    function Vehicle() {
    }
    Vehicle.prototype.isAccident = function () {
        return true;
    };
    Vehicle.prototype.canBuyInsurance = function () {
        return false;
    };
    Vehicle.prototype.canDrive = function () {
        return false;
    };
    return Vehicle;
}());
var vehicle = new Vehicle();
console.log(vehicle.isAccident());
applyMixins(Vehicle, [Driver, Owner]);
console.log(vehicle.canDrive());
console.log(vehicle.canBuyInsurance());
function applyMixins(derivedCtor, baseCtors) {
    baseCtors.forEach(function (baseCtor) {
        Object.getOwnPropertyNames(baseCtor.prototype).forEach(function (name) {
            derivedCtor.prototype[name] = baseCtor.prototype[name];
        });
    });
}
