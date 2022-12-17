package pills;

public class NullIbuprofen extends Ibuprofen {
    

    protected NullIbuprofen() {
        super(0, 0, "Null", null, null, null);
    }

    public void accept(Inspector inspector){
        inspector.inspect(this);
    }
}
