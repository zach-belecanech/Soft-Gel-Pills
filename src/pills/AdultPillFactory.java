package pills;

public class AdultPillFactory extends PillFactory {

    private static AdultPillFactory instance;

    private AdultPillFactory() {
        //instance = getInstance();
    }

    public static AdultPillFactory getInstance() {
        if (instance == null) {
            synchronized(AdultPillFactory.class) {
                if (instance == null) {
                    instance = new AdultPillFactory();
                }
            }
        }
        return instance;
    }

    @Override
    protected Ibuprofen assembleIbuprofen (String casing, String solution, String active) {
        return new AdultIbuprofen(casing, solution, active);
    }

    @Override
    protected Retinol assembleRetinol (String casing, String solution, String active) {
        return new AdultRetinol(casing, solution, active);
    }
}
