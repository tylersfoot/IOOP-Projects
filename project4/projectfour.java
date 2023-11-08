/**
 * Project 4
 *
 * @author (Tyler Depa)
 * @version (v1.0 11-8-2023)
 */

public class projectfour {
    public static void main(String[] args) {
        // P1();
        P2();
    }
    
    static void P1() {
        Animal[] pets = new Animal[7];  // array to hold Animal objects

        pets[0] = new Dog(12, "Rover");
        pets[1] = new Cat(7,  "Felix");
        pets[2] = new Cat(6.5,"Garfield");
        pets[3] = new Dog(15, "Ren");
        pets[4] = new Dog(14, "Astro");
        pets[5] = new Duck(3, "Jeff");
        pets[6] = new Turtle(2, "Frank");
        
        for (int i = 0; i < pets.length; i++)
        {
            System.out.println("The pet's name is " + pets[i].GetName());
            System.out.println("It weighs " + pets[i].GetWeight());
            pets[i].Sound();
            pets[i].Eat();
            System.out.println();
        }
        
        
        // use the Animal getter and setter methods to allow the pets to gain some weight
        for (int i = 0; i < pets.length; i++)
        {
           double weight = pets[i].GetWeight();
           weight = weight + 0.5;
           pets[i].SetWeight(weight);
        }
        
        System.out.println("-----------------------------------------\n");
        System.out.println("After the pets have been eating the great pet food for a month!!!");
        
        for (int i = 0; i < pets.length; i++)
        {
            System.out.println("The pet's name is " + pets[i].GetName());
            System.out.println("It weighs " + pets[i].GetWeight());
            pets[i].Sound();
            pets[i].Eat();
            System.out.println();
        }
    }

    static void P2() {
        // Do not modify any of the code in this code block!!!
        Person[] p = new Person[50];
    
        p[0] = new HourlyWorker(101, "Smith", 50, 10.25);
        p[1] = new CommissionedWorker(123, "Jones", 10000.0, 0.10);
        p[2] = new Intern(120, "Wilson", 120.00);
        p[3] = new HourlyWorker(103, "Williams", 50, 20.25);
        p[4] = new CommissionedWorker(140, "Decker", 35000.0, 0.10);
        p[5] = new Intern(129, "Brown", 105.00);
        p[6] = new HourlyWorker(113, "Miller", 55, 30.25);
        p[7] = new CommissionedWorker(150, "Davis", 15000.0, 0.20);
        p[8] = new Intern(180, "Adams", 100.00);
        p[9] = new HourlyWorker(119, "Murphy", 55, 30.50);
        
        for (int i = 0; i <  Person.HowMany(); i++)
        {
            System.out.println(p[i]); 
        }

        System.out.println();
        System.out.println("id             Name    Salary");
        for (int i = 0; i <  Person.HowMany(); i++)
        {
            System.out.printf("%d %15s  $%8.2f\n",p[i].GetId(), p[i].GetLastName(), p[i].ComputeSalary());
        }
    }
}