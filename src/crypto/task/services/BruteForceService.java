package crypto.task.services;


import crypto.task.alphabet.TextTransition;
public class BruteForceService {
    private final TextTransition textTransition;
    public BruteForceService(TextTransition textTransition) {
        this.textTransition = textTransition;
    }
    public void performBruteForce() {
        for (int i = 1; i <= 25; i++) {
            String decryptedText = textTransition.encrypt(26 - i);
            System.out.println("Key " + i + ": " + decryptedText);
        }
    }
}
