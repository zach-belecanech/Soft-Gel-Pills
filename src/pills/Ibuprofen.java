package pills;

public abstract class Ibuprofen extends GelCap {
    public static NullIbuprofen NULL = new NullIbuprofen();
    
    protected Ibuprofen (double strength, double size, String color, String casing, String solution, String active) {
        super("Ibuprofen", strength, size, color, casing, solution, active);        
    }

    
}
