package App_main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class specialized to create files filled with random numbers, ideally to test sorting algorithms.
 */
public class RandomNumberGenerator {

    /**
     * Creates files filled with random numbers.
     * @param filePath Where the file will be saved.
     * @param maxValue Sets the max boundary every number can reach.
     * @param entities Sets the number of numbers to be created.
     */
    public static void writeFile(String filePath,  int maxValue, int entities){
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            for (int i=0; i < entities; i++)
                fileWriter.write(Integer.toString(randomInt(0, maxValue)) + "\n");
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException("The given filePath does NOT exist, or is invalid.");
        }
    }

    /**
     * Ideally created to read files created with {@link #writeFile(String, int, int)}
     * returning a list of the numbers contained on the given file.
     * @param filePath Where the file to read is located.
     * @return A list of the numbers contained on the given file.
     */
    public static List<Integer> readFile(String filePath) {
        ArrayList<Integer> numbers = new ArrayList<>();
        File file = new File(filePath);
        try {
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine()) {
                int number = Integer.parseInt(fileReader.nextLine().strip());
                numbers.add(number);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("The given filePath does NOT exist, or is invalid.");
        }catch (NumberFormatException e){
            throw new RuntimeException("This file contains more than numbers.");
        }
        return numbers;
    }

    /**
     * Returns a random int value between the given boundaries.
     * @param minValue  min boundary
     * @param maxValue  max boundary
     * @return  a random int between the boundaries.
     */
    private static int randomInt(int minValue, int maxValue) {
        if (minValue >= maxValue)
            throw new InvertedMinAndMaxBoundException("minValue must be less than maxValue.");
        java.util.Random rand = new java.util.Random();
        return rand.nextInt(maxValue - minValue + 1) + minValue;
    }
}
