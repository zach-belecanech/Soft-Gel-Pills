package pills;

import java.util.Scanner;

/**
 * Driver class to manually test the pills project.
 * 
 * @author Willow Sapphire
 * @version 09/26/2022
 */
public class Driver {
    /**
     * Main method to experiment with pills.
     * @param args - unused
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        SoftGelPillStore store = new SoftGelPillStore();
        store.logIn();
        char choice = 'y';
        while (choice == 'y') {
            System.out.print("Would you like to order? (y/n) ");
            choice = keyboard.nextLine().toLowerCase().charAt(0);
            if (choice == 'y') {
                store.order();
            } else if (choice != 'n') {
                System.out.println("Not a valid input, please enter (y/n) ");
                choice = 'y';
            }
        }
        System.out.println("Here is your entire order:");
        store.printOrderDescription();
        keyboard.close();
    }
}
