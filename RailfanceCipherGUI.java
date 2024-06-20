import javax.swing.*;
import java.awt.event.*;

public class RailfanceCipherGUI {
    public static JFrame frame;
    private JTextField ptctField;
    private JTextField keyField;
    private JComboBox<String> operationComboBox;
    private JButton calculateButton;
    private Railfance r;

    public RailfanceCipherGUI() {
        createGUI();
    }

    private void createGUI() {
        frame = new JFrame("Railfance Cipher");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        frame.getContentPane().add(panel);

        JLabel ptctLabel = new JLabel("Plaintext/Ciphertext:");
        panel.add(ptctLabel);

        ptctField = new JTextField(15);
        ptctField.setToolTipText("Enter plaintext or ciphertext");
        panel.add(ptctField);

        JLabel keyLabel = new JLabel("Key (Matrix columns):");
        panel.add(keyLabel);

        keyField = new JTextField(5); 
        keyField.setToolTipText("Enter key (Matrix column)");
        panel.add(keyField);

        JLabel operationLabel = new JLabel("Operation:");
        panel.add(operationLabel);

        String[] operations = {"Encrypt", "Decrypt"};
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
            r = new Railfance();
            String ptct = ptctField.getText();
            int key = Integer.parseInt(keyField.getText());
            String operation = (String) operationComboBox.getSelectedItem();

            if (operation.equals("Encrypt")) {
                r.encryption(ptct, key);
            } else if (operation.equals("Decrypt")) {
                r.decryption(ptct, key);
            }
        }
    }
}