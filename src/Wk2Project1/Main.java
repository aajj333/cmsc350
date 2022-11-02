/*
 * author: Alex Reveles
 * project 1
 * date: 11/1/22
 * description: Use a GUI to convert prefix expressions to postfix and postfix to prefix
 */

package Wk2Project1;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Main extends JFrame implements ActionListener {
    private final JLabel enterExp = new JLabel("Enter Expression");
    private final JTextField expField = new JTextField(20);
    private final JButton prefixPostfix = new JButton("Prefix to Postfix");
    private final JButton postfixPrefix = new JButton("Postfix to Prefix");
    private final JLabel resLabel = new JLabel("Result");
    private final JTextField resTxt = new JTextField(20);

    public static void main(String[] args) {
        Main frame = new Main();
        frame.setVisible(true);
    }

    public Main() {
        super("Expression Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 500, 400, 150);
        setResizable(false);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout());
        contentPane.add(topPanel(), BorderLayout.NORTH);
        contentPane.add(middlePanel(), BorderLayout.CENTER);
        contentPane.add(bottomPanel(), BorderLayout.SOUTH);
        setContentPane(contentPane);
    }

    private JPanel topPanel() {
        JPanel topPanel = new JPanel();
        topPanel.add(enterExp);
        topPanel.add(expField);
        return topPanel;
    }

    private JPanel middlePanel() {
        JPanel midPanel = new JPanel();
        midPanel.add(prefixPostfix);
        midPanel.add(postfixPrefix);
        prefixPostfix.addActionListener(this);
        postfixPrefix.addActionListener(this);
        return midPanel;
    }

    private JPanel bottomPanel() {
        JPanel botPanel = new JPanel();
        botPanel.add(resLabel);
        botPanel.add(resTxt);
        resTxt.setEditable(false);
        return botPanel;
    }

    public void actionPerformed(ActionEvent e) {
        try {
            String expressionString = expField.getText();
            if(e.getSource() == prefixPostfix) {
                String converted = Convert.fromPrefixToPostfix(expressionString);
                resTxt.setText(converted);
            } else if(e.getSource() == postfixPrefix) {
                String converted = Convert.fromPostfixToPrefix(expressionString);
                resTxt.setText(converted);
            }
        } catch(NullPointerException | IOException | SyntaxError ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }
}