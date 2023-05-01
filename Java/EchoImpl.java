import java.rmi.*;
import java.rmi.server.*;

public class EchoImpl extends UnicastRemoteObject implements Echo {
    public EchoImpl() throws RemoteException { super(); }

    public String echo(String message) throws RemoteException {
        return message + " " + message;
    }
}