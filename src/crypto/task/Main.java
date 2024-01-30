package crypto.task;

import crypto.task.alphabet.TextTransition;
import crypto.task.models.Mode;
import crypto.task.services.BruteForceService;
import crypto.task.services.Decrypt;
import crypto.task.services.Encrypt;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java -jar myApp.jar command filePath key");
            return;
        }

        String command = args[0];
        String filePath = args[1];
        int key = Integer.parseInt(args[2]);

        try {
            TextTransition textTransition = new TextTransition(filePath);

            switch (Mode.valueOf(command.toUpperCase())) {
                case ENCRYPT:
                    Encrypt encrypt = new Encrypt(textTransition, key);
                    encrypt.process();
                    break;
                case DECRYPT:
                    Decrypt decrypt = new Decrypt(textTransition, key);
                    decrypt.process();
                    break;
                case BRUTE_FORCE:
                    BruteForceService bruteForceService = new BruteForceService(textTransition);
                    bruteForceService.performBruteForce();
                    break;
                default:
                    System.out.println("Invalid command. Use ENCRYPT, DECRYPT, or BRUTE_FORCE.");
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}