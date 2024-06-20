import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
public class Vigenere {
    private String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public Vigenere() {}
    private List<Integer> getCharPositions(String str) {
        List<Integer> charsAtPos = new ArrayList<Integer>();
        for (int i = 0; i < str.length(); i++) {
            charsAtPos.add(chars.indexOf(str.charAt(i)));
        } 
        return charsAtPos;
    }
    public void encrypt(String text, String key) {
        text = text.replace(" ", "");
        text = text.toUpperCase();
        key = key.toUpperCase();
        List<Integer> textCharAtPos = getCharPositions(text);
        List<Integer> keyCharAtPos = getCharPositions(key);
        int textLength = text.length();
        int keyLength = key.length();
        String cipher = "";
        int letter;
        for (int n = 0; n < textLength; n++) {
            letter = (textCharAtPos.get(n) + keyCharAtPos.get(n % keyLength));
            letter %= chars.length();
            cipher += chars.charAt(letter);
        }
        JOptionPane.showMessageDialog(VigenereCipherGUI.frame, "Ciphertext: " + cipher);
    }
    public void decrypt(String cipher, String key) {
        cipher = cipher.replace(" ", "");
        cipher = cipher.toUpperCase();
        key = key.toUpperCase();
        List<Integer> cipherCharAtPos = getCharPositions(cipher);
        List<Integer> keyCharAtPos = getCharPositions(key);
        int cipherLength = cipher.length();
        int keyLength = key.length();
        String plainText = "";
        int letter;
        for (int n = 0; n < cipherLength; n++) {
            letter = (cipherCharAtPos.get(n) - keyCharAtPos.get(n % keyLength));
            letter += chars.length();
            letter %= chars.length();
            plainText += chars.charAt(letter);
        }
        JOptionPane.showMessageDialog(VigenereCipherGUI.frame, "Plaintext: " + plainText);
    }
}