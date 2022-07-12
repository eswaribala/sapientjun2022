export var BankModule;
(function (BankModule) {
    class Bank {
    }
    BankModule.Bank = Bank;
    class Customer {
    }
    BankModule.Customer = Customer;
    let AccountType;
    (function (AccountType) {
        AccountType[AccountType["Savings"] = 0] = "Savings";
        AccountType[AccountType["Current"] = 1] = "Current";
        AccountType[AccountType["Demat"] = 2] = "Demat";
        AccountType[AccountType["Loan"] = 3] = "Loan";
    })(AccountType = BankModule.AccountType || (BankModule.AccountType = {}));
})(BankModule || (BankModule = {}));
