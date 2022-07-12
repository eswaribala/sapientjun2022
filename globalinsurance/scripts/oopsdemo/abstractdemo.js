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
var Person = /** @class */ (function () {
    function Person(adharCardNo) {
        this.adharCardNo = adharCardNo;
    }
    Person.prototype.display = function () {
        console.log(this.adharCardNo);
    };
    return Person;
}());
var User = /** @class */ (function (_super) {
    __extends(User, _super);
    function User(adharCardNo, userId) {
        var _this = _super.call(this, adharCardNo) || this;
        _this.userId = userId;
        return _this;
    }
    User.prototype.find = function (string) {
        return new User("A32424545", 24672);
    };
    return User;
}(Person));
var user = new User("A57604560", 54674657);
user.display();
