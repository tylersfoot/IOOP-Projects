public class Intern extends Person {

    private double weeklyStipend; // weekly pay amount
    
    /**
     * Constructor for an intern with a specified id, last name, and weekly stipend amount.
     * 
     * @param id the id
     * @param lastName the last name
     * @param weeklyStipend the weekly stipend
     */
    public Intern(int id, String lastName, double weeklyStipend) {
        super(id, lastName);
        this.weeklyStipend = weeklyStipend;
    }

    /**
     * Returns the salary of the intern
     * 
     * @return the weekly salary of the intern
     */
    @Override
    public double ComputeSalary() {
        return weeklyStipend;
    }

    /**
     * Overrides the toString method to print out id, last name, and salary.
     */
    @Override
    public String toString()
    {
        return (super.toString() + " " + this.ComputeSalary());
    }
}
