class Currency{
    private _currencyCode:string;
    private _currencyName:string;
    private _currencyValue:number;
    private _active:boolean;
    static objects:number;

    constructor(currencyCode: string, currencyName: string, currencyValue: number, active: boolean) {
        this._currencyCode = currencyCode;
        this._currencyName = currencyName;
        this._currencyValue = currencyValue;
        this._active = active;
        Currency.numberOfObjectsCreated();
    }

    get currencyCode(): string {
        return this._currencyCode;
    }

    set currencyCode(value: string) {
        this._currencyCode = value;
    }

    get currencyName(): string {
        return this._currencyName;
    }

    set currencyName(value: string) {
        this._currencyName = value;
    }

    get currencyValue(): number {
        return this._currencyValue;
    }

    set currencyValue(value: number) {
        this._currencyValue = value;
    }

    get active(): boolean {
        return this._active;
    }

    set active(value: boolean) {
        this._active = value;
    }
//static method
   static numberOfObjectsCreated():number{
         return this.objects++;
   }
}

var currency=new Currency("INR","Rupees",
    78,true);
console.log(currency.currencyCode,currency.currencyName,currency.currencyValue);

enum Gender{MALE,FEMALE}

//inheritance
class Person{
    private _adharCardNo:string;
    private _firstName:string;
    private _lastName:string;
    private _gender:Gender;

    constructor(adharCardNo: string, firstName: string, lastName: string,gender:Gender) {
        this._adharCardNo = adharCardNo;
        this._firstName = firstName;
        this._lastName = lastName;
        this._gender=gender;
    }


    get adharCardNo(): string {
        return this._adharCardNo;
    }

    set adharCardNo(value: string) {
        this._adharCardNo = value;
    }

    get firstName(): string {
        return this._firstName;
    }

    set firstName(value: string) {
        this._firstName = value;
    }

    get lastName(): string {
        return this._lastName;
    }

    set lastName(value: string) {
        this._lastName = value;
    }
}

class Customer extends Person{
    private _customerId:number;
    private _userName:string;
    private _password:string;

    constructor(adharCardNo: string, firstName: string, lastName: string,
                customerId: number, userName: string, password: string,gender:Gender) {
        super(adharCardNo, firstName, lastName,gender);
        this._customerId = customerId;
        this._userName = userName;
        this._password = password;
    }


    get customerId(): number {
        return this._customerId;
    }

    set customerId(value: number) {
        this._customerId = value;
    }

    get userName(): string {
        return this._userName;
    }

    set userName(value: string) {
        this._userName = value;
    }

    get password(): string {
        return this._password;
    }

    set password(value: string) {
        this._password = value;
    }
}

var customer=new Customer("A3467934","Parameswari",
    "Bala",346934,"user1","test@123",Gender.FEMALE);
console.log(customer.adharCardNo,customer.userName);
//static member
console.log(Currency.objects);
