import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String filename = "ёжик.txt";
        Map<String, Integer> wordCountMap = new HashMap<>();
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNext()) {
                String word = scanner.next();
                word = word.toLowerCase();
                if (!Character.isLetter(word.charAt(word.length() - 1))) {
                    word = word.substring(0, word.length() - 1);
                }
                if (wordCountMap.containsKey(word)) {
                    int count = wordCountMap.get(word) + 1;
                    wordCountMap.put(word, count);
                } else {
                    wordCountMap.put(word, 1);
                }
            }
            scanner.close();
            for (String word : wordCountMap.keySet()) {
                System.out.println(word + ":\t" + wordCountMap.get(word));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден" + filename);
        }
    }
}
