abstract class Person{
    adharCardNo:string;

    constructor(adharCardNo: string) {
        this.adharCardNo = adharCardNo;
    }
    display():void{
        console.log(this.adharCardNo);
    }
    abstract find(string):Person;
}

class User extends Person{
    userId:number;

    constructor(adharCardNo: string, userId: number) {
        super(adharCardNo);
        this.userId = userId;
    }


    find(string): Person {
        return new User("A32424545",24672);
    }

}

let user:User=new User("A57604560",54674657);
user.display();
