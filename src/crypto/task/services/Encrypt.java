package crypto.task.services;
import java.io.IOException;

import crypto.task.alphabet.TextTransition;

public class Encrypt {
    private final TextTransition textTransition;
    private final int key;
    public Encrypt(TextTransition textTransition, int key) {
        this.textTransition = textTransition;
        this.key = key;
    }
    public void process() throws IOException {
        String encryptedText = textTransition.encrypt(key);
        textTransition.writeFile(encryptedText);
        System.out.println("Encryption successful!");
    }
}
