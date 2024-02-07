public class Rotor {

    
    private String rotorValues;
    private char startChar;
        
    public Rotor(String v, char c){
        this.rotorValues = new String(v);
        this.startChar = c;
        
        while(!this.rotate());
            
    }
    
    public boolean rotate(){
        //TODO

        //"rotate" rotor so previous final value is at the start of the string
        rotorValues = rotorValues.charAt(26) + rotorValues.substring(0,26);
        if(rotorValues.charAt(0) == startChar) {

            //return true when rotor is at original position
            return true;
        }
        return false;
        
    }
    

    public int indexOf(char c){
        //TODO
        //return index in rotor of inputted character
        return rotorValues.indexOf(c);

    }

    public char charAt(int idx){
        //TODO
        //returns character at a given index in the rotor
        return rotorValues.charAt(idx);
    }
}
    
