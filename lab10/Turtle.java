public class Turtle extends Animal {

    /**
     * Constructor for a turtle with a specified weight and name.
     *
     * @param weight the weight of the turtle in pounds
     * @param name the name of the turtle
     */
    public Turtle(double weight, String name) {
        super(weight, name);
    }

    @Override
    public String toString() {
        return GetName() + " is a turtle";
    }

    /**
     * Prints out the sound of the turtle.
     */
    @Override
    public void Sound() {
        System.out.println("Snap!, Snap!!");
    }

    /**
     * Prints out what the turtle eats.
     */
    @Override
    public void Eat() {
        System.out.println("Eating Fresh and Juicy Watermelon");
    }
}
