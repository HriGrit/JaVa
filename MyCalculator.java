package a_calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyCalculator implements ActionListener {

    JFrame frame = new JFrame();
    JTextField textField = new JTextField();

    JButton[] number_button = new JButton[10];
    JButton[] function_button = new JButton[7];

    JButton add_button, minu_button, multiply_button;
    JButton divide_button, dot_button, equal_button;
    JButton del_button, clr_button;

    JPanel panel = new JPanel();

    Font myfont = new Font("Comic Sans MS",Font.BOLD,32);
    Font button_font = new Font("Comic Sans MS", Font.BOLD,38);

    double num1=0, num2=0, result = 0;
    char operator;

    MyCalculator(){

        // text_field
        textField.setFont(myfont);
        textField.setBounds(20,20,410,60);
        textField.setEnabled(false);

        // for buttons

            // del and clear;
        del_button = new JButton("Delete");
        del_button.setBounds(20,400,200,60);
        del_button.addActionListener(this);
        del_button.setFont(myfont);

        clr_button = new JButton("Clear");
        clr_button.setBounds(230,400,200,60);
        clr_button.addActionListener(this);
        clr_button.setFont(myfont);

            // function__button
        add_button = new JButton("+");
        minu_button = new JButton("-");
        multiply_button = new JButton("*");
        divide_button = new JButton("/");
        dot_button = new JButton(".");
        equal_button = new JButton("=");

        function_button[0] = add_button;
        function_button[1] = minu_button;
        function_button[2] = multiply_button;
        function_button[3] = divide_button;
        function_button[4] = dot_button;
        function_button[5] = equal_button;

        for (int i = 0; i < 6; i++){
            function_button[i].setFont(myfont);
            function_button[i].addActionListener(this);
        }

        ///////////////////////////////////////////////////////////
//            // number buttons
        for (int i = 0; i < 10; i++){
            String temp = String.valueOf(i);
            number_button[i] = new JButton(temp);
            number_button[i].setFont(button_font);
            number_button[i].addActionListener(this);
        }

        //////////////// Adding it all to panel ///////////////////
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBounds(20,100,410,280);
        panel.setOpaque(true);

        for (int i = 1; i < 4; i++){panel.add(number_button[i]);}
        panel.add(add_button);
        for (int i = 4; i < 7; i++){panel.add(number_button[i]);}
        panel.add(minu_button);
        for(int i = 7; i < 10; i++){panel.add(number_button[i]);}
        panel.add(multiply_button);

        // last line
        panel.add(dot_button);
        panel.add(number_button[0]);
        panel.add(equal_button);
        panel.add(divide_button);

        // frame settings
        frame.setSize(450,550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(textField);
        frame.add(panel);
        frame.add(del_button);
        frame.add(clr_button);

        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == clr_button){textField.setText("");}

        if (e.getSource() == del_button){
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length()-1; i++){textField.setText(textField.getText() + string.charAt(i));}
        }   

        for (int i = 0; i < 10; i ++) {
            if (e.getSource() == number_button[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == dot_button) {textField.setText(textField.getText().concat(String.valueOf(".")));}

        if (e.getSource() == add_button) {
            num1 = Double.parseDouble(textField.getText());
            textField.setText("");
            operator = '+';
        }

        if (e.getSource() == minu_button){
            num1 = Double.parseDouble(textField.getText());
            textField.setText("");
            operator = '+';
        }

        if (e.getSource() == multiply_button){
            num1 = Double.parseDouble(textField.getText());
            textField.setText("");
            operator = '*';
        }

        if (e.getSource() == divide_button){
            num1 = Double.parseDouble(textField.getText());
            textField.setText("");
            operator = '/';
        }

        if (e.getSource() == equal_button) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+' -> result = num1 + num2;
                case '-' -> result = num1 - num2;
                case '*' -> result = num1 * num2;
                case '/' -> result = num1 / num2;
            }

        textField.setText(String.valueOf(result));
        num1 = result;

        }
    }
}
