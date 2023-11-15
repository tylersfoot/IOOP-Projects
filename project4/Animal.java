public abstract class Animal {

    private double weight; // in lbs
    private String name;

    /**
     * Constructor for an animal with a specified weight and name.
     *
     * @param weight the weight of the dog in pounds
     * @param name the name of the dog
     */
    public Animal(double weight, String name) {
        this.weight = weight;
        this.name = name;
    }

    /**
     * Gets the weight of the animal.
     * 
     * @return the weight of the animal in pounds
     */
    public double GetWeight() {
        return this.weight;
    }

    /**
     * Gets the name of the animal.
     * 
     * @return the name of the animal
     */
    public String GetName() {
        return this.name;
    }

    /**
     * Sets the weight of the animal.
     * 
     * @param weight the weight of the animal in pounds
     */
    public void SetWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public void toString() {
        System.out.println(GetName() + " is a " + )
    }

    /**
     * Represents the sound the animal makes.
     */
    public abstract void Sound();

    /**
     * Represents the eating behavior of the animal.
     */
    public abstract void Eat();
}
