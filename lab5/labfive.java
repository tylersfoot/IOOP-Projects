/**
 * Lab 5
 *
 * @author (Tyler Depa)
 * @version (v1.0, 9-20-2023)
 */
import java.util.Scanner;
import java.lang.Math;
public class labfive
{
    public static void main(String[] args)
    {
        // P1();
        // P2();
        // P3();
        // P4();
        // P5();
    }
    
    static void P1()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a real number:");
        double num1 = scanner.nextDouble();
        System.out.println("Enter a real number:");
        double num2 = scanner.nextDouble();

        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;
        double quotient = num1 / num2;
        System.out.println("The sum of " + num1 + " and " + num2 + " is " + sum);
        System.out.println("The difference of " + num1 + " and " + num2 + " is " + difference);
        System.out.println("The product of " + num1 + " and " + num2 + " is " + product);
        System.out.println("The quotient of " + num1 + " and " + num2 + " is " + quotient);
        scanner.close();
    }
    
    static void P2()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a real number:");
        double num1 = scanner.nextDouble();
        System.out.println("Enter a real number:");
        double num2 = scanner.nextDouble();
        System.out.println("Enter a real number:");
        double num3 = scanner.nextDouble();

        System.out.println("The average of " + num1 + ", " + num2 + ", and " + num3 + " is " + (num1+num2+num3)/3);
        scanner.close();
    }

    static void P3()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an integer:");
        double num1 = scanner.nextInt();

        System.out.println((int)(num1%2));
        scanner.close();
    }

    static void P4()
    {
        double a = 2.5; 
        double b = 7.0; 
        double c = 10.0; 
        double d = 2.0; 
        double x = 5.0; 
        double y = 4.0;

        System.out.println("a: " + ((b*b)-(4*a*c)));
        System.out.println("b: " + (a+b-c));
        System.out.println("c: " + (a+b)/(c+d));
        System.out.println("d: " + (1.0)/(y+(x*x)));
        System.out.println("e: " + (1.0/(Math.sqrt(x*x*x))));
    }

    static void P5()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the radius of a sphere:");
        double r = scanner.nextInt();
        double v = (4/3)*Math.PI * (r*r*r);
        double a = 4 * Math.PI * r * r;
        System.out.println("Volume: " + v);
        System.out.println("Area: " + a);
        scanner.close();
    }
}
