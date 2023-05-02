import java.io.*;
// import java.io.FileInputStream;
// import java.io.ObjectInputStream;


public class Client {

    /**
     * This method name and parameters must remain as-is
     */
    public static int add(int lhs, int rhs) {
        // connect to server
        // create an instance of the RemoteMethod
        // RemoteMethod add = new RemoteMethod("add", new Objects[]{lhs, rhs});
        // ObjectOutputStsream to serialize the add instance
        // OutputStream os = socket.getOutputStream();
        int sum = lhs + rhs;
        return sum;
    }
    /**
     * This method name and parameters must remain as-is
     */
    public static int divide(int num, int denom) {
        int quotient = (num / denom);
        return quotient;
    }
    /**
     * This method name and parameters must remain as-is
     */
    public static String echo(String message) {
        String response = "You said " + message + "!";
        //System.out.print(response);
        return response;
    }

    // Do not modify any code below this line
    // --------------------------------------
    String server = "localhost";
    public static final int PORT = 10314; 
    
    public static void main(String... args) throws Exception {
        // All of the code below this line must be uncommented
        // to be successfully graded.

        // Is it fine that this is in main even though it's below the line? 
        Echo echo = null;
        
        try (FileInputStream fos = new FileInputStream("echo.stub");
            ObjectInputStream oos = new ObjectInputStream(fos)) {
                echo = (Echo)oos.readObject();
            } 
            // I think this specific catch needs to be elsewhere but idk where.
            catch (IOException ex) {
                System.out.print("Server isn't listening - run the server and try again!");
                ex.printStackTrace();
            }
        System.out.println(echo.echo("Roger"));
    
        System.out.print("Testing... ");

        if (add(2, 4) == 6)
            System.out.print(".");
        else
            System.out.print("X");

        try {
            divide(1, 0);
            System.out.print("X");
        }
        catch (ArithmeticException x) {
            System.out.print(".");
        }

        if (echo("Hello").equals("You said Hello!"))
            System.out.print(".");
        else
            System.out.print("X");
        
        System.out.println(" Finished");
    }
}