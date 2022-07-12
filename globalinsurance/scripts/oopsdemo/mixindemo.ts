class Driver{
    public canDrive():boolean{
        return true;
    }
}

class Owner{
    public canBuyInsurance():boolean{
        return true;
    }
}

class Vehicle implements Driver,Owner{

    public isAccident():boolean{
        return true;
    }

    canBuyInsurance(): boolean {
        return false;
    }

    canDrive(): boolean {
        return false;
    }
}


let vehicle= new Vehicle();
console.log(vehicle.isAccident());
applyMixins(Vehicle, [Driver,Owner]);
console.log(vehicle.canDrive());
console.log(vehicle.canBuyInsurance())
function applyMixins(derivedCtor: any, baseCtors: any[]) {
    baseCtors.forEach(baseCtor => {
        Object.getOwnPropertyNames(baseCtor.prototype).forEach(name => {
            derivedCtor.prototype[name] = baseCtor.prototype[name];
        });
    });
}
