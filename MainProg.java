import javax.swing.*;
import java.awt.event.*;

public class MainProg {
    private JFrame frame;
    private JComboBox<String> compBox;
    private JButton selecButton;


    public MainProg(){
        createGUI();
    }

    private void createGUI(){
        frame = new JFrame("Cryptography Program");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add an empty border
        frame.getContentPane().add(panel);
    
        JLabel operationLabel = new JLabel("Operation:");
        panel.add(operationLabel);
        panel.add(Box.createVerticalStrut(10)); // Add a vertical gap
    
        String[] ciphers = {"Caesar", "Railfance", "Playfair","Vigenere"};
        compBox = new JComboBox<>(ciphers);
        compBox.setMaximumSize(compBox.getPreferredSize()); 
        panel.add(compBox);
        panel.add(Box.createVerticalStrut(10)); // Add a vertical gap
    
        selecButton = new JButton("Select");
        selecButton.addActionListener(new selectButtonListener());
        panel.add(selecButton);
    
        frame.setSize(215, 150);
    
        // Set the frame location
        frame.setLocation(500,362);
    
        frame.setVisible(true);
    }

    private class selectButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String cipher = (String) compBox.getSelectedItem();
            if (cipher.equals("Caesar")) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new CaesarCipherGUI();
                    }
                });
            } else if (cipher.equals("Railfance")) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new RailfanceCipherGUI();
                    }
                });
            }   else if (cipher.equals("Playfair")) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new PlayfairCipherGUI();
                    }
                });
            }   else if (cipher.equals("Vigenere")) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new VigenereCipherGUI();
                    }
                });
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainProg();
            }
        });
    }
}