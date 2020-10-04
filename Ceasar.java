
public class Ceasar {

    Menu menu = new Menu();
    Utils utils = new Utils();

    public void init(){
        System.out.println("Ceasar Cipher");
        String filepath = utils.getFilePathFromFile();
        String text = utils.getMessageFromFile(filepath);

        String cryptChoice = menu.initCryptMenu();

        int key = utils.getIntKey();
        
        switch(cryptChoice){
            case "e":
            case "E":
                String encryption = encrypt(text, key);
                System.out.println(encryption);
                break;
            case "d":
            case "D":
                String decryption = decrypt(text, key);
                System.out.println(decryption);
                break;
            default:
                System.out.println("Error with Ceasar Initialization");
        }
    }

    private String encrypt(String m, int k) {
        System.out.println("Encrypting " + m);

        String answer = "";
        for (int i = 0; i < m.length(); i++)
            answer = answer + shiftLetter(m.charAt(i),k);
        return answer;
    }

    private char shiftLetter(char c, int k){
        if('a'<=c && c<='z')
	  {
		  c=(char)((int)c+k);
          if(c>'z') 
            c=(char)((int)c-26);
	  }
	  if('A'<=c && c<='Z')
	  {
		  c=(char)((int)c+k);
          if(c>'Z') 
            c=(char)((int)c-26);
	  }
	  return c;
    }

    private String decrypt(String m, int k) {
        System.out.println("Decrypting " + m);        
        k = 26 - k;

        String answer = "";
        for (int j = 0; j < m.length(); j++) {
            answer = answer + shiftLetter(m.charAt(j),k);
        }

        return answer;
    }
}
