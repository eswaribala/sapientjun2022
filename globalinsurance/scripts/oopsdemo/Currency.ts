class Currency{
    private _currencyCode:string;
    private _currencyName:string;
    private _currencyValue:number;
    private _active:boolean;


    constructor(currencyCode: string, currencyName: string, currencyValue: number, active: boolean) {
        this._currencyCode = currencyCode;
        this._currencyName = currencyName;
        this._currencyValue = currencyValue;
        this._active = active;
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
}

var currency=new Currency("INR","Rupees",
    78,true);
console.log(currency.currencyCode,currency.currencyName,currency.currencyValue);
