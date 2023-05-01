import java.io.*;
import java.rmi.*;
import java.rmi.server.*;

public class Server {
    public static void main(String[] args) throws Exception {
        EchoImpl ei = new EchoImpl();
        Remote stub = UnicastRemoteObject.toStub(ei);

        try (FileOutputStream fos = new FileOutputStream("echo.stub");
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(stub);
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