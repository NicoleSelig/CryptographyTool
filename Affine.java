public class Affine {
    Menu menu = new Menu();
    Utils utils = new Utils();

    public void init(){
        System.out.println("Affine Cipher");
        String filepath = utils.getFilePathFromFile();
        String text = utils.getMessageFromFile(filepath);

        String cryptChoice = menu.initCryptMenu();

        int key = utils.getIntKey();
        
        switch(cryptChoice){
            case "e":
            case "E":
                String encryption = encrypt(text);
                System.out.println(encryption);
                break;
            case "d":
            case "D":
                String decryption = decrypt(text);
                System.out.println(decryption);
                break;
            default:
                System.out.println("Error with Affine Initialization");
        }
    }

    private String encrypt(String m) {
        System.out.println("Encrypting " + m);
        return "Encrypting";
    }

    private String decrypt(String m) {
       System.out.println("Decrypting " + m);
       return "Decrypting";
    }
}
