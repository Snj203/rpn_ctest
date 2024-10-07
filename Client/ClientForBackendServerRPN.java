import java.net.Socket;
import java.net.UnknownHostException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.util.Scanner;

public class ClientForBackendServerRPN {

    private Socket socket;

    private static boolean checkInfix(String s){
      for(int i = 0; i < s.length()-2;i++){
        if((s.charAt(i) == '*' || s.charAt(i) == '/' || s.charAt(i) == '+') && (s.charAt(i + 1) == '*' || s.charAt(i + 1) == '/' || s.charAt(i + 1) == '+')){
          return true;
        }
      }
      return false;
    }

    public ClientForBackendServerRPN(String host, int port) {
        try {
            socket = new Socket(host, port);
        } catch (UnknownHostException uhe) {
            System.out.println("Error: " + uhe);
        } catch (IOException ioe) {
            System.out.println("Error: " + ioe);
        }
    }

    public void sendMessage(String text) {
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


    public static String doRPN(String infix) {

        ClientForBackendServerRPN client =
        new ClientForBackendServerRPN("209.38.241.42",9876);

        if(checkInfix(infix)){
          return("Oops something gone wrong!");
        }
        System.out.println("Infix :[" + infix + "] TO SERVER");
        client.sendMessage("Bearer " + infix);
        System.out.println("-----------------------------------");

        String postfixForm = client.readData();
        if(postfixForm.substring(0,3).equals("ERR")){
          return (postfixForm.substring(3,postfixForm.length()));
        }
        System.out.println("Raw Postfix form :[" + postfixForm + "] FROM SERVER");
        System.out.println("-----------------------------------");

        //OPERATE WITH POSTIFX FROM SERVER HERE

        client.sendMessage("RPN " + postfixForm);

        String result = client.readData();
        System.out.println("Result :[" + result + "] FROM SERVER");
        System.out.println("-----------------------------------");
        return result;
    }
}
