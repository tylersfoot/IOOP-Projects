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
        P1();
        // P2();
        // P3();
        // P4();
        // P5();
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
        System.out.println("Enter a sentence:");
        String sentence = scanner.nextLine();
        System.out.println("Sentence is: " + sentence);
        System.out.println("Sentence length: " + sentence.length());
        int blanks = 0;
        for (int i = 0; i < sentence.length(); i++)
        {
            if (sentence.charAt(i) == ' ') {
                blanks++;
            }
        }
        System.out.println("There are " + blanks + " blanks.");
        String[] split = sentence.replaceAll(" +"," ").split(" ");
        for(String temp: split) {
            System.out.println(temp);
        }
        scanner.close();
    }

    static void P3()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an integer:");
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            String output = "";
            int sum = 0;
            for (int j = 1; j <= i; j++) {
                sum += j;
                output += j + " + ";
            }
            output = output.substring(0, output.length() - 3) + " = " + sum;
            System.out.println(output);
        }

        scanner.close();
    }

    static void P4()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the month:");
        int month = scanner.nextInt();
        System.out.println("Enter the day:");
        int day = scanner.nextInt();
        int date = month * 100 + day;
        String season = "Winter";
        if (date >= 316 && date <= 615) {
            season = "Spring";
        }
        if (date >= 616 && date <= 915) {
            season = "Summer";
        }
        if (date >= 916 && date <= 1215) {
            season = "Fall";
        }
        System.out.println("The season at the date " + month + "/" + day + " is " + season + ".");
        scanner.close();
    }

    static void P5()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter integer A:");
        int a = scanner.nextInt();
        System.out.println("Enter integer B:");
        int b = scanner.nextInt();
        if (a == b) {
            System.out.println("The two integers are equal.");
        }
        else {
        int c = Math.min(a, b);
            b = Math.max(a, b);
            a = c;
            int sum = 0;
            int product = 1;
            for (int i = a; i <= b; i++) {
                sum += i;
                product *= i;
            }
            System.out.println("The inclusive sum between " + a + " and " + b + " is " + sum);
            System.out.println("The inclusive product between " + a + " and " + b + " is " + product);
        }
        scanner.close();
    }
}
