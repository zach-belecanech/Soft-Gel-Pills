package pills;

public class StrengthInspector extends Inspector{
    private double retinolStrength = 0;
    private double ibuprofenStrength = 0;

    public void inspect(AdultIbuprofen e){
        ibuprofenStrength += e.strength;
    }

    public void inspect(ChildIbuprofen e){
        ibuprofenStrength += e.strength;
    }

    public void inspect(NullIbuprofen e){

    }

    public void inspect(AdultRetinol e){
        retinolStrength += e.strength;
    }

    public void inspect(ChildRetinol e){
        retinolStrength += e.strength;
    }

    public void inspect(NullRetinol e){

    }

    public String report() {
        return "There are " +  ibuprofenStrength
                + " milligrams of ibuprofen pills and "
                + retinolStrength + " milligrams of retinol pills.";
    }

    public Boolean soFarSoConsistent() {
        if (retinolStrength == 0 || ibuprofenStrength == 0) {
            return true;
        }
        return false;
    }
}
