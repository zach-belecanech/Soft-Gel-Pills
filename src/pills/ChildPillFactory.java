package pills;

public class ChildPillFactory extends PillFactory{

    private static ChildPillFactory instance;

    private ChildPillFactory() {
        //instance = getInstance();
    }

    public static ChildPillFactory getInstance() {
        if (instance == null) {
            synchronized(ChildPillFactory.class) {
                if (instance == null) {
                    instance = new ChildPillFactory();
                }
            }
        }
        return instance;
    }


    protected Ibuprofen assembleIbuprofen (String casing, String solution, String active) {
        return new ChildIbuprofen(casing, solution, active);
    }

    protected Retinol assembleRetinol (String casing, String solution, String active) {
        return new ChildRetinol(casing, solution, active);
    }
}
