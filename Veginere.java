public class Veginere {
    Menu menu = new Menu();
    Utils utils = new Utils();

    public void init(){
        System.out.println("Veginere Cipher");
        String filepath = utils.getFilePathFromFile();
        String text = utils.getMessageFromFile(filepath);

        String cryptChoice = menu.initCryptMenu();

        int key = utils.getIntKey();
        
        switch(cryptChoice){
            case "e":
            case "E":
                //String encryption = encrypt(text, key);
                System.out.println("encryption");
                break;
            case "d":
            case "D":
                //String decryption = decrypt(text, key);
                System.out.println("decryption");
                break;
            default:
                System.out.println("Error with Ceasar Initialization");
        }

    }  
}
