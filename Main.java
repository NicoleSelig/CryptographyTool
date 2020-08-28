

public class Main {

    public static void main(final String[] args) {
        Menu menu = new Menu();
        Utils utils = new Utils();

        System.out.println("");
        System.out.println("Cryptography Tool");
        System.out.println("By Nicole Selig");
        System.out.println("");

        String filePath = utils.getFilePath();
        String text = utils.getMessage(filePath);

        Message message = new Message(text, filePath);
        message.printFilePath(filePath);
        message.printMessage(text);

        menu.initCipherMenu();
        menu.chooseCipher();
    }

}






