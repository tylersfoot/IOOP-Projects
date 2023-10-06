/**
 * Project 1
 *
 * @author (Tyler Depa)
 * @version (v1.0, 10-4-2023)
 */
import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;

public class projectone
{
    public static void main(String[] args)
    {
        // P1();
        // P2();
        // P3();
        P4();
    }

    /**
     * Purpose: This method takes an input representing a duration in seconds and converts it into
     * the corresponding number of days, hours, minutes, and remaining seconds. It then
     * prints out the calculated values for days, hours, minutes, and seconds.
     * 
     * @param None
     * @return void
     * @throws java.util.InputMismatchException if the input is not a valid integer.
     */
    static void P1()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of seconds as an integer:");
        int time = scanner.nextInt();

        int days = time / 86400;
        int hours = (time % 86400) / 3600;
        int minutes = (time % 3600) / 60;
        int seconds = time % 60;
        
        System.out.println("Days: " + days);
        System.out.println("Hours: " + hours);
        System.out.println("Minutes: " + minutes);
        System.out.println("Seconds: " + seconds);

        scanner.close();
    }

    /**
     * Purpose: Calculates the sum of all elements in the given array of doubles.
     * 
     * double Sum(double[] arrayOfDoubles)
     *
     * @param double arrayOfDoubles An array of double values.
     * @return The sum of all elements in the input array. Returns 0.0 if the array is empty.
     */
    static double Sum(double[] arrayOfDoubles)
    {
        double sum = 0;
        for (int i = 0; i < arrayOfDoubles.length; i++) {
            sum += arrayOfDoubles[i];
        }
        return sum;
    }

    /**
     * Purpose: Calculates the average of a sum given the number of values.
     * 
     * double Average(double sum, int n)
     *
     * @param double sum The sum of the values.
     * @param int n The number of values.
     * @return The average given the sum and the number of values.
     */
    static double Average(double sum, int n)
    {
        return sum/n;
    }

    /**
     * Purpose: Calculates the variance of an array given the array and the average of the values.
     * 
     * double Variance(double[] arrayOfDoubles, double average)
     *
     * @param double[] arrayOfDoubles The array containing doubles.
     * @param double average The average of the values in the array.
     * @return The variance of the array given the array and the average of the values.
     */
    static double Variance(double[] arrayOfDoubles, double average)
    {
        double var = 0;
        for (int i = 0; i < arrayOfDoubles.length; i++) {
            var += (arrayOfDoubles[i] - average) * (arrayOfDoubles[i] - average);
        }
        return var / arrayOfDoubles.length;
    }

    /**
     * Purpose: Calculates standard deviation given the variance.
     * 
     * double StandardDev(double variance)
     *
     * @param double variance The variance.
     * @return The standard deviation given the variance.
     */
    static double StandardDev(double variance)
    {
        return Math.sqrt(variance);
    }

    /**
     * Purpose: Calculates the median of an array given the array.
     * 
     * double Median(double[] arrayOfDoubles)
     *
     * @param double[] arrayOfDoubles The array containing doubles.
     * @return The median of the array given the array.
     */
    static double Median(double[] arrayOfDoubles)
    {
        Arrays.sort(arrayOfDoubles);
        double median;
        if (arrayOfDoubles.length % 2 == 0)
            median = (arrayOfDoubles[arrayOfDoubles.length/2] + arrayOfDoubles[arrayOfDoubles.length/2 - 1])/2;
        else
            median = arrayOfDoubles[arrayOfDoubles.length/2];
        return median;
    }

    /**
     * Purpose: This method converts an array of Fahrenheit temperatures to Celsius.
     * It also calculates and displays the average, variance, standard deviation, 
     * and median of both the Fahrenheit and Celsius values.
     * 
     * void P2()
     * 
     * @param none
     * @return void
     */
    static void P2()
    {
        double[] tempF = {212.0, 98.6, 32.0, 61.0};
        double[] tempC = new double[tempF.length];

        System.out.println("Fahrenheit Celsius");
        for (int i = 0; i < tempF.length; i++) {
            tempC[i] = ((tempF[i]-32)*5)/9;  
            System.out.println(tempF[i] + " " + tempC[i]);
        }

        System.out.println("Fahrenheit Celsius");
        System.out.println("Average is: " + Average(Sum(tempF), tempF.length) + " " + Average(Sum(tempC), tempC.length));
        System.out.println("Variance is: " + Variance(tempF, Average(Sum(tempF), tempF.length)) + " " + Variance(tempC, Average(Sum(tempC), tempC.length)));
        System.out.println("Standard Deviation is: " + StandardDev(Variance(tempF, Average(Sum(tempF), tempF.length))) + " " + StandardDev(Variance(tempC, Average(Sum(tempC), tempC.length))));
        System.out.println("Median is: " + Median(tempF) + " " + Median(tempC));
    }

    /**
     * Purpose: This method reads in a file containing a list of temperatures in Fahrenheit 
     * and converts the temperatures to Celsius.
     * It also calculates and displays the average, variance, standard deviation, 
     * and median of both the Fahrenheit and Celsius values.
     * 
     * void P2()
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
        
        double[] tempF = null;
        int n = 0;
        if (inputFile != null) {
            if (inputFile.hasNextLine()) {
                n = inputFile.nextInt();         
            }
            if (n > 0) {
                tempF = new double[n];
                int j = 0; 

                while (inputFile.hasNextLine()) {         
                    tempF[j] = inputFile.nextDouble();
                    j++;                     
                }
            }
        }
        else {
            System.out.println("Unable to open file: " + file);
        }

        if (n != 0) 
        {
            double[] tempC = new double[tempF.length];

            System.out.println("Fahrenheit\tCelsius");
            for (int i = 0; i < tempF.length; i++) {
                tempC[i] = ((tempF[i]-32)*5)/9;  
                System.out.printf("%.2f\t\t%.2f\n", tempF[i], tempC[i]);
            }

            double averageF = Average(Sum(tempF), tempF.length);
            double averageC = Average(Sum(tempC), tempC.length);
            double varianceF = Variance(tempF, averageF);
            double varianceC = Variance(tempC, averageC);
            double stdDevF = StandardDev(varianceF);
            double stdDevC = StandardDev(varianceC);

            System.out.printf("Average:\n");
            System.out.printf("%.2f\t\t%.2f\n", averageF, averageC);
            System.out.printf("Variance:\n");
            System.out.printf("%.2f\t\t%.2f\n", varianceF, varianceC);
            System.out.printf("Standard Deviation:\n");
            System.out.printf("%.2f\t\t%.2f\n", stdDevF, stdDevC);
            System.out.printf("Median:\n");
            System.out.printf("%.2f\t\t%.2f\n", Median(tempF), Median(tempC));
        }
    }

    static void PrintBoard(int[][] board)
    {
        for (int i = 0; i < board.length; i++) { // height
            for (int j = 0; j < board[0].length; j++) { // width
                if (board[i][j] == 1) {
                    System.out.print("* ");
                }
                else {
                    System.out.print(". ");
                }
            }
            System.out.print("\n");
        }
    }

    static void P4()
    {
        Scanner scanner = new Scanner(System.in);
       
        int steps = 10;
        int step = 0;
        int[] boardSize = new int[2]; // height and then width
        boardSize[0] = 20;
        boardSize[1] = 20;
        int[][] gridCurr = new int[boardSize[0]][boardSize[1]];
        int[][] gridNext = new int[boardSize[0]][boardSize[1]];
        int friends = 0; // number of live cells around

        gridCurr[3][13] = 1;
        gridCurr[4][13] = 1;
        gridCurr[5][13] = 1;

        gridCurr[7][14] = 1;
        gridCurr[7][15] = 1;
        gridCurr[7][16] = 1;

        gridCurr[8][9] = 1;
        gridCurr[9][8] = 1;
        gridCurr[9][9] = 1;
        gridCurr[9][10] = 1;
        gridCurr[10][9] = 1;

        gridCurr[12][14] = 1;
        gridCurr[13][13] = 1;
        gridCurr[13][14] = 1;
        gridCurr[13][15] = 1;
        gridCurr[14][14] = 1;

        System.out.println("Step: " + step);
        PrintBoard(gridCurr);
        while (step <= steps) {
            // do game logic

            for (int h = 0; h < gridCurr.length; h++) { // height
                for (int w = 0; w < gridCurr[0].length; w++) { // width
                    friends = 0;

                    // check live neighbors, detect if on the edge or corner and don't check those (oob error)
                    if (h != 0) { 
                        // top
                        friends += gridCurr[h-1][w] == 1 ? 1 : 0;
                    }
                    if (h != 0 && w != gridCurr[0].length-1) { 
                        // top right
                        friends += gridCurr[h-1][w+1] == 1 ? 1 : 0;
                    }
                    if (w != gridCurr[0].length-1) { 
                        // right
                        friends += gridCurr[h][w+1] == 1 ? 1 : 0;
                    }
                    if (h != gridCurr.length-1 && w != gridCurr[0].length-1) { 
                        // bottom right
                        friends += gridCurr[h+1][w+1] == 1 ? 1 : 0;
                    }
                    if (h != gridCurr.length-1) { 
                        // bottom
                        friends += gridCurr[h+1][w] == 1 ? 1 : 0;
                    }
                    if (h != gridCurr.length-1 && w != 0) { 
                        // bottom left
                        friends += gridCurr[h+1][w-1] == 1 ? 1 : 0;
                    }
                    if (w != 0) { 
                        // left
                        friends += gridCurr[h][w-1] == 1 ? 1 : 0;
                    }
                    if (h != 0 && w != 0) { 
                        // top left
                        friends += gridCurr[h-1][w-1] == 1 ? 1 : 0;
                    }

                    if (gridCurr[h][w] == 1) { 
                        if (friends == 2 || friends == 3) {
                            // A live cell with 2 or 3 live neighbors lives on to the next generation
                            gridNext[h][w] = 1;
                        }
                        else {
                            // A live cell with fewer than 2 or more than 3 live neighbors dies
                            gridNext[h][w] = 0;
                        }
                    }
                    else {
                        if (friends == 3) {
                            // A dead cell with exactly 3 neighbors becomes a live cell
                            gridNext[h][w] = 1;
                        }
                    }
                }
            }

            step++;
            gridCurr = gridNext;
            System.out.println();
            System.out.println("Step: " + step);
            PrintBoard(gridCurr);
        }

        scanner.close();
    }
}
