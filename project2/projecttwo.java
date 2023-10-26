/**
 * Project 2
 *
 * @author (Tyler Depa)
 * @version (v1.0, 10-25-2023)
 */
import java.util.Scanner;

public class projecttwo
{
    public static void main(String[] args)
    {
        // P2();
        // P3();
        // P4();
        // P5();
    }

    /**
     * Purpose: This method generates and displays a series of random integers within a specified range.
     * It prompts the user to enter minimum and maximum values for the range and generates 5 random integers
     * within this range. The method then calculates and displays the average of these random numbers.
     *
     * void P2()
     * 
     * @param none
     * @return void
     */
    static void P2()
    {
        Scanner scanner = new Scanner(System.in);

        boolean loop = true;

        while (loop) {
            System.out.println("Enter an integer for the minimum of the range:");
            int min = scanner.nextInt();
            System.out.println("Enter an integer for the maximum of the range:");
            int max = scanner.nextInt();

            RandomInteger randomIntGenerator = new RandomInteger(min, max);

            int n = 5;
            int[] numbers = new int[0];

            System.out.println(n + " random numbers between " + randomIntGenerator.getMin() + " and " + randomIntGenerator.getMin() + " are:");

            for (int i = 0; i < n; i++) {
                int[] temp = new int[numbers.length + 1];
                for (int j = 0; j < numbers.length; j++) {
                    temp[j] = numbers[j];
                }
                temp[temp.length - 1] = randomIntGenerator.generate();

                numbers = temp;

                System.out.println(numbers[numbers.length - 1]);
            }

            System.out.println("Continue (Y/y)");
            String input = scanner.next();

            if (input.equalsIgnoreCase("n")) {
                loop = false;
                double sum = 0;
                for (int i = 0; i < numbers.length; i++) {
                    sum += numbers[i];
                }
                double average = sum / numbers.length;
                System.out.println("The average of all " + numbers.length + " random numbers is: " + average);
            }
        }

        scanner.close();
    }

    /**
     * Purpose: This method allows the user to guess a randomly generated integer between 1 and 100.
     * The user is prompted to enter an integer and is informed if their guess is too high or too low.
     * The loop continues until the user correctly guesses the integer.
     * 
     * void P3()
     * 
     * @param none
     * @return void
     */
    static void P3()
    {
        Scanner scanner = new Scanner(System.in);
        RandomInteger randomIntGenerator = new RandomInteger(1, 100);
        int number = randomIntGenerator.generate();

        boolean loop = true;
        System.out.println("Guess an integer from 1 to 100:");

        while (loop) {
            int guess = scanner.nextInt();
            if (guess < number) {
                System.out.println("Your guess is too low, try again!");
            }
            else if (guess > number) {
                System.out.println("Your guess is too high, try again!");
            }
            else if (guess == number) {
                System.out.println("Good job, your guess is correct!");
                loop = false;
            }
        }
        scanner.close();
    }

    /**
     * Purpose: Prints the details of an array of Person objects.
     * 
     * void P4()
     * 
     * @param none
     * @return void
     */
    static void P4()
    {
        Person[] people = new Person[10];
        people[0] = new Person(1000, "Joe", "Smith");
        people[1] = new Person(2000, "Jim", "Jones");
        people[2] = new Person(1050, "Bill", "Gallager");
        people[3] = new Person(1060, "Kim", "Johnson");
        people[4] = new Person(2005, "Julie", "Williams");
        people[5] = new Person(3000, "Jeff", "Garcia");
        people[6] = new Person(3050, "Jim", "Miller");
        people[7] = new Person(3075, "Tim", "Brown");
        people[8] = new Person(3080, "Tom", "Duncan");
        people[9] = new Person(4000, "Jane", "Doe");

        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i]);
        }
    }

    /**
     * Purpose: This method demonstrates the use of the CardP2 class by creating two CardP2 objects, 
     * printing their string representations, and displaying their values using the Display method.
     * 
     * void P5()
     * 
     * @param none
     * @return void
     */
    static void P5()
    {
        CardP2 card = new CardP2(7, CardP2.Suit.HEARTS);
        System.out.println(card);
        CardP2 card2 = new CardP2(CardP2.KING, CardP2.Suit.HEARTS);
        System.out.println(card2);
        System.out.println();
        System.out.print("Card 1 is ");
        card.Display();
        System.out.print(" Card 2 is ");
        card2.Display();
    }
}