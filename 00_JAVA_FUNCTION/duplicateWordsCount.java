import java.util.HashMap;
import java.util.Map;

public class duplicateWordsCount {

    static Map<String, Integer> duplicateWordsCounting(String s){
        // Split the string into words using regex to handle punctuation and whitespace
        String[] words = s.toLowerCase().split("\\W+");

        // Create a map to store the count of each word
        Map<String, Integer> wordCountMap = new HashMap<>();

        // Iterate through each word and count occurrences
        for (String word : words) {
            if (!word.isEmpty()) { // Ignore empty strings
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        }

        return wordCountMap;
    }

    public static void main(String[] args) {
        String input = "Today is a wonderful day, today is shiny day.";
        Map<String, Integer> wordCounts = duplicateWordsCounting(input);

        // Print the word counts
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
