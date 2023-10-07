/**
 * Lab 8
 *
 * @author (Tyler Depa)
 * @version (v1.0, 9-27-2023)
 */
import java.util.Scanner;
import java.lang.Math;
public class labeight
{
    public static void main(String[] args)
    {
        // P1();
        // P2();
        // P3();
        // P4();
        P5();
    }

    static void P1()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two integer numbers for interval 1:");
        int a1 = scanner.nextInt();
        int a2 = scanner.nextInt();
        System.out.println("Enter two integer numbers for interval 2:");
        int b1 = scanner.nextInt();
        int b2 = scanner.nextInt();
        System.out.println("Enter two integer numbers for interval 3:");
        int c1 = scanner.nextInt();
        int c2 = scanner.nextInt();
        System.out.println("Enter an integer:");
        int n = scanner.nextInt();
        boolean cont = false;
        boolean range = false;

        if (n >= a1 && n <= a2) {
            System.out.println(a1 + " <= " + n + " <= " + a2);
            range = true;
        }
        if (n >= b1 && n <= b2) {
            System.out.println(b1 + " <= " + n + " <= " + b2);
            range = true;
        }
        if (n >= c1 && n <= c2) {
            System.out.println(c1 + " <= " + n + " <= " + c2);
            range = true;
        }
        if (!range) {
            System.out.println(n + " is not within any of the intervals.");
        }

        System.out.println("Do you want to continue to enter numbers? (y/n)");
        scanner.nextLine();  // consume newline left-over
        String input = scanner.nextLine();
        cont = input.toLowerCase().startsWith("y") ? true : false;

        while (cont) {
            System.out.println("Enter an integer:");
            n = scanner.nextInt();
            range = false;

            if (n >= a1 && n <= a2) {
                System.out.println(a1 + " <= " + n + " <= " + a2);
                range = true;
            }
            if (n >= b1 && n <= b2) {
                System.out.println(b1 + " <= " + n + " <= " + b2);
                range = true;
            }
            if (n >= c1 && n <= c2) {
                System.out.println(c1 + " <= " + n + " <= " + c2);
                range = true;
            }
            if (!range) {
            System.out.println(n + " is not within any of the intervals.");
            }
            
            System.out.println("Do you want to continue to enter numbers? (y/n)");
            scanner.nextLine();  // consume newline left-over
            input = scanner.nextLine();
            cont = input.toLowerCase().startsWith("y") ? true : false;
        }
        scanner.close();
    }
    
    static void P2()
    {
        Scanner scanner = new Scanner(System.in);
        int r = (int)(Math.random() * 100) + 1;
        int guess = r-1;

        while (guess != r) {
            System.out.println("Guess a number from 1 to 100:");
            guess = scanner.nextInt();
            if (guess > r) {
                System.out.println("Your guess is too high!");
            }
            if (guess < r) {
                System.out.println("Your guess is too low!");
            }
        }
        System.out.println("Good job, your guess is correct!");

        scanner.close();
    }

    static String DayOfWeek(int day)
    {
        String dayS;
        switch (day) {
            case 1:
                dayS = "Sunday";
                break;
            case 2:
                dayS = "Monday";
                break;
            case 3:
                dayS = "Tuesday";
                break;
            case 4:
                dayS = "Wednesday";
                break;
            case 5:
                dayS = "Thursday";
                break;
            case 6:
                dayS = "Friday";
                break;
            case 7:
                dayS = "Saturday";
                break;
            default:
                dayS = "Invalid day number";
                break;
        }
        return dayS;
    }

    static void P3()
    {
        Scanner scanner = new Scanner(System.in);
        boolean cont = true;
        String input;
    
        while (cont) {
            System.out.println("Enter an integer number between 1 - 7, for day of week:");
            int n = scanner.nextInt();
            if (n >= 1 && n <= 7) {
                System.out.println("The day of week you picked is " + DayOfWeek(n));
            }
            else {
                System.out.println("Day provided is not within the range 1 - 7.");
            }

            System.out.println("Do you want to continue? (y/n)");
            scanner.nextLine();  // consume newline left-over
            input = scanner.nextLine();
            cont = input.toLowerCase().startsWith("y") ? true : false;
        }

        scanner.close();
    }

    static int Factorial(int n)
    {
        int product = 1;
        for (int i = 2; i <= n; i++) {
            product *= i;
        }
        return product;
    }

    static void P4()
    {
        Scanner scanner = new Scanner(System.in);
        boolean cont = true;
        String input;
    
        while (cont) {
            System.out.println("Enter a positive integer number:");
            int n = scanner.nextInt();
            if (n >= 1) {
                System.out.println("The factorial of " + n + " is " + Factorial(n));
            }
            else {
                System.out.println("Integer must be positive to calculate the factorial.");
            }

            System.out.println("Do you want to continue? (y/n)");
            scanner.nextLine();  // consume newline left-over
            input = scanner.nextLine();
            cont = input.toLowerCase().startsWith("y") ? true : false;
        }

        scanner.close();
    }

    static void P5()
    {
        Scanner scanner = new Scanner(System.in);
        boolean cont = true;
        String input, res1, res2;
        int bh = 0, bt = 0, h1 = 0, t1 = 0, h2 = 0, t2 = 0;
    
        while (cont) {
            System.out.println("Enter number of times to flip the coin:");
            int n = scanner.nextInt();
            bh = 0; 
            bt = 0;
            h1 = 0;
            t1 = 0;
            h2 = 0;
            t2 = 0;
            if (n >= 1) {
                for (int i = 0; i < n; i++) {
                    res1 = Math.random() < 0.5 ? "H" : "T";
                    res2 = Math.random() < 0.5 ? "H" : "T";
                    System.out.println(res1 + " " + res2);
                    bh += (res1.equals(res2) && res1.equals("H")) ? 1 : 0;
                    bt += (res1.equals(res2) && res1.equals("T")) ? 1 : 0;
                    h1 += res1.equals("H") ? 1 : 0;
                    t1 += res1.equals("T") ? 1 : 0;
                    h2 += res2.equals("H") ? 1 : 0;
                    t2 += res2.equals("T") ? 1 : 0;
                }
                System.out.println("Coin1 was heads " + (int)((100.0*h1)/n) + "%, and tails " + (int)((100.0*t1)/n) + "%");
                System.out.println("Coin2 was heads " + (int)((100.0*h2)/n) + "%, and tails " + (int)((100.0*t2)/n) + "%");
                System.out.println("The percentage both coins were heads was " + (int)((100.0*bh)/n) + "%");
                System.out.println("The percentage both coins were tails was " + (int)((100.0*bt)/n) + "%");
            }
            else {
                System.out.println("Flip amount must be positive.");
            }

            System.out.println("Do you want to continue? (y/n)");
            scanner.nextLine();  // consume newline left-over
            input = scanner.nextLine();
            cont = input.toLowerCase().startsWith("y") ? true : false;
        }

        scanner.close();
    }
}
