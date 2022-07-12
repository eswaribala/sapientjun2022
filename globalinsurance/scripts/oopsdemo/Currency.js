class Currency {
    constructor(currencyCode, currencyName, currencyValue, active) {
        this._currencyCode = currencyCode;
        this._currencyName = currencyName;
        this._currencyValue = currencyValue;
        this._active = active;
        Currency.numberOfObjectsCreated();
    }
    get currencyCode() {
        return this._currencyCode;
    }
    set currencyCode(value) {
        this._currencyCode = value;
    }
    get currencyName() {
        return this._currencyName;
    }
    set currencyName(value) {
        this._currencyName = value;
    }
    get currencyValue() {
        return this._currencyValue;
    }
    set currencyValue(value) {
        this._currencyValue = value;
    }
    get active() {
        return this._active;
    }
    set active(value) {
        this._active = value;
    }
    //static method
    static numberOfObjectsCreated() {
        return this.objects++;
    }
}
Currency.objects = 0;
var currency = new Currency("INR", "Rupees", 78, true);
console.log(currency.currencyCode, currency.currencyName, currency.currencyValue);
var Gender;
(function (Gender) {
    Gender[Gender["MALE"] = 0] = "MALE";
    Gender[Gender["FEMALE"] = 1] = "FEMALE";
})(Gender || (Gender = {}));
//inheritance
class Person {
    constructor(adharCardNo, firstName, lastName, gender) {
        this._adharCardNo = adharCardNo;
        this._firstName = firstName;
        this._lastName = lastName;
        this._gender = gender;
    }
    get adharCardNo() {
        return this._adharCardNo;
    }
    set adharCardNo(value) {
        this._adharCardNo = value;
    }
    get firstName() {
        return this._firstName;
    }
    set firstName(value) {
        this._firstName = value;
    }
    get lastName() {
        return this._lastName;
    }
    set lastName(value) {
        this._lastName = value;
    }
}
class Customer extends Person {
    constructor(adharCardNo, firstName, lastName, customerId, userName, password, gender) {
        super(adharCardNo, firstName, lastName, gender);
        this._customerId = customerId;
        this._userName = userName;
        this._password = password;
    }
    get customerId() {
        return this._customerId;
    }
    set customerId(value) {
        this._customerId = value;
    }
    get userName() {
        return this._userName;
    }
    set userName(value) {
        this._userName = value;
    }
    get password() {
        return this._password;
    }
    set password(value) {
        this._password = value;
    }
}
var customer = new Customer("A3467934", "Parameswari", "Bala", 346934, "user1", "test@123", Gender.FEMALE);
console.log(customer.adharCardNo, customer.userName);
//static member
console.log(Currency.objects);
