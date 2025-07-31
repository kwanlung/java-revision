import java.util.HashMap;
import java.util.Map;

public class WordCount {

    public static void main(String[] args){
        String[] words = {"apple", "banana", "Apple", "orange", "Banana", "apple"};
        Map<String, Integer> result = countWords(words);
        for (Map.Entry<String, Integer> entry : result.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    private static Map<String, Integer> countWords(String[] words) {
        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String word : words){
            String lower = word.toLowerCase();
            wordCountMap.put(lower, wordCountMap.getOrDefault(lower, 0) + 1);
        }
        return wordCountMap;
    }
}

