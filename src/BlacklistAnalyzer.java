import java.io.*;

public class BlacklistAnalyzer {

    public String blacklistedWords = "";
    public File blacklistWordsList = new File("C:\\Users\\shane\\IdeaProjects\\untitled1\\Resources\\BlacklistedWords");

    public void analyzeBlacklist() throws IOException {
        blacklistedWords = getBlacklist();
    }

    public String getBlacklist() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(blacklistWordsList));
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");

        try {
            while((line = reader.readLine()) != null){
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }

            return stringBuilder.toString();
        } finally {
            reader.close();
        }
    }

    public void saveBlacklist(String blacklist){
        try{
            FileWriter fileWriter = new FileWriter(blacklistWordsList);
            fileWriter.flush();
            fileWriter.write(blacklist);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Boolean containsBlacklistedWords (String words){
        String[] blWords = blacklistedWords.split("\\s+");
        String[] inputtedWords = words.split("\\s+");
        Boolean flag = false;
        for(String blWord : blWords){
            for(String inputWord : inputtedWords){
                if(inputWord.equals(blWord)){
                    flag = true;
                }
            }
        }
        return flag;
    }

}
