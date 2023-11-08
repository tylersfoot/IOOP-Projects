public abstract class Person {

    private int id;
    private String lastName;
    private static int nPeople = 0;

    /**
     * Constructor for a person (worker) with a specified id and last name.
     *
     * @param id the id of the person
     * @param lastName the last name of the person
     */
    public Person(int id, String lastName) {
        this.id = id;
        this.lastName = lastName;
        nPeople++;
    }

    /**
     * Returns how many people there are.
     * 
     * @return how many people there are
     */
    public static int HowMany() {
        return nPeople;
    }

    /**
     * Gets the id of the person.
     * 
     * @return the id of the person
     */
    public int GetId() {
        return this.id;
    }

    /**
     * Gets the last name of the person.
     * 
     * @return the last name of the person
     */
    public String GetLastName() {
        return this.lastName;
    }

    /**
     * Sets the id of the person.
     * 
     * @param id the id of the person
     */
    public void SetId(int id) {
        this.id = id;
    }

    /**
     * Sets the last name of the person.
     * 
     * @param lastName the last name of the person
     */
    public void SetLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Computes the salary of the person.
     */
    public abstract double ComputeSalary();


    /**
     * Overrides the toString method to print out id and last name.
     */
    @Override
    public String toString() {
        return (this.id + " " + this.lastName);
    }
}
