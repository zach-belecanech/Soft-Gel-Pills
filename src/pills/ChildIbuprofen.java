package pills;

public class ChildIbuprofen extends Ibuprofen {

    public static double STRENGTH = 50;
    public static double SIZE = 1.2;
    public static String COLOR = "pink";
    
    protected ChildIbuprofen(String casing, String solution, String active) {
        super(STRENGTH, SIZE, COLOR, casing, solution, active);
    }

    public void accept(Inspector inspector){
        inspector.inspect(this);
    }
}
