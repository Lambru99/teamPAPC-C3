export class User{
    private _nome:string;
    private _cognome:string;
    private _email:string;
    private _password:string;
    private _username:string;
    
    constructor(){
        this._nome = "";
        this._cognome="";
        this._email = "";
        this._password="";
    }

    
    public get username() : string {
        return this._username;
    }

    public set username(v:string){
        this._username = v;
    }
    
    
    public get nome() : string {
        return this._nome;
    }
    
    public get cognome() : string {
        return this._cognome;
    }

    public get email() : string {
        return this._email;
    }
    
    public get password() : string {
        return this._password;
    }
    
    public set nome(v : string) {
        this._nome = v;
    }
    
    public set cognome(v : string) {
        this._cognome = v;
    }
    
    public set email(v : string) {
        this._email = v;
    }
    
    public set password(v : string) {
        this._password = v;
    }

    public toString() : string {
        return this.nome+" "+this.cognome+" "+this.email+" "+this.password+" "+this.username;
    }
}