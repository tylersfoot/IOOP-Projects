public class CommissionedWorker extends Person {

    private double totalSales; // total number of sales
    private double commissionRate; // commission rate
    
    /**
     * Constructor for a commissioned worker with a specified id, last name, sales amount, and commission rate.
     * 
     * @param id the id
     * @param lastName the last name
     * @param totalSales the amount of sales
     * @param commissionRate the commission rate
     */
    public CommissionedWorker(int id, String lastName, double totalSales, double commissionRate) {
        super(id, lastName);
        this.totalSales = totalSales;
        this.commissionRate = commissionRate;
    }

    /**
     * Returns the salary of the commissioned worker
     */
    @Override
    public double ComputeSalary() {
        return totalSales * commissionRate;
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
