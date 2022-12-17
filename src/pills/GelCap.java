package pills;
public abstract class GelCap {

    protected String name;
    protected double strength;
    protected double size;
    protected String color;
    protected String casing;
    protected String solution;
    protected String active;

    protected GelCap(String name, double strength, double size, String color, String casing, String solution, String active) {
        this.name = name;
        this.strength = strength;
        this.size = size;
        this.color = color;
        this.casing = casing;
        this.solution = solution; 
        this.active = active;
      //  manufacture(); this will be changed in next story
    }
    
    public String getName() {
        return name;
    }

    public double getStrength() {
        return strength;
    }

    public double getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public String getOuterCasing() {
        return casing;
    }

    public String getAqueousSolution() {
        return solution;
    }

    public String getActiveIngredient() {
        return active;
    }

    @Override
    public String toString() {
        return "Name: " + name + " Strength (mg): " + strength + " Size (mm): " + size + " Color: " + color;
                
    }

    public String description() {
        return "The pill " + name + " is a " + color + 
                " colored " + size + " milimeter pill that comes in a dosage of " + strength +
                " mg. The outer casing is made of a " + casing + 
                " and the solution inside is " + solution + " with the active ingredient being " +
                active + ".";
    }

    public abstract void accept(Inspector inspect);
}

