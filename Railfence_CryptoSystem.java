import java.util.Scanner;

public class Railfence_CryptoSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in); // allow users to enter key and message 
        System.out.print("Enter text to be encrypted: "); //display message 
        String plainText = sc.nextLine(); //collects the plain text from user 

        System.out.print ("Enter your key: "); // display message
        int key = sc.nextInt(); //collects key to create grid 

       //System.out.println(encryption(plainText, key)); //sends to encryption method
       String en = encryption (plainText, key);
       System.out.println (en);
      System.out.println (decryption(plainText, key));
       
    }
static String encryption (String text, int key){ // a method created to encryp the message using railfence
    String encryptedText = "";
    boolean check = false; // checks when the program is going down or up in the grid 
    int j = 0;
    int row = key;
    int column = text.length();
    char [][] a = new char[row][column]; // this is the grid

  
    for (int i = 0; i< column; i++){
        if (j==0 ||j== key -1) // check if j is on the first row or in the bottom row
        check = !check;


        a[j][i] = text.charAt(i); //adding each character to the grid 

        if (check)
            j++;
        else
            j--;
    }
    for (int i = 0; i< row; i++){
        for(int k =0; k< column; k++){
           if (a[i][k] != 0)
                encryptedText += a[i][k]; //add it to encrypted text
        }
       
    }


    for (int i = 0; i< row; i++){
        for(int k =0; k< column; k++){
            System.out.print(a[i][k]+ "");
        }
        System.out.println(); 
    }

    return encryptedText;
}

static String decryption(String text, int key){
    String decryptedText = "";

    String encryptedText = "";
    boolean check = false; // checks when the program is going down or up in the grid 
    int j = 0;
    int row = key;
    int column = text.length();
    char [][] a = new char[row][column]; // this is the grid


    for (int i = 0; i< column; i++){
        if (j==0 ||j== key -1) // check if j is on the first row or in the bottom row
        check = !check;


        a[j][i] = '*';

        if (check)
            j++;
        else
            j--;
    }
   
    int index = 0;
    check = false;
    for (int i =0; i < row; i++){
        for (int k = 0; k<column; k++){
            if (a[i][k]== '*' && index < column ){
                a[i][k] = text.charAt(index++);


            }
        }
     }
    
        for (int i = 0; i< row; i++){
            for(int k =0; k< column; k++){
                System.out.print(a[i][k]+ " ");
            }
            System.out.println(); 
        
 }
        j =0;
         for (int i = 0; i< column; i++){
             if (j==0 ||j== key -1) // check if j is on the first row or in the bottom row
             check = !check;
     
             decryptedText += a[j][i];
             
             if (check)
                 j++;
             else
                 j--;
    }
    System.out.println("Encrypted Text: ");
    return decryptedText;



    }

}