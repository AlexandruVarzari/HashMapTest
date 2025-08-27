import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class GroupAnagram {
    public static void main(String[] args) {
        String filePath = "";
        try{
           List<String> words = readWordsFile(filePath);
           List<List<String>> anagramGroups = groupAnagram(words);
           for(List<String> group : anagramGroups){
               if(!group.isEmpty()){
                   System.out.println(group);
               }
           }
        }catch (IOException e){
            System.err.println("Error message: " + e.getMessage());
        }
    }

    public static List<String> readWordsFile(String filePath) throws IOException {
        List<String> words = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader((filePath)));
        String line;
        while((line = reader.readLine()) != null){
            String word = line.trim();
            if(!word.isEmpty()){
                words.add(word);
            }
        }
        return words;
    }

    public static List<List<String>> groupAnagram(List<String> words){
        if(words == null || words.isEmpty()){
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String s : words){
           char[] characters = s.toCharArray();
            Arrays.sort(characters);
            String key = new String(characters);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
