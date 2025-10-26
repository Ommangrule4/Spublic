import java.util.Scanner;

public class VigenereCipherDecryption {

    // Function to decrypt ciphertext using Vigenere Cipher
    public static String decrypt(String ciphertext, String key) {
        ciphertext = ciphertext.toUpperCase().replaceAll("[^A-Z]", "");
        key = key.toUpperCase();

        StringBuilder plaintext = new StringBuilder();
        int keyIndex = 0;

        for (int i = 0; i < ciphertext.length(); i++) {
            char c = ciphertext.charAt(i);

            // Shift value from key
            int shift = key.charAt(keyIndex) - 'A';

            // Decrypt: (cipher - shift + 26) mod 26
            char decryptedChar = (char) (((c - 'A' - shift + 26) % 26) + 'A');
            plaintext.append(decryptedChar);

            // Move to next key character
            keyIndex = (keyIndex + 1) % key.length();
        }

        return plaintext.toString();
    }

    // Main method with user input
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Ciphertext: ");
        String ciphertext = sc.nextLine();

        System.out.print("Enter Key: ");
        String key = sc.nextLine();

        String plaintext = decrypt(ciphertext, key);
        System.out.println("Decrypted Plaintext: " + plaintext);

        sc.close();
    }
}
