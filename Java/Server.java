import java.io.*;
import java.net.ServerSocket;
import java.rmi.*;
import java.rmi.server.*;

public class Server {
    public static void main(String[] args) throws Exception {
        EchoImpl ei = new EchoImpl();
        Remote stub = UnicastRemoteObject.toStub(ei);

        // Do I need to do this ServerSocket setup? I pass tests without it but cannot 
        // get Exception info that I want
        ServerSocket server = new ServerSocket(10314);
        try (FileOutputStream fos = new FileOutputStream("echo.stub");
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(stub);
            }
            catch (IOException ex) {
                System.out.println("Server not listening");
                ex.printStackTrace();
            } 
            // ServerSocket server = new ServerSocket(port:10314);
            // read the bytes
            // deserialize using ObjectInputStream
        // ) catch (Execption ex)
    }

    // Do not modify any code below tihs line
    // --------------------------------------
    public static String echo(String message) { 
        return "You said " + message + "!";
    }
    public static int add(int lhs, int rhs) {
        return lhs + rhs;
    }
    public static int divide(int num, int denom) {
        if (denom == 0)
            throw new ArithmeticException();

        return num / denom;
    }
}