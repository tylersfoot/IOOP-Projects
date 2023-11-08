    /**
     * Overrides the toString method to print out id, last name, and salary.
     */
    @Override
    public String toString()
    {
        return (super.toString() + " " + this.ComputeSalary());
    }