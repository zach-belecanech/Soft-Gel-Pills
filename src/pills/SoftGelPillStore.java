package pills;

import java.util.ArrayList;
import java.util.Scanner;

public class SoftGelPillStore {
    private PillFactory pillFactory;
    private ArrayList<GelCap> pillsOrdered;
    private Scanner keyboard;
    private String userName;
    private int userAge;
    private boolean loggedIn;
    public SoftGelPillStore() {
        pillsOrdered = new ArrayList<GelCap>();
    }

    public void logIn() {
        keyboard = new Scanner (System.in);
        System.out.println("Log in:");
        try {
            System.out.print("Your Name: ");
            userName = keyboard.nextLine();
            System.out.print("Your Age: ");
            userAge = keyboard.nextInt();
            while (userAge < 0) {
                System.out.println("Please enter a valid age");
                System.out.print("Your Age: ");
                userAge = keyboard.nextInt();
            }
            if (userAge >= 18) {
                loggedIn = true;
                this.pillFactory = AdultPillFactory.getInstance();
            }
            else {
                this.pillFactory = ChildPillFactory.getInstance();
                loggedIn = true;
            }
            System.out.println();
            if (loggedIn) {
                System.out.println("You have successfully logged in!");
            }
            
        } catch (Exception e) {
            System.out.println("incorrect information, please try again");
            logIn();
        }
        
    }

    public GelCap[] logOut() {
        userName = null;
        userAge = 0;
        loggedIn = false;
        GelCap[] ans = new GelCap[pillsOrdered.size()];
        boolean consistent = consistentOrder();
        if (!consistent) {
            System.out.println("We cannot complete your order because it was inconsistent.");
            return null;
        }
        for (int i = 0; i < pillsOrdered.size(); ++i) {
            ans[i] = pillsOrdered.get(i);
        }
        return ans;


    }

    public void order() {
        System.out.println("Menu:");
        System.out.println("1) Order Ibuprofen");
        System.out.println("2) Order Retinol");
        String choice = keyboard.nextLine();
        if (choice.equals("1")) {
            GelCap i = pillFactory.manufactureIbuprofen();
            pillsOrdered.add(i);
            System.out.println(i.toString());
        } 
        if (choice.equals("2")) {
            GelCap r = pillFactory.manufactureRetinol();
            pillsOrdered.add(r);
            System.out.println(r.toString());
        } 
        if (!choice.equals("1") && !choice.equals("2")) {
            System.out.println("Not on the menu, please try again");
            order();
        }
    }

    public void printOrderDescription() {
        System.out.println("You have ordered " + pillsOrdered.size() + " pills");
        for (int i = 0; i < pillsOrdered.size(); i++) {
            System.out.println("Pill #" + (i+1));
            System.out.println(pillsOrdered.get(i).description());
            System.out.println();
        }
    }

    public void calcStrengths() {
        StrengthInspector inspectorTren = new StrengthInspector();
        for (int i = 0; i < pillsOrdered.size(); ++i) {
            pillsOrdered.get(i).accept(inspectorTren);
        }
        System.out.println(inspectorTren.report());
    }

    private Boolean consistentOrder() {
        ConsistencyInspector inspectorGadget = new ConsistencyInspector();
        boolean ans = false;
        for (int i = 0; i < pillsOrdered.size(); ++i) {
            pillsOrdered.get(i).accept(inspectorGadget);
        }
        ans = inspectorGadget.soFarSoConsistent();
        return ans;
    }

    protected void finalize() {
        keyboard.close();
    }

}