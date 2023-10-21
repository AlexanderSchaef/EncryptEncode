/**
Independent Project testing encoding and encryption.
Start date: 10/21/23
README.md in the github repo will be used for a checklist.
@author Alexander Schaefer
@author Ashton Putnam
*/

import java.util.Scanner;
import java.util.Random;

public class BetaEncoding
  {
    public static void main(String [] args)
    {
      // initialize variables
      String message = "Lorem ipsum dolor sit amet.";  // test message

      Encode eMessage = new Encode(message); 
         // should store message as XX, length of message as XX
         // and the different unique characters
         
      Random rand = new Random();
      int randInt = rand.nextInt(1000);   // 0-999

      // constants
      final int key = randInt;
      

      // test byte back to string
      // toString @Override method in Encode
      

      // start encryption

      // test toString values of encrypted (curiosity)
      
      // test decryption
      
      // test decrypted byte arraylist back to string message


      // compare decrypted message against base message

      
    }
  }
