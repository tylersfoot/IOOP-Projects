public class Dog extends Animal {

    /**
     * Constructor for a dog with a specified weight and name.
     *
     * @param weight the weight of the dog in pounds
     * @param name the name of the dog
     */
    public Dog(double weight, String name) {
        super(weight, name);
    }

    /**
     * Prints out the sound of the dog.
     */
    @Override
    public void Sound() {
        System.out.println("Bark!, Bark!!");
    }

    /**
     * Prints out what the dog eats.
     */
    @Override
    public void Eat() {
        System.out.println("Eating Purina Pro Plan High Protein Dog Food");
    }
}
