package crypto.task.services;

import crypto.task.alphabet.TextTransition;

import java.io.IOException;

public class Encrypt {
    private TextTransition textTransition;
    private int key;

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
