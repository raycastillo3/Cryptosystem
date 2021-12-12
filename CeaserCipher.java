

import java.util.Scanner;

import javax.crypto.Cipher;

public class CeaserCipher {

    //shift(key) is the number or key that row of alphabet is going to shift by
public static String encrypt(String plainText, int shift){
   // the key chosen or shift have to be between 0-26 
   // no negatives or higher number is accepted, we can accomplish this with an else-if statement
   // this block will replace any number greater than 26 or less than 0
    if (shift > 26){
        shift = shift % 26;
    }
    else if (shift < 0){
        shift = (shift%26)+26;
    }
    //for cipher text
    String cipherText = "";
    int length = plainText.length();
    for (int i = 0; i < length; i++){
        char ch = plainText.charAt(i); 
        if (Character.isLetter(ch)){
            //checking if the letter is lowercase or uppercase  
        if (Character.isLowerCase(ch)){
           //new character c inserted 
            char c = (char)(ch + shift);
            if (c > 'z'){
                cipherText += (char)(ch - (26 - shift));
            }
            else {
                cipherText += c;
            }

        }
        else if (Character.isUpperCase(ch)){
            char c = (char)(ch + shift);
            if (c > 'Z'){
                cipherText += (char)(ch - (26 - shift));
            }
            else {
                cipherText += c;
            }

        }
        }
        else{
            cipherText += ch;
        }
    }
    return cipherText;


}
//same code but opposite for decrypt
public static String decrypt(String plainText, int shift){
   
     if (shift > 26){
         shift = shift %26;
     }
     else if (shift < 0){
         shift = (shift%26)+26;
     }
     //for cipher text
     String cipherText = "";
     int length = plainText.length();
     for (int i =0; i<length; i++){
         char ch = plainText.charAt(i); 
         if (Character.isLetter(ch)){
             //checking if the letter is lowercase or uppercase  
         if (Character.isLowerCase(ch)){
            //new character c inserted 
             char c = (char)(ch - shift);
             if (c < 'a'){
                 cipherText += (char)(ch + (26 - shift));
             }
             else {
                 cipherText += c;
             }
 
         }
         else if (Character.isUpperCase(ch)){
             char c = (char)(ch - shift);
             if (c < 'A'){
                 cipherText += (char)(ch + (26 - shift));
             }
             else {
                 cipherText += c;
             }
 
         }
         }
         else{
             cipherText += ch;
         }
     }
     return cipherText;
 
 
 }

public static void main (String []args){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter text to Encrypt");
    String plainText = sc.nextLine();
    String cipher = encrypt(plainText, 6);
    System.out.println("Encrypted Text: ");
System.out.println(cipher);
String decrypted = decrypt (cipher, 6);
System.out.println(decrypted);

}

}
