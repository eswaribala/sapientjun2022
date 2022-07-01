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
