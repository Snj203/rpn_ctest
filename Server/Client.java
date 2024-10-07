import java.net.Socket;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;

public class Client implements Runnable {

    private final Socket socket;
    private Thread thread;

    public Client(Socket socket) {
        this.socket = socket;
        thread = new Thread(this);
    }

    public void run() {
        System.out.println("|||||||||||||||||||||||||||||||||||||||");
        System.out.println("[" + socket + "];");
        System.out.println("-----------------------------------");

        String text = readData();
        System.out.println("Infix : [" + text + "] FROM CLIENT");
        System.out.println("-----------------------------------");
        text = text.substring(7, text.length());

        String postfixForm = RPN.toPostfix(text);
        System.out.println("Raw Postfix : [" + postfixForm + "] TO CLIENT");
        sendMessage(postfixForm);
        System.out.println("-----------------------------------");

        String postfixFormString = readData();
        System.out.println("Postfix : [" + postfixFormString + "] FROM CLIENT");
        System.out.println("-----------------------------------");

        postfixFormString = postfixFormString.substring(4, postfixFormString.length());
        Double result = RPN.doMath(postfixFormString); ///!!!!!!!!!! calc postfix form
        System.out.println("Result : [" + result + "] TO CLIENT");
        sendMessage(String.valueOf(result));
        System.out.println("-----------------------------------");

        try {
            socket.close();
        } catch (IOException ioe) {
            System.out.println("Socket error "+ ioe);
        }
    }

    public void go() {
        thread.start();
    }
    private void sendMessage(String text) {
        byte[] array = text.getBytes();
        try {
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(array);
            outputStream.flush();
        } catch (IOException ioe) {
            System.out.println("Client Error " + ioe);
        }
    }

    public String readData() {
        try {
            String text = "";
            InputStream input = socket.getInputStream();
            while(true) {
                int unicode = input.read();
                char symbol = (char) unicode;
                text = text + symbol;
                if (input.available() == 0) {
                    break;
                }
            }
            return text;
        } catch (IOException ioe) {
            System.out.println("Client error " + ioe);
            return null;
        }
    }
}
