public class Enigma {

    private String rotorInit[] = {"#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"};


    private Rotor rotors[];
        
    public Enigma(int id1, int id2, int id3, String start){

        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1-1], start.charAt(0));
        rotors[1] = new Rotor(rotorInit[id2-1], start.charAt(1));
        rotors[2] = new Rotor(rotorInit[id3-1], start.charAt(2));
        
    }


    public String decrypt(String message){        
        //TODO
        String decryptedMessage = "";
        for(int i = 0; i < message.length(); i++){

            //find character placement in the outer
            char charDecrypt = message.charAt(i);
            int outerValue = rotors[2].indexOf(charDecrypt);

            //find character at this value in middle rotor
            char charMiddle = rotors[1].charAt(outerValue);

            //find character placement in outer rotor again
            int secondOuter = rotors[2].indexOf(charMiddle);

            /*finally, find corresponding inner char and add this
            to decrypted String */
            char decrypted = rotors[0].charAt(secondOuter);
            decryptedMessage = decryptedMessage + decrypted;

            //call rotate
            rotate();
        }
        return decryptedMessage;
        
    }


    
    public String encrypt(String message){
        //TODO
        String encryptedMessage = "";
        for(int i = 0; i < message.length(); i++){

            //find character placement in the inner rotor
            char charEncrypt = message.charAt(i);
            int innerValue = rotors[0].indexOf(charEncrypt);

            //find character at this value in outer rotor
            char charOuter = rotors[2].charAt(innerValue);

            //find character placement in middle rotor
            int middleValue = rotors[1].indexOf(charOuter);

            /*finally, find corresponding outer char and add this
            to encrypted String */
            char encrypted = rotors[2].charAt(middleValue);
            encryptedMessage = encryptedMessage + encrypted;

            //call rotate
            rotate();
        }
        return encryptedMessage;
    }

    private void rotate(){
        if(rotors[0].rotate()){
            if(rotors[1].rotate()){
                rotors[2].rotate();
            }
        }
    }
    
}

