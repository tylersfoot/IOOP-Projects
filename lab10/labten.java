import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Lab 10
 *
 * @author (Tyler Depa)
 * @version (v1.0 11-15-2023)
 */

public class labten {
    public static void main(String[] args) {
        P1();
        // P2();
    }
    
    static void P1() {

        List<Animal> pets = new ArrayList<>(7); // arraylist to hold Animal objects

        pets.add(new Dog(12, "Rover"));
        pets.add(new Cat(7,  "Felix"));
        pets.add(new Cat(6.5,"Garfield"));
        pets.add(new Dog(15, "Ren"));
        pets.add(new Dog(14, "Astro"));
        pets.add(new Duck(3, "Jeff"));
        pets.add(new Turtle(2, "Frank"));
        
        for (Animal animal : pets) {
            System.out.println("The pet's name is " + animal.GetName());
            System.out.println("It weighs " + animal.GetWeight());
            animal.Sound();
            animal.Eat();
            System.out.println();
        }

        System.out.println("pets contains Astro? " + pets.contains(new Dog(14, "Astro")));
        System.out.println("Is it true Astro is removed " + pets.remove(new Dog(14, "Astro")));
        System.out.println(pets);
        
        // use the Animal getter and setter methods to allow the pets to gain some weight
        for (Animal animal : pets) {
           animal.SetWeight(animal.GetWeight() + 0.5);
        }
        
        System.out.println("-----------------------------------------\n");
        System.out.println("After the pets have been eating the great pet food for a month!!!");
        
        for (Animal animal : pets) {
            System.out.println("The pet's name is " + animal.GetName());
            System.out.println("It weighs " + animal.GetWeight());
            animal.Sound();
            animal.Eat();
            System.out.println();
        }
    }

    static void P2() {

        LinkedList<Person> people = new LinkedList<>();
    
        people.add(new HourlyWorker(101, "Smith", 50, 10.25));
        people.add(new CommissionedWorker(123, "Jones", 10000.0, 0.10));
        people.add(new Intern(120, "Wilson", 120.00));
        people.add(new HourlyWorker(103, "Williams", 50, 20.25));
        people.add(new CommissionedWorker(140, "Decker", 35000.0, 0.10));
        people.add(new Intern(129, "Brown", 105.00));
        people.add(new HourlyWorker(113, "Miller", 55, 30.25));
        people.add(new CommissionedWorker(150, "Davis", 15000.0, 0.20));
        people.add(new Intern(180, "Adams", 100.00));
        people.add(new HourlyWorker(119, "Murphy", 55, 30.50));
        
        for (Person person : people) {
           System.out.println(person); 
        }

        System.out.println();
        System.out.println("id             Name    Salary");

        for (Person person : people) {
           System.out.printf("%d %15s  $%8.2f\n", person.GetId(), person.GetLastName(), person.ComputeSalary());
        }

        ListIterator iterator = people.listIterator();

        System.out.println("Iterate in order");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("Iterate in reverse order");
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
    }
}