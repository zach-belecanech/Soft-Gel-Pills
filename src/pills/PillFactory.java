package pills;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Random;

public abstract class PillFactory {
    private static CasingType IBUPROFEN_CASING; //= new GelatinCasing();
    private static SolutionType IBUPROFEN_SOLUTION; //= new SalineSolution();
    private static ActiveType IBUPROFEN_ACTIVE; //= new IbuprofenActive();
    private static CasingType RETINOL_CASING; //= new PlasticizerCasing();
    private static SolutionType RETINOL_SOLUTION; //= new OilSolution();
    private static ActiveType RETINOL_ACTIVE; //= new RetinolActive();

    protected PillFactory() {
        try {
            IBUPROFEN_CASING = (CasingType) Naming.lookup("rmi://152.10.10.77/GelatinCasing");
            IBUPROFEN_SOLUTION = (SolutionType) Naming.lookup("rmi://152.10.10.77/SalineSolution");
            IBUPROFEN_ACTIVE = (ActiveType) Naming.lookup("rmi://152.10.10.77/IbuprofenActive");
            RETINOL_CASING = (CasingType) Naming.lookup("rmi://152.10.10.77/PlasticizerCasing");
            RETINOL_SOLUTION = (SolutionType) Naming.lookup("rmi://152.10.10.77/OilSolution");
            RETINOL_ACTIVE = (ActiveType) Naming.lookup("rmi://152.10.10.77/RetinolActive");
        }
        catch (RemoteException e) {
            System.out.println("Could not connect to the server.");
        } 
        catch (NotBoundException e) {
            System.out.println("Encountered a Not Bound Exception.");
        }
        catch (MalformedURLException e) {
            System.out.println("URL is not correct, cannot connect.");
        }
    
        
    }

    public final Ibuprofen manufactureIbuprofen () {
        System.out.print("Manufacturing Ibuprofen pill...");
        Ibuprofen p;
        try {
            p = assembleIbuprofen(
            IBUPROFEN_CASING.generateCasing(),
            IBUPROFEN_SOLUTION.generateSolution(),
            IBUPROFEN_ACTIVE.generateActive());
        }
        catch (RemoteException e) {
            p = new NullIbuprofen();
        }
        
        System.out.print("Performing quality check... ");
        Boolean iqCheck = qualityCheck(p);
        if (iqCheck == false) {
            return p.NULL;
        }
        System.out.println("Completed");
        return p;
    }

    public final Retinol manufactureRetinol () {
        System.out.print("Manufacturing Retinol pill...");
        Retinol p;
        try {
            p = assembleRetinol(
            RETINOL_CASING.generateCasing(),
            RETINOL_SOLUTION.generateSolution(),
            RETINOL_ACTIVE.generateActive());
            
        }
        catch (RemoteException e) {
            p = new NullRetinol();
        }
        
        System.out.print("Performing quality check... ");
        Boolean rqCheck = qualityCheck(p);
        if (rqCheck == false) {
            return p.NULL;
        }
        System.out.println("Completed");
        return p;
    } 

    private final boolean qualityCheck(GelCap pill) {
        Random rando = new Random();
        int chance = rando.nextInt(100);
        if (chance < 5) {
            return false;
        }
        return true;
    }

    protected abstract Ibuprofen assembleIbuprofen (String casing, String solution, String active);

    protected abstract Retinol assembleRetinol (String casing, String solution, String active);

}


