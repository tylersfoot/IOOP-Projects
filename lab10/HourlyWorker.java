public class HourlyWorker extends Person {

    private int hoursWorked; // number of hours worked
    private double payRate; // hourly pay rate
    
    /**
     * Constructor for an hourly worker with a specified id, last name, hours worked, and hourly pay rate.
     * 
     * @param id the id
     * @param lastName the last name
     * @param hoursWorked the amount of hours worked
     * @param payRate hourly pay rate
     */
    public HourlyWorker(int id, String lastName, int hoursWorked, double payRate) {
        super(id, lastName);
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
    }

    /**
     * Returns the salary of the hourly worker
     * 
     * @return the salary of the hourly worker
     */
    @Override
    public double ComputeSalary() {
        double regularPay = hoursWorked > 40 ? 40 * payRate : hoursWorked * payRate;
        double overtimePay = hoursWorked > 40 ? (hoursWorked - 40) * (1.5 * payRate) : 0;
        return regularPay + overtimePay;
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
