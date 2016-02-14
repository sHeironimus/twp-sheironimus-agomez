import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Frequency {
    public Map<String, Integer> frequencyMap = new HashMap<>();

    public String Output(){
        return "Frequency(" + frequencyMap + ")\n";
    }

    public Frequency(String text){
        BlacklistAnalyzer blAnalyzer = new BlacklistAnalyzer();
        try {
            blAnalyzer.analyzeBlacklist();
            String[] input = text.split("\\s+");
            for (String word : input) {
                if(word.contains("\"")){
                    word = word.replace("\"", "");
                }
                if (!blAnalyzer.containsBlacklistedWords(word)) {
                    Integer count = frequencyMap.get(word);
                    count = (count == null) ? 1 : ++count;
                    frequencyMap.put(word, count);
                }
            }
        } catch (IOException e) {
        e.printStackTrace();
        }
    }
}
