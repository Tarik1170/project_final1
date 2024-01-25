package crypto.task.services;

import crypto.task.alphabet.TextTransition;

import java.io.IOException;

public class Decrypt {
    private TextTransition textTransition;
    private int key;

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

