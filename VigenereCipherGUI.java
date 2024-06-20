import javax.swing.*;
import java.awt.event.*;

public class VigenereCipherGUI {
    public static JFrame frame;
    private JTextField ptctField;
    private JTextField keyField;
    private JComboBox<String> operationComboBox;
    private JButton calculateButton;
    private Vigenere v;

    public VigenereCipherGUI() {
        createGUI();
    }

    private void createGUI() {
        frame = new JFrame("Vigenere Cipher");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel with a vertical BoxLayout
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        frame.getContentPane().add(panel);

        JLabel ptctLabel = new JLabel("Plaintext/Ciphertext:");
        panel.add(ptctLabel);

        ptctField = new JTextField(15); // Decreased the column size to 15
        ptctField.setToolTipText("Enter plaintext or ciphertext");
        panel.add(ptctField);

        JLabel keyLabel = new JLabel("Keyword:");
        panel.add(keyLabel);

        keyField = new JTextField(5); // Decreased the column size to 5
        keyField.setToolTipText("Enter keyword");
        panel.add(keyField);

        JLabel operationLabel = new JLabel("Operation:");
        panel.add(operationLabel);

        String[] operations = {"Encrypt", "Decrypt"};
        operationComboBox = new JComboBox<>(operations);
        panel.add(operationComboBox);

        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateButtonListener());
        panel.add(calculateButton);

        frame.setSize(300, 200); // Frame size remains the same
        frame.setLocation(500,362);
        frame.setVisible(true);
    }


    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            v = new Vigenere();
            String ptct = ptctField.getText();
            String key = keyField.getText();
            String operation = (String) operationComboBox.getSelectedItem();

            if (operation.equals("Encrypt")) {
                v.encrypt(ptct, key);
            } else if (operation.equals("Decrypt")) {
                v.decrypt(ptct, key);
            }
        }
    }
}