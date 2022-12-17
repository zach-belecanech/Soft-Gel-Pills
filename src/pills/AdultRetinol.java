package pills;

public class AdultRetinol extends Retinol {

    public static double STRENGTH = 0.6;
    public static double SIZE = 2.0;
    public static String COLOR = "tan";

    protected AdultRetinol(String casing, String solution, String active) {
    super(STRENGTH, SIZE, COLOR, casing, solution, active);
    }

    public void accept(Inspector inspector){
        inspector.inspect(this);
    }
}
