import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Part1 {
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

            while(SPSScanner.hasNext()){
                pointMap.put(SPSScanner.next().charAt(0), SPSScanner.nextInt());
            }

            if (args[0].compareToIgnoreCase("hash") == 0) {
                start = System.currentTimeMillis();
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
                end = System.currentTimeMillis();
                System.out.println("Time for operation: " + (end - start));
            } else if (args[0].compareToIgnoreCase("tree") == 0) {
                start = System.currentTimeMillis();
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
                end = System.currentTimeMillis();
                System.out.println("Time for operation: " + (end - start));
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
            //end catch
        }
    }

}
