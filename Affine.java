import java.util.Hashtable;

public class Affine {
    Menu menu = new Menu();
    Utils utils = new Utils();
    Hashtable<Integer, Integer> multInverse = new Hashtable<Integer, Integer>();

    public void init() {
        System.out.println("Affine Cipher");
        String filepath = utils.getFilePathFromFile();
        String text = utils.getMessageFromFile(filepath);

        String cryptChoice = menu.initCryptMenu();

        // int key = 1;
        int key = utils.getIntKey();
        int a = utils.getA();
        // int a = 1;

        switch (cryptChoice) {
            case "e":
            case "E":
                String encryption = encrypt(text, key, a);
                System.out.println(encryption);
                break;
            case "d":
            case "D":
                String decryption = decrypt(text, key, a);
                System.out.println(decryption);
                break;
            default:
                System.out.println("Error with Affine Initialization");
        }
    }

    private String encrypt(String m, int k, int a) {
        /// Cipher Text initially empty 
        char [] mChar = m.toCharArray(); 
        String cipher = "";
        for (int i = 0; i < mChar.length; i++) 
        { 
            if (mChar[i] != ' ')  
            { 
                cipher = cipher 
                        + (char) ((((a * (mChar[i] - 'A')) + k) % 26) + 'A'); 
            } else // else simply append space character 
            { 
                cipher += mChar[i]; 
            } 
        } 
        return cipher; 
    }

    private String decrypt(String m, int k, int a) {
        String msg = ""; 
        int a_inv = 0; 
        int flag = 0; 
  
        //Find a^-1 (the multiplicative inverse of a  
        //in the group of integers modulo m.)  
        for (int i = 0; i < 26; i++)  
        { 
            flag = (a * i) % 26; 
  
            // Check if (a*i)%26 == 1, 
            // then i will be the multiplicative inverse of a 
            if (flag == 1)  
            { 
                a_inv = i; 
            } 
        } 
        for (int i = 0; i < m.length(); i++)  
        { 
             //Applying decryption formula a^-1 ( x - b ) mod m  
            if (m.charAt(i) != ' ')  
            { 
                msg = msg + (char) (((a_inv *  
                        ((m.charAt(i) + 'A' - k)) % 26)) + 'A'); 
            }  
            else //else simply append space characte 
            { 
                msg += m.charAt(i); 
            } 
        } 
  
        return msg;  
  
    }

}    