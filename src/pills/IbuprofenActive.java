package pills;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Concrete strategy for generating ibuprofen.
 * Remotely accessible on Java RMI.
 * 
 * @author Willow Sapphire
 * @version 10/18/2022
 */
public class IbuprofenActive extends UnicastRemoteObject implements ActiveType {

    /**
     * Creates an Ibuprofen active strategy object.
     * 
     * @param port - the port on which to listen
     * @throws RemoteException - thrown if something goes wrong in the Java RMI
     */
    protected IbuprofenActive(int port) throws RemoteException {
        super(port);
    }

    @Override
    public String generateActive() throws RemoteException{
        return "Ibuprofen";
    }
}
