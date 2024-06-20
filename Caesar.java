import javax.swing.JOptionPane;

public class Caesar {
    private String PT;
    private int key;
    private String CT;
    public Caesar(){
        PT = "";
        key = 3;
        CT = "";
    }
    public void encryption(String PT,int key){
        this.PT = PT;
        this.key = key;
        for(int i=0;i<PT.length();i++){
            CT = CT + (char)(PT.charAt(i)+key);
        }
        JOptionPane.showMessageDialog(CaesarCipherGUI.frame, "Ciphertext: " + CT);
    }
    public void decryption(String CT,int key){
        this.CT = CT;
        this.key = key;
        for(int i=0;i<CT.length();i++){
            PT = PT + (char)(CT.charAt(i)-key);
        }
        JOptionPane.showMessageDialog(CaesarCipherGUI.frame, "Plaintext: " + PT);
    }
}
