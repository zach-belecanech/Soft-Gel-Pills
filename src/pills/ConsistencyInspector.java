package pills;

public class ConsistencyInspector extends Inspector {
    private int adultCount;
    private int childCount;

    public void inspect(AdultIbuprofen e){
        ++adultCount;
    }

    public void inspect(ChildIbuprofen e){
        ++childCount;
    }

    public void inspect(NullIbuprofen e){

    }

    public void inspect(AdultRetinol e){
        ++adultCount;
    }

    public void inspect(ChildRetinol e){
        ++childCount;
    }

    public void inspect(NullRetinol e){

    }

    public String report() {
        return "There are " + adultCount 
                + " milligrams of adult pills and "
                + childCount + " milligrams of child pills.";
    }

    public Boolean soFarSoConsistent() {
        if (childCount == 0 || adultCount == 0) {
            return true;
        }
        return false;
    }
}
