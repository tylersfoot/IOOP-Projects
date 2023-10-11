/**
 * Lab 9
 *
 * @author (Tyler Depa)
 * @version (v1.0, 10-11-2023)
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.Math;

import javax.swing.*;
public class labnine
{
    public static void main(String[] args)
    {
        // P1();
        // P2();
        // P3();
        // P4();
        P5();
        // P6();
    }

    /**
     * Purpose: Prompts the user to enter their first, middle, and last names using JOptionPane dialogs.
     * If all names are provided, displays a greeting message with the full name.
     * If any name is missing, shows an error message using JOptionPane.
     * 
     * void P1()
     * 
     * @param none
     * @return void
     */
    static void P1()
    {
        String firstName = JOptionPane.showInputDialog("Enter your first name:");
        String middleName = JOptionPane.showInputDialog("Enter your middle name:");
        String lastName = JOptionPane.showInputDialog("Enter your last name:");

        if (firstName != null && !firstName.trim().isEmpty() &&
            middleName != null && !middleName.trim().isEmpty() &&
            lastName != null && !lastName.trim().isEmpty()) {
            String message = "Hello " + firstName + " " + middleName + " " + lastName;
            JOptionPane.showMessageDialog(null, message, "Greeting", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Display an error message if any name is missing
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter all names.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Purpose: Checks if the given integer number is a prime number.
     * A prime number is a number that can only be divided by itself and 1 without remainders.
     * 
     * boolean isPrime(int number)
     * 
     * @param int number The integer number that is checked.
     * @return true if the number is prime, false otherwise.
     */
    static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Purpose: Prompts the user to enter an integer number using a JOptionPane input dialog.
     * Checks if the entered number is a prime number using the isPrime method.
     * Displays a message dialog indicating whether the number is prime or not.
     * If the input is not a valid integer, shows an error message dialog.
     * 
     * void P2()
     * 
     * @param none
     * @return void
     */
    static void P2()
    {
        String input = JOptionPane.showInputDialog("Enter an integer number:");
        try {
            int number = Integer.parseInt(input);

            if (isPrime(number)) {
                JOptionPane.showMessageDialog(null, number + " is a prime number.");
            } else {
                JOptionPane.showMessageDialog(null, number + " is not a prime number.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter an integer.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Purpose: Sorts an input array of double values in descending order using the Selection Sort algorithm.
     * The original input array remains unchanged, and a new sorted array is returned.
     * 
     * double[] sortArray(double[] array)
     * 
     * @param double[] array The input array of doubles to sort.
     * @return the sorted array of doubles.
     */
    static double[] sortArray(double[] array) {
        int n = array.length;
        double[] sortedArray = new double[n];

        System.arraycopy(array, 0, sortedArray, 0, n);

        for (int i = 0; i < n - 1; i++) {
            double temp = sortedArray[i];
            int tempIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (temp <= sortedArray[j]) {
                    temp = sortedArray[j];
                    tempIndex = j;
                }
            }
            
            double swap = sortedArray[i];
            sortedArray[i] = sortedArray[tempIndex];
            sortedArray[tempIndex] = swap;
        }

        return sortedArray;
    }

    /**
     * Purpose: Reads numeric values from a user-selected file, filters out non-double values,
     * sorts the valid numbers in descending order, and writes them to a user-specified output file.
     * Uses JFileChooser to enable the user to select an input file and JOptionPane to obtain the output filename.
     * 
     * void P3()
     * 
     * @param none
     * @return void
     */
    static void P3()
    {
        File file;
        JFileChooser fc = new JFileChooser();
        fc.showDialog(fc, null);
        file = fc.getSelectedFile();
        System.out.println("The selected file is " + file);
        Scanner inputFile = null;

        try {
            inputFile = new Scanner(file);
        }
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
            inputFile = null;
        }
        
        double[] nums = new double[0];
        if (inputFile != null) {
            int n = 0;
            while (inputFile.hasNextLine()) {
                String line = inputFile.nextLine();
                try {
                    double num = Double.parseDouble(line);

                    // Resize the array and add the new number
                    double[] tempArray = new double[n + 1];
                    System.arraycopy(nums, 0, tempArray, 0, n);
                    tempArray[n] = num;
                    nums = tempArray;
                    n++;
                } catch (Exception e) {
                    System.out.println("Skipping non-double value: " + line);
                }
            }
        }
        else {
            System.out.println("Unable to open file: " + file);
        }
        nums = sortArray(nums);
        String outputFileName = JOptionPane.showInputDialog("Enter the output filename:");

        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFileName))) {
            for (double number : nums) {
                writer.println(number);
            }
            JOptionPane.showMessageDialog(null, "Numbers written to file successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error writing to the file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Purpose: Checks if the given word or sentence is a palindrome (reads the same backward as forward).
     * Displays a message indicating whether the input is a palindrome or not using JOptionPane.
     * 
     * void P4()
     * 
     * @param none
     * @return void
     */
    static void P4()
    {
        String input = JOptionPane.showInputDialog("Enter word or sentence:");
        boolean isPalindrome = true;

        for (int i = 0; i < input.length(); i++) {
            isPalindrome = (input.charAt(i) != input.charAt(input.length()-1-i)) ? false : isPalindrome;
        }

        String message = isPalindrome ? "The string " + input + " is a palindrome" : "The string " + input + " is not a palindrome";
        JOptionPane.showMessageDialog(null, message, "Palindrome", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Purpose:  Purpose: Takes user input for name and description, creates an HTML document
     * containing the user's name and description, and writes it to an 'index.html' file.
     * 
     * void P5()
     * 
     * @param none
     * @return void
     */
    static void P5()
    {
        String name = JOptionPane.showInputDialog("Enter your name:");
        String description = JOptionPane.showInputDialog("Describe yourself:");
        String[] output = {
            "<html>",
            "<head>",
            "</head>",
            "<body>",
            "<center>",
            "<h1>" + name + "</h1>",
            "</center>",
            "<hr />",
            description,
            "<hr />",
            "</body>",
            "</html>",
            };

        try (PrintWriter writer = new PrintWriter(new FileWriter("index.html"))) {
            for (String line : output) {
                writer.println(line);
            }
            JOptionPane.showMessageDialog(null, "Written to file successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error writing to the file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Purpose: Calculates the factorial for an integer.
     * 
     * int Factorial(int n)
     * .
     * @param int n The number to calculate the factorial on
     * @return The factorial.
     */
    static int Factorial(int n)
    {
        int product = 1;
        for (int i = 2; i <= n; i++) {
            product *= i;
        }
        return product;
    }
    
    /**
     * Purpose: Prompts the user to enter an integer number using a JOptionPane input dialog.
     * Calculates the palindrome using the Palindrome method and shows it as a message dialog.
     * If the input is not a valid integer, shows an error message dialog and repeats until a valid integer is given.
     * 
     * void P6()
     * 
     * @param none
     * @return void
     */
    static void P6() {
        String input;
        boolean isValid = false;
        
        while (!isValid) {
            input = JOptionPane.showInputDialog("Enter an integer number:");
            try {
                int number = Integer.parseInt(input);

                String message = number + "! = " + Factorial(number);
                isValid = true;
                JOptionPane.showMessageDialog(null, message, "Factorial", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter an integer.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


}
