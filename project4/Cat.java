public class Cat extends Animal {

    /**
     * Constructor for a cat with a specified weight and name.
     *
     * @param weight the weight of the cat in pounds
     * @param name the name of the cat
     */
    public Cat(double weight, String name) {
        super(weight, name);
    }

    /**
     * Prints out the sound of the cat.
     */
    @Override
    public void Sound() {
        System.out.println("Meow!, Meow!!");
    }

    /**
     * Prints out what the cat eats.
     */
    @Override
    public void Eat() {
        System.out.println("Eating Friskies Seafood Sensations Cat Food");
    }
}
