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
        System.out.println("Encrypting " + m);
        String answer = "";
        for (int i = 0; i < m.length(); i++)
            answer = answer + encryptLetter(m.charAt(i), k, a);
        return answer;
    }

    private String decrypt(String m, int k, int a) {
        // System.out.println("Decrypting " + m);
        String answer = "";
        int aInverse = 0;

        for (int i = 1; i <= 26; i++) {
            if (i % 2 != 0) {
                aInverse = modInverse(i, 26);
                if (aInverse != 1) {
                    multInverse.put(i, aInverse);
                }
            }    
        }
        System.out.println(multInverse);
        
       for(int i =0; i < m.length(); i++) 
       {
           if(m.charAt(i) != ' ')
           {
               answer = answer + decryptLetter(m.charAt(i), k, a);
           }
       }
       return answer;
    }

    private char encryptLetter(char c, int k, int a){
        if('a'<=c && c<='z')
	  {
		  c=(char)((((a * (c - 'a')) + k) % 26) + 'a');
          if(c>'z') 
            c=(char)((int)c-26);
	  }
	  if('A'<=c && c<='Z')
	  {
		  c=(char)((((a * (c - 'A')) + k) % 26) + 'A');
          if(c>'Z') 
            c=(char)((int)c-26);
      }
	  return c;
    }

    private char decryptLetter(char c, int k, int aInverse){
        if('a'<=c && c<='z')
	  {
		  c=(char)((((aInverse * (c + 'a')) - k) % 26) + 'a');
          if(c>'z') 
            c=(char)((int)c-26);
	  }
	  if('A'<=c && c<='Z')
	  {
		  c=(char)((((aInverse * (c + 'A')) - k) % 26) + 'A');
          if(c>'Z') 
            c=(char)((int)c-26);
      }
	  return c;
    }

    static int modInverse(int a, int m) 
    { 
        a = a % m; 
        for (int x = 1; x < m; x++) 
           if ((a * x) % m == 1) 
              return x; 
        return 1; 
    } 
}
