package pills;

public abstract class Retinol extends GelCap{
    public static NullRetinol NULL = new NullRetinol();
    
    protected Retinol (double strength, double size, String color, String casing, String solution, String active) {
        super("Retinol", strength, size, color, casing, solution, active);
    }
}
