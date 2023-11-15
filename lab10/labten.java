import java.util.ArrayList;
import java.util.List;

/**
 * Lab 10
 *
 * @author (Tyler Depa)
 * @version (v1.0 11-15-2023)
 */

public class labten {
    public static void main(String[] args) {
        P1();
    }
    
    static void P1() {

        // Change all loops to use the enhanced for-loop we discussed in lect17.
        // After you get all three of the original loops to work with enhanced for-loops add the
        // following lines of code:
        // System.out.println("pets contains Astro? " + pets.contains(new Dog(14, "Astro")));
        // System.out.println("Is it true Astro is removed " + pets.remove(new Dog(14, "Astro")));
        // System.out.println(pets);
        // Output from the above 3 lines should be:
        // pets contains Astro true
        // Is it true Astro is removed true
        // [Rover is a dog, Felix is a cat, Garfield is a cat, Ren is a dog]

        List<Animal> pets = new ArrayList<>(7); // arraylist to hold Animal objects

        pets.add(new Dog(12, "Rover"));
        pets.add(new Cat(7,  "Felix"));
        pets.add(new Cat(6.5,"Garfield"));
        pets.add(new Dog(15, "Ren"));
        pets.add(new Dog(14, "Astro"));
        pets.add(new Duck(3, "Jeff"));
        pets.add(new Turtle(2, "Frank"));
        
        for (int i = 0; i < pets.size(); i++)
        {
            System.out.println("The pet's name is " + pets.get(i).GetName());
            System.out.println("It weighs " + pets.get(i).GetWeight());
            pets.get(i).Sound();
            pets.get(i).Eat();
            System.out.println();
        }

        System.out.println("pets contains Astro? " + pets.contains(new Dog(14, "Astro")));
        System.out.println("Is it true Astro is removed " + pets.remove(new Dog(14, "Astro")));
        System.out.println(pets);
        
        // use the Animal getter and setter methods to allow the pets to gain some weight
        for (int i = 0; i < pets.size(); i++)
        {
           double weight = pets.get(i).GetWeight();
           weight = weight + 0.5;
           pets.get(i).SetWeight(weight);
        }
        
        System.out.println("-----------------------------------------\n");
        System.out.println("After the pets have been eating the great pet food for a month!!!");
        
        for (int i = 0; i < pets.size(); i++)
        {
            System.out.println("The pet's name is " + pets.get(i).GetName());
            System.out.println("It weighs " + pets.get(i).GetWeight());
            pets.get(i).Sound();
            pets.get(i).Eat();
            System.out.println();
        }
    }
}