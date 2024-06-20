import javax.swing.*;
import java.awt.event.*;

public class PlayfairCipherGUI {
    public static JFrame frame;
    private JTextField ptctField;
    private JTextField keyField;
    private JComboBox<String> operationComboBox;
    private JButton calculateButton;
    private Playfair p;

    public PlayfairCipherGUI() {
        createGUI();
    }

    private void createGUI() {
        frame = new JFrame("Playfair Cipher");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        frame.getContentPane().add(panel);

        JLabel ptctLabel = new JLabel("Plaintext");
        panel.add(ptctLabel);

        ptctField = new JTextField(15);
        ptctField.setToolTipText("Enter plaintext");
        panel.add(ptctField);

        JLabel keyLabel = new JLabel("Keyword:");
        panel.add(keyLabel);

        keyField = new JTextField(5); 
        keyField.setToolTipText("Enter keyword");
        panel.add(keyField);

        JLabel operationLabel = new JLabel("Operation:");
        panel.add(operationLabel);

        String[] operations = {"Encrypt","Decryption"};
        operationComboBox = new JComboBox<>(operations);
        panel.add(operationComboBox);

        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateButtonListener());
        panel.add(calculateButton);

        frame.setSize(300, 200);
        frame.setLocation(500,362);
        frame.setVisible(true);
    }


    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            p = new Playfair();
            String ptct = ptctField.getText();
            String key = keyField.getText();
            String operation = (String) operationComboBox.getSelectedItem();

            if (operation.equals("Encrypt")) {
                p.encryption(ptct,key);
            }
            else if (operation.equals("Decryption")){
                p.decryption(ptct, key);
            }
        }
    }
}
