import java.util.Arrays;
import javax.swing.JOptionPane;

public class Railfance {
    private String PT;
    private String CT;
    private int key;
    public Railfance(){
        PT = "";
        CT = "";
        key = 3;
    }
    public void encryption(String PT, int key){
        this.PT=PT;
        this.key=key;
        char encmatrix[][] = new char[key][PT.length()];
        boolean flag = false;
        int j = 0;
        for(int i=0;i<PT.length();i++){//to store characters
            if(j==0||j==key-1)
                flag=!flag;
            encmatrix[j][i]=PT.charAt(i);
            if(flag)
                j++;
            else
                j--;
        }
        for(int l=0;l<key;l++){
            for(int m=0;m<PT.length();m++){
                if(encmatrix[l][m]!=0){
                    CT += encmatrix[l][m];
                }
            }
        }
        JOptionPane.showMessageDialog(RailfanceCipherGUI.frame, "Ciphertext: " + CT);
    }
    public void decryption(String CT,int key){
        this.CT=CT;
        this.key=key;
		char[][] decmatrix = new char[key][CT.length()];
		for (int i = 0; i < key; i++)
			Arrays.fill(decmatrix[i], '\n');
		boolean dirDown = true;
		int row = 0, col = 0;
		for (int i = 0; i < CT.length(); i++) {
			if (row == 0)
				dirDown = true;
			if (row == key - 1)
				dirDown = false;
			decmatrix[row][col++] = '*';
			if (dirDown)
				row++;
			else
				row--;
		}
		int index = 0;
		for (int i = 0; i < key; i++)
			for (int j = 0; j < CT.length(); j++)
				if (decmatrix[i][j] == '*' && index < CT.length())
					decmatrix[i][j] = CT.charAt(index++);
		StringBuilder result = new StringBuilder();
		row = 0;
		col = 0;
		for (int i = 0; i < CT.length(); i++) {
			if (row == 0)
				dirDown = true;
			if (row == key - 1)
				dirDown = false;
			if (decmatrix[row][col] != '*')
				result.append(decmatrix[row][col++]);
			if (dirDown)
				row++;
			else
				row--;
		}
        PT = result.toString();
        JOptionPane.showMessageDialog(RailfanceCipherGUI.frame, "Plaintext: " + PT);
	}
}
