public class Person {
    private int id;
    private String firstName;
    private String lastName; // compute only when min/max change
    
    // default constructor
    public Person() {
        this.id = 0;
        this.firstName = "John";
        this.lastName = "Doe";

    }
    
    // parametric constructor
    public Person(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // id getter
    public int getId() {
        return this.id;
    }

    // id setter
    public void setId(int id) {
        this.id = id;
    }
    
    // first name getter
    public String getFirstName() {
        return this.firstName;
    }
    
    // first name setter
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    // last name getter
    public String getLastName() {
        return this.lastName;
    }
    
    // last name setter
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "id = " + this.id + " " + this.firstName + " " + this.lastName;
    }
}
