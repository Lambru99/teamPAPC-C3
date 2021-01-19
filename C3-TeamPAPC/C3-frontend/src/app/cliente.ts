import { User } from "./utente";

export class Cliente extends User{
    
    constructor(){
        super();
    }


    public toString() : string {
        return "[ cliente : " +super.toString()+" ]";
    }
    
}