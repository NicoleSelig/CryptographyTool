public class Affine {
    Menu menu = new Menu();
    Utils utils = new Utils();

    public void init(){
        System.out.println("Affine Cipher");
        String filepath = utils.getFilePathFromFile();
        String text = utils.getMessageFromFile(filepath);

        String cryptChoice = menu.initCryptMenu();

        int key = utils.getIntKey();
        int a = utils.getA();
        
        switch(cryptChoice){
            case "e":
            case "E":
                String encryption = encrypt(text,key,a);
                System.out.println(encryption);
                break;
            case "d":
            case "D":
                String decryption = decrypt(text,key,a);
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
            answer = answer + encryptLetter(m.charAt(i),k,a);
        return answer;
    }

    
    private String decrypt(String m, int k, int a) {
       System.out.println("Decrypting " + m);
       String answer = "";
       int multInverse = 0;
       int aInverse = 0;

       for (int i = 0; i < 26; i++)
       {
            multInverse = (a * i) % 26;

            if (multInverse == 1)
            {
                aInverse = i;
            }
       }
       for(int i =0; i < m.length(); i++) 
       {
           if(m.charAt(i) != ' ')
           {
               answer = answer + decryptLetter(m.charAt(i), k, aInverse);
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
}
