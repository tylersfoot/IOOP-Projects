/**
 * Lab 6
 *
 * @author (Tyler Depa)
 * @version (v1.0, 9-20-2023)
 */
import java.util.Scanner;
import java.lang.Math;
public class labsix
{
    public static void main(String[] args)
    {
        // P1();
        P2();
        // P3();
        // P4();
        // P5();
    }
    
    static void P1()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an integer:");
        int num1 = scanner.nextInt();

        // long way using if else statement
        if (num1 % 2 != 1) {
            System.out.println(num1 + " is even");
        }
        else {
            System.out.println(num1 + " is odd");
        }
        
        // short way using ternary operator
        System.out.println(num1 + " is " + ((num1 % 2 != 1) ? "even" : "odd"));
        scanner.close();
    }
    
    static void P2()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter pay rate ($ per hour):");
        double rate = scanner.nextDouble();
        System.out.println("Enter hours worked:");
        double hours = scanner.nextDouble();

        double base = ((hours <= 40) ? hours * rate : 40 * rate);
        double ot = ((hours * rate) - base) * 1.5;
        double gross = base + ot;

        System.out.println("Base pay: " + base);
        System.out.println("Overtime pay: " + ot);
        System.out.println("Gross pay: " + gross);
        scanner.close();
    }

    static void P3()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter degrees between 0.0 and 360.0:");
        double deg = scanner.nextDouble();
        double rad = deg * (Math.PI/180);

        System.out.println("The cosine of " + deg + " is " + Math.cos(rad));
        System.out.println("The sine of " + deg + " is " + Math.sin(rad));
        System.out.println("The secant of " + deg + " is " + 1/(Math.cos(rad)));
        System.out.println("The cosecant of " + deg + " is " + 1/(Math.sin(rad)));
        System.out.println(deg + " degrees is " + rad + " radians");

        scanner.close();
    }

    static void P4()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your height in inches:");
        double h = scanner.nextDouble();
        System.out.println("Enter your weight in pounds:");
        double w = scanner.nextDouble();
        double bmi = (w * 703) / (h*h);
        System.out.println("Your BMI is: " + bmi);

        scanner.close();
    }

    static void P5()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a real non-zero number for coefficient a:");
        double a = scanner.nextDouble();
        while(a == 0) {
            System.out.println("This is not a quadratic equation. Coefficient \"a\" must be a non-zero number.");
            System.out.println("Enter a real non-zero number for coefficient a:");
            a = scanner.nextDouble();
        }
        System.out.println("Enter a real number for coefficient b:");
        double b = scanner.nextDouble();
        System.out.println("Enter a real number for coefficient c:");
        double c = scanner.nextDouble();

        double d = Math.sqrt((b * b) - (4 * a * c));
        if (Double.isNaN(d)) {
            System.out.println("There are no real roots. (Attempted to take the square root of a negative number)");
        }
        else {
            double x1 = (-b + d) / (2 * a);
            double x2 = (-b - d) / (2 * a);
            double p1 = ((a*(x1*x1)) + (b*x1) + c);
            double p2 = ((a*(x2*x2)) + (b*x2) + c);
            if (p1-p2 <= 0.1) {
                System.out.println("The two real roots are: " + x1 + " and " + x2);
                System.out.println("Proof:");
                System.out.println("("+a+")("+x1+")^2 + ("+b+")("+x1+") - "+c+" = "+p1);
                System.out.println("("+a+")("+x2+")^2 + ("+b+")("+x2+") - "+c+" = "+p2);
            }
            else {
                System.out.println("Something went wrong while verifying roots.");
            }
        }

        scanner.close();
    }
}
