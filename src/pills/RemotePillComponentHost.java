package pills;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RemotePillComponentHost {
    private static final String ADDR = "rmi://152.10.10.77/";
    public static void main(String[] args) {
        try {
            // registry saved to prevent the garbage collector from destroying it
            Registry registry = LocateRegistry.createRegistry(1099);
            Naming.rebind(ADDR + "RetinolActive", new RetinolActive(1098));
            Naming.rebind(ADDR + "IbuprofenActive", new IbuprofenActive(1097));
            Naming.rebind(ADDR + "OilSolution", new OilSolution(1096));
            Naming.rebind(ADDR + "SalineSolution", new SalineSolution(1095));
            Naming.rebind(ADDR + "GelatinCasing", new GelatinCasing(1094));
            Naming.rebind(ADDR + "PlasticizerCasing", new PlasticizerCasing(1093));
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}

