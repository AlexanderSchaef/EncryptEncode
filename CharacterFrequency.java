/**
Independent Project testing encoding and encryption.
Start date: 10/21/23
README.md in the github repo will be used for a checklist.
@author Alex Schaefer
@author Ashton Putnam
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class CharacterFrequency {

    public static ArrayList<Map.Entry<Character, Integer>> getCharacterFrequency(String inputString) {
        // Create a HashMap to store character frequencies
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
  
        // Count the frequency of each character in the input string
        for (char ch : inputString.toCharArray()) {
            charFrequencyMap.put(ch, charFrequencyMap.getOrDefault(ch, 0) + 1);
        }
  
        // Convert the HashMap entries to an ArrayList
        ArrayList<Map.Entry<Character, Integer>> charFrequencyList = new ArrayList<>(charFrequencyMap.entrySet());
  
        return charFrequencyList;
    }
}