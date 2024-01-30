package crypto.task.alphabet;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextTransition {
    private final  String filePath;

    public TextTransition(String filePath) {
        this.filePath = filePath;
    }

    public String encrypt(int key) {
        return processText(key);
    }

    public String decrypt(int key) {
        return processText(26 - key);
    }

    private String processText(int key) {
        try {
            String content = readFile();
            StringBuilder result = new StringBuilder();

            for (char c : content.toCharArray()) {
                if (Character.isLetter(c)) {
                    char main = Character.isLowerCase(c) ? 'a' : 'A';
                    result.append((char) ((c - main + key) % 26 + main));
                } else {
                    result.append(c);
                }
            }

            return result.toString();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return "";
        }
    }

    public String readFile() throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    public void writeFile(String content) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
        }
    }
}
