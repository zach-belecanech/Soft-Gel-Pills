package pills;

public class ChildRetinol extends Retinol {

    public static double STRENGTH = 0.2;
    public static double SIZE = 0.8;
    public static String COLOR = "cyan";

    protected ChildRetinol(String casing, String solution, String active) {
        super(STRENGTH, SIZE, COLOR, casing, solution, active);
    }

    public void accept(Inspector inspector){
        inspector.inspect(this);
    }
}
