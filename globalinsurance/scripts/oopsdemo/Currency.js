var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var Currency = /** @class */ (function () {
    function Currency(currencyCode, currencyName, currencyValue, active) {
        this._currencyCode = currencyCode;
        this._currencyName = currencyName;
        this._currencyValue = currencyValue;
        this._active = active;
    }
    Object.defineProperty(Currency.prototype, "currencyCode", {
        get: function () {
            return this._currencyCode;
        },
        set: function (value) {
            this._currencyCode = value;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Currency.prototype, "currencyName", {
        get: function () {
            return this._currencyName;
        },
        set: function (value) {
            this._currencyName = value;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Currency.prototype, "currencyValue", {
        get: function () {
            return this._currencyValue;
        },
        set: function (value) {
            this._currencyValue = value;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Currency.prototype, "active", {
        get: function () {
            return this._active;
        },
        set: function (value) {
            this._active = value;
        },
        enumerable: false,
        configurable: true
    });
    return Currency;
}());
var currency = new Currency("INR", "Rupees", 78, true);
console.log(currency.currencyCode, currency.currencyName, currency.currencyValue);
//inheritance
var Person = /** @class */ (function () {
    function Person(adharCardNo, firstName, lastName) {
        this._adharCardNo = adharCardNo;
        this._firstName = firstName;
        this._lastName = lastName;
    }
    Object.defineProperty(Person.prototype, "adharCardNo", {
        get: function () {
            return this._adharCardNo;
        },
        set: function (value) {
            this._adharCardNo = value;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Person.prototype, "firstName", {
        get: function () {
            return this._firstName;
        },
        set: function (value) {
            this._firstName = value;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Person.prototype, "lastName", {
        get: function () {
            return this._lastName;
        },
        set: function (value) {
            this._lastName = value;
        },
        enumerable: false,
        configurable: true
    });
    return Person;
}());
var Customer = /** @class */ (function (_super) {
    __extends(Customer, _super);
    function Customer(adharCardNo, firstName, lastName, customerId, userName, password) {
        var _this = _super.call(this, adharCardNo, firstName, lastName) || this;
        _this._customerId = customerId;
        _this._userName = userName;
        _this._password = password;
        return _this;
    }
    Object.defineProperty(Customer.prototype, "customerId", {
        get: function () {
            return this._customerId;
        },
        set: function (value) {
            this._customerId = value;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Customer.prototype, "userName", {
        get: function () {
            return this._userName;
        },
        set: function (value) {
            this._userName = value;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Customer.prototype, "password", {
        get: function () {
            return this._password;
        },
        set: function (value) {
            this._password = value;
        },
        enumerable: false,
        configurable: true
    });
    return Customer;
}(Person));
var customer = new Customer("A3467934", "Parameswari", "Bala", 346934, "user1", "test@123");
console.log(customer.adharCardNo, customer.userName);
