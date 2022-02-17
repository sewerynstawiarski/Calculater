package com.HighLand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Kalkulator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] cyfryButtons = new JButton[10];
    JButton[] funkcjeButtons = new JButton[9];
    JButton plusButton, minusButton, razyButton, dzielButton, kropkaButton, wynikButton, kasujButton, clearButton, ujemnaButton;
    JPanel panel;

    Font myFont = new Font("MV Boli", Font.BOLD, 30);

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Kalkulator() {
        frame = new JFrame("KALKULATOR");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(440, 540);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(25,25,380,100);
        textField.setFont(myFont);
        textField.setEditable(false);

        plusButton = new JButton("+");
        minusButton = new JButton("-");
        razyButton =  new JButton("*");
        dzielButton = new JButton("/");
        kropkaButton = new JButton(".");
        wynikButton = new JButton("=");
        kasujButton = new JButton("DELETE");
        clearButton = new JButton("CLEAR");
        ujemnaButton = new JButton("(-)");

        funkcjeButtons[0] = plusButton;
        funkcjeButtons[1] = minusButton;
        funkcjeButtons[2] = razyButton;
        funkcjeButtons[3] = dzielButton;
        funkcjeButtons[4] = kropkaButton;
        funkcjeButtons[5] = wynikButton;
        funkcjeButtons[6] = kasujButton;
        funkcjeButtons[7] = clearButton;
        funkcjeButtons[8] = ujemnaButton;

        for (int i=0; i<9; i++) {
            funkcjeButtons[i].addActionListener(this);
            funkcjeButtons[i].setFont(myFont);
            funkcjeButtons[i].setFocusable(false);
            funkcjeButtons[i].setBackground(new Color(90,150,50));
        }
        for (int i=0; i<10; i++) {
            cyfryButtons[i] =  new JButton(String.valueOf(i));
            cyfryButtons[i].addActionListener(this);
            cyfryButtons[i].setFont(myFont);
            cyfryButtons[i].setFocusable(false);
            cyfryButtons[i].setBackground(new Color(150,100,100));
        }

        kasujButton.setBounds(25,440,126,50);
        ujemnaButton.setBounds(153,440,126,50);
        clearButton.setBounds(280,440,126,50);

        panel = new JPanel();
        panel.setBounds(25,135,380,300);
        panel.setLayout(new GridLayout(4,4,5,5));
        panel.add(cyfryButtons[1]);
        panel.add(cyfryButtons[2]);
        panel.add(cyfryButtons[3]);
        panel.add(plusButton);
        panel.add(cyfryButtons[4]);
        panel.add(cyfryButtons[5]);
        panel.add(cyfryButtons[6]);
        panel.add(minusButton);
        panel.add(cyfryButtons[7]);
        panel.add(cyfryButtons[8]);
        panel.add(cyfryButtons[9]);
        panel.add(razyButton);
        panel.add(kropkaButton);
        panel.add(cyfryButtons[0]);
        panel.add(dzielButton);
        panel.add(wynikButton);


        frame.add(panel);
        frame.add(kasujButton);
        frame.add(ujemnaButton);
        frame.add(clearButton);
        frame.add(textField);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i<10; i++) {
            if (e.getSource() == cyfryButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == kropkaButton) {
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource()==plusButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText(" ");
        }
        if (e.getSource()==minusButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText(" ");
        }
        if (e.getSource()==razyButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText(" ");
        }
        if (e.getSource() == dzielButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText(" ");
        }
        if (e.getSource()==wynikButton) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case'+' :
                    result = num1+num2;
                    break;
                case'-' :
                    result = num1-num2;
                    break;
                case '*' :
                    result = num1*num2;
                case'/' :
                    result =  num1/num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource()==clearButton) {
            textField.setText(" ");
        }
        if (e.getSource() == kasujButton) {
            String text = textField.getText();
            textField.setText(" ");
            for (int i = 0; i<text.length()-1; i++) {
                textField.setText(textField.getText()+text.charAt(i));
            }
        }
        if (e.getSource()==ujemnaButton) {
            double temp = Double.parseDouble(textField.getText());
            temp*=-1;
            textField.setText(String.valueOf(temp));
        }
    }
}
