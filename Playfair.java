import javax.swing.JOptionPane;
public class Playfair {

    private String key;
    private String PT;
    private String CT;

    public Playfair(){
        this.key = "";
        this.PT = "";
        this.CT = "";
    }

    public static void toLowerCase(char plain[], int ps){
        int i;
        for (i = 0; i < ps; i++) {
        if (plain[i] > 64 && plain[i] < 91)
            plain[i] += 32;
        }
    }

    public static int removeSpaces(char[] plain, int ps){
        int i, count = 0;
        for (i = 0; i < ps; i++)
        if (plain[i] != '\u0000')
            plain[count++] = plain[i];
        return count;
    }

    public static void generateKeyTable(char key[], int ks, char keyT[][]){
        int i, j, k;
        int dicty[] = new int[26];
        for (i = 0; i < ks; i++) {
        if (key[i] != 'j')
            dicty[key[i] - 97] = 2;
        }
        dicty['j' - 97] = 1;
        i = 0;
        j = 0;
        for (k = 0; k < ks; k++) {
        if (dicty[key[k] - 97] == 2) {
            dicty[key[k] - 97] -= 1;
            keyT[i][j] = key[k];
            j++;
            if (j == 5) {
            i++;
            j = 0;
            }
        }
        }
        for (k = 0; k < 26; k++) {
        if (dicty[k] == 0) {
            keyT[i][j] = (char)(k + 97);
            j++;
            if (j == 5) {
            i++;
            j = 0;
            }
        }
        }
    }

    public static void search(char keyT[][], char a, char b, int arr[]){
        int i, j;
        if (a == 'j')
        a = 'i';
        else if (b == 'j')
        b = 'i';
        for (i = 0; i < 5; i++) {
        for (j = 0; j < 5; j++) {
            if (keyT[i][j] == a) {
            arr[0] = i;
            arr[1] = j;
            }
            else if (keyT[i][j] == b) {
            arr[2] = i;
            arr[3] = j;
            }
        }
        }
    }

    public static int mod5(int a) { return (a % 5); }

    public static int prepare(char str[], int ptrs){
        if (ptrs % 2 != 0) {
        str[ptrs++] = 'z';
        str[ptrs] = '\0';
        }
        return ptrs;
    }

    public static void encrypt(char str[], char keyT[][], int ps){
        int i;
        int[] a =new int[4];
        for (i = 0; i < ps; i += 2) {
        search(keyT, str[i], str[i + 1], a);
        if (a[0] == a[2]) {
            str[i] = keyT[a[0]][mod5(a[1] + 1)];
            str[i + 1] = keyT[a[0]][mod5(a[3] + 1)];
        }
        else if (a[1] == a[3]) {
            str[i] = keyT[mod5(a[0] + 1)][a[1]];
            str[i + 1] = keyT[mod5(a[2] + 1)][a[1]];
        }
        else {
            str[i] = keyT[a[0]][a[3]];
            str[i + 1] = keyT[a[2]][a[1]];
        }
        }
    }

    static void encryptByPlayfairCipher(char str[], char key[]){
        int ps; 
        int ks;
        char[][] keyT = new char[5][5];
        ks = key.length;
        ks = removeSpaces(key, ks);
        toLowerCase(key, ks);
        ps = str.length;
        toLowerCase(str, ps);
        ps = removeSpaces(str, ps);
        ps = prepare(str, ps);
        generateKeyTable(key, ks, keyT);
        encrypt(str, keyT, ps);
    }

    public static void strcpy(char[] arr, String s) {
        for(int i = 0;i < s.length();i++){
        arr[i] = s.charAt(i);
        }
    }

    public void encryption(String PT, String key){
        char str[] = new char[30];
        char k[] = new char[30];
        strcpy(k, key); // create the key array
        strcpy(str, PT); // create plaintext array
        encryptByPlayfairCipher(str, k);
        CT = String.valueOf(str);
        JOptionPane.showMessageDialog(PlayfairCipherGUI.frame, "Ciphertext: " + CT);
    }
    
    public void decryption(String CT, String key){
        char str[] = new char[30];
        char k[] = new char[30];
        strcpy(k, key); // create the key array
        strcpy(str, CT); // create ciphertext array
        decryptByPlayfairCipher(str, k);
        PT = String.valueOf(str);
        JOptionPane.showMessageDialog(PlayfairCipherGUI.frame, "Plaintext: " + PT);
    }
    
    public static void decryptByPlayfairCipher(char str[], char key[]){
        int ps; 
        int ks;
        char[][] keyT = new char[5][5];
        ks = key.length;
        ks = removeSpaces(key, ks);
        toLowerCase(key, ks);
        ps = str.length;
        toLowerCase(str, ps);
        ps = removeSpaces(str, ps);
        generateKeyTable(key, ks, keyT);
        decrypt(str, keyT, ps);
    }
    
    public static void decrypt(char str[], char keyT[][], int ps){
        int i;
        int[] a = new int[4];
        for (i = 0; i < ps; i += 2) {
            search(keyT, str[i], str[i + 1], a);
            if (a[0] == a[2]) {
                str[i] = keyT[a[0]][mod5(a[1] - 1 + 5)];
                str[i + 1] = keyT[a[0]][mod5(a[3] - 1 + 5)];
            }
            else if (a[1] == a[3]) {
                str[i] = keyT[mod5(a[0] - 1 + 5)][a[1]];
                str[i + 1] = keyT[mod5(a[2] - 1 + 5)][a[1]];
            }
            else {
                str[i] = keyT[a[0]][a[3]];
                str[i + 1] = keyT[a[2]][a[1]];
            }
        }
    }
}