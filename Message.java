
public class Message {
    String message;
    String filePath;

    //constructor
    public Message (String message, String filePath){
        this.filePath = filePath;
        this.message = message;
    }

    public void printMessage(String message){
        System.out.println(message);
    }

    public void printFilePath(String filePath){
        System.out.println(filePath);
    }


}