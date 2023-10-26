import java.util.Random;

public class RandomInteger {
    private int min;
    private int max;
    private int range; // compute only when min/max change
    
    // default constructor
    public RandomInteger() {
        this.min = 0;
        this.max = 1;
        computeRange();
    }
    
    // parametric constructor
    public RandomInteger(int min, int max) {
        this.min = min;
        this.max = max;
        computeRange();
    }
    
    // min getter
    public int getMin() {
        return this.min;
    }
    
    // min setter
    public void setMin(int min) {
        this.min = min;
        computeRange();
    }
    
    // max getter
    public int getMax() {
        return this.max;
    }
    
    // max setter
    public void setMax(int max) {
        this.max = max;
        computeRange();
    }
    
    // generate number with range
    public int generate() {
        Random rand = new Random();
        return rand.nextInt(range) + min;
    }
    
    // compute the range
    private void computeRange() {
        this.range = max - min + 1;
    }
}
