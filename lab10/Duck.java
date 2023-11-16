public class Duck extends Animal {

    /**
     * Constructor for a duck with a specified weight and name.
     *
     * @param weight the weight of the duck in pounds
     * @param name the name of the duck
     */
    public Duck(double weight, String name) {
        super(weight, name);
    }

    @Override
    public String toString() {
        return GetName() + " is a duck";
    }

    /**
     * Prints out the sound of the duck.
     */
    @Override
    public void Sound() {
        System.out.println("Quack!, Quack!!");
    }

    /**
     * Prints out what the duck eats.
     */
    @Override
    public void Eat() {
        System.out.println("Eating Grapes from the Lemonade Stand");
    }
}
