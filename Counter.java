import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Counter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputText;

        System.out.println("Enter '1' if you want to give input text:");
        System.out.println("Enter '2' if you want to provide a file:");
        int yourChoice = sc.nextInt();
        sc.nextLine();

        switch (yourChoice) {
            case 1:
                System.out.println("Enter your text:");
                inputText = sc.nextLine();
                break;
            case 2:
                System.out.println("Enter your file path:");
                String filePath = sc.nextLine();
                try {
                    inputText = readFile(filePath);
                } catch (FileNotFoundException e) {
                    System.out.println("Error: Sorry, your file was not found.");
                    return;
                }
                break;
            default:
                System.out.println("Invalid choice. Try again.");
                return;
        }

        String[] words = inputText.toLowerCase().split("[\\p{Punct}\\s]+");

        Map<String, Integer> wordCounter = new HashMap<>();

        for (String word : words) {
            wordCounter.put(word, wordCounter.getOrDefault(word, 0) + 1);
        }

        int totalWordCount = words.length;
        System.out.println("Total words: " + totalWordCount);

        String[] stopWords = {"the", "and", "of", "in", "to", "a", "is", "it", "that", "with"};
        Map<String, Integer> filteredWordCounter = new HashMap<>();
        for (Map.Entry<String, Integer> entry : wordCounter.entrySet()) {
            if (!Arrays.asList(stopWords).contains(entry.getKey())) {
                filteredWordCounter.put(entry.getKey(), entry.getValue());
            }
        }

        int uniqueWordCount = filteredWordCounter.size();
        System.out.println("Unique words: " + uniqueWordCount);

        System.out.println("Word frequency:");
        for (Map.Entry<String, Integer> entry : filteredWordCounter.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static String readFile(String filePath) throws FileNotFoundException {
        StringBuilder content = new StringBuilder();
        Scanner scanner = new Scanner(new File(filePath));
        while (scanner.hasNextLine()) {
            content.append(scanner.nextLine()).append(" ");
        }
        scanner.close();
        return content.toString();
    }
}
