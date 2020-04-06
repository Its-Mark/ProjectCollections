/**
 * Project Collections (Part 1)
 * @author Mark Garcia 018019103
 *         mark.garcia01@student.csulb.edu
 * @author Brandon Wiitanen
 *         brandon.wiitanen01@student.csulb.edu
 */

import java.util.TreeMap;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Part1 {
    /**
     * This method takes in 1 argument through the command line to determine whether it will run as a TreeMap or a HashMap
     * Reads ScabblePointSystem.txt and adds the Letter and Point Value of each letter to a HashMap
     * Reads QWords.txt and adds the word and its points value to a Map
     * @param args = either "TREE" or "HASH" anything else will not run the program
     * ANALYSIS OF RUNTIME: Using a HashMap is more efficient than using a TreeMap in this scenario
     */
    public static void main(String[] args) {
        //initialize variables to be used
        Scanner qWordsScanner;
        Scanner ScrabblePointScanner;
        File qWords = new File("Qwords.txt");
        File SPS = new File("ScrabblePointSystem.txt");
        long start, end;
        int sum;

        try {
            //scan files
            Scanner QWScanner = new Scanner(qWords);
            Scanner SPSScanner = new Scanner(SPS);
            HashMap<Character, Integer> pointMap = new HashMap<>();
            start = System.nanoTime();
            while(SPSScanner.hasNext()){
                pointMap.put(SPSScanner.next().charAt(0), SPSScanner.nextInt());
            }

            if (args[0].compareToIgnoreCase("hash") == 0) {
                HashMap<String, Integer> qWordMap = new HashMap<>();
                while(QWScanner.hasNext()){
                    String temp = QWScanner.next();
                    char[] word = temp.toUpperCase().toCharArray();
                    sum = 0;
                    for(int i = 0; i < word.length; i++){
                        sum += pointMap.get(word[i]);
                    }
                    qWordMap.put(temp,sum);
                }
                System.out.println(qWordMap.toString());
                end = System.nanoTime();
                System.out.println("Time for operation (nanoseconds): " + (end - start));
            } else if (args[0].compareToIgnoreCase("tree") == 0) {
                TreeMap<String, Integer> tmap = new TreeMap<>();
                while(QWScanner.hasNext()){
                    String temp = QWScanner.next();
                    char[] word = temp.toUpperCase().toCharArray(); //needs to be chars because thats what the map uses as keys
                    sum = 0;
                    for(int i = 0; i < word.length; i++){
                        sum += pointMap.get(word[i]);
                    }
                    tmap.put(temp,sum);
                }
                System.out.println(tmap.toString());
                end = System.nanoTime();
                System.out.println("Time for operation (nanoseconds): " + (end - start));
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
            //end catch
        }
    }

}
