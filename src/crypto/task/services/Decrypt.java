package crypto.task.services;
import java.io.IOException;

import crypto.task.alphabet.TextTransition;


public class Decrypt {
    private final TextTransition textTransition;
    private final int key;
    public Decrypt(TextTransition textTransition, int key) {
        this.textTransition = textTransition;
        this.key = key;
    }
    public void process() throws IOException {
        String decryptedText = textTransition.encrypt(26 - key);
        textTransition.writeFile(decryptedText);
        System.out.println("Decryption successful!");
    }
}

