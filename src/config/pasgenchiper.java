package config;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class pasgenchiper {
    public String enkripsi(String password){
        try{
            MessageDigest keyGen = MessageDigest.getInstance("SHA-256");
            byte[] crypted = keyGen.digest(password.getBytes());
            StringBuilder recrypted = new StringBuilder(crypted.length);
            for(byte reading : crypted){
                String giveText = Integer.toHexString(0xff & reading); 
                if(giveText.length()==1){
                    recrypted.append('0');
                }
                recrypted.append(giveText);
            }
            return recrypted.toString();
        }catch(NoSuchAlgorithmException ex){
            ex.printStackTrace();
        }
        return null;
    }
}
