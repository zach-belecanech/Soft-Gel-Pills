package pills;

public class AdultIbuprofen extends Ibuprofen {

    public static double STRENGTH = 200;
    public static double SIZE = 4.4;
    public static String COLOR = "white";

    protected AdultIbuprofen(String casing, String solution, String active) {
        super(STRENGTH, SIZE, COLOR, casing, solution, active);
    }

    public void accept(Inspector inspector){
        inspector.inspect(this);
    }
}
