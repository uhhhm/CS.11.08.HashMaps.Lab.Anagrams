import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Set;

public class AnagramSolver {
    public static void main(String[] args) {
        System.out.println(anagrams("/Users/username/Desktop/untitled folder 5/java vscode/CS.11.08.HashMaps.Lab.Anagrams/src/main/resources/smalltest.txt"));
    }

    /**
     * Input: name of text file (containing English words).
     * Output: a hashmap of lists of words that are anagrams.
     * @param filename
     * @return
     */
    private static boolean isAnagram(ArrayList<String> myList, int i, int j){
        char[] chars1 = myList.get(i).toCharArray();
        char[] chars2 = myList.get(j).toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return Arrays.equals(chars1, chars2);
        
    }
    public static HashMap<String, ArrayList<String>> anagrams(String filename) {
        ArrayList<String> myList = new ArrayList<>();
        try{
            Scanner myReader = new Scanner(new File(filename));

        while (myReader.hasNextLine()) {
            myList.add(myReader.nextLine());
        }
        myReader.close();
        }catch(FileNotFoundException e){System.out.println("File not found");}   
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(int i = 0; i < myList.size(); i++){
            ArrayList<String> anagramWords = new ArrayList<>();
            for(int j = 0; j < myList.size(); j++){
                if(i == j){
                    continue;
                }
                if(isAnagram(myList, i, j)){
                    anagramWords.add(myList.get(j));
                }
            }
            map.put(myList.get(i), anagramWords);
        }
        return map;
    }

    /**
     * Input: hashmap of lists of words that are anagrams.
     * Output: largest list of words in hashmap that are anagrams.
     * @param anagrams
     * @return
     */
    public static ArrayList<String> mostFrequentAnagram(HashMap<String, ArrayList<String>> anagrams) {
        ArrayList<String> max = anagrams.get(0);
        for(int i = 0; i < anagrams.size(); i++){
            if(anagrams.get(i).size() > max.size()) max = anagrams.get(i);
        }
        return max;
    }

    /**
     * Input: hashmap of lists of words that are anagrams.
     * Output: prints all key value pairs in the hashmap.
     * @param anagrams
     */
    public static void printKeyValuePairs(HashMap<String, ArrayList<String>> anagrams) {
        for(String key : anagrams.keySet()){
            System.out.println("Key: " + key + " Value: " + anagrams.get(key));
        }
    }

}
