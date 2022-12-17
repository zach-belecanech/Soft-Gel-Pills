package pills;

public class NullRetinol extends Retinol{
    protected NullRetinol() {
        super(0, 0, "Null", null, null, null);
    }

    public void accept(Inspector inspector){
        inspector.inspect(this);
    }
}
