package login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

class MyLogin implements ActionListener {

    JFrame frame = new JFrame();

    JButton user_button, pass_button;
    JButton login_button, signup_button;

    JTextField user_textField, pass_textField;

    Font button_font = new Font("Comic Sans MS",Font.BOLD,21);
    Font textField_font = new Font("MV Boli",Font.BOLD,21);
    Font label_font = new Font("Helvetica",Font.BOLD,16);

    Color label_color = new Color(170,208,141);

    ArrayList<String> username = new ArrayList<>();
    ArrayList<String> password = new ArrayList<>();

    JProgressBar progressBar = new JProgressBar(0,100);
    JLabel signup_label = new JLabel("Signup Successful!");
    JLabel login_label = new JLabel("Login Successful");

    MyLogin(){

        //Labels
        signup_label.setBounds(40,220,160,20);
        signup_label.setVisible(false);
        signup_label.setFont(label_font);
        signup_label.setForeground(label_color);

        login_label.setBounds(40,220,160,20);
        login_label.setVisible(false);
        login_label.setFont(label_font);
        login_label.setForeground(label_color);

//        //progress track --- // --- // -- // -- // -- // -- // --
        progressBar.setBounds(40,200,60,20);
        progressBar.setBorderPainted(true);
        progressBar.setValue(0);

        // Binary TextField work ------- i Am textField -------//
        user_textField = new JTextField();
        user_textField.setFont(textField_font);
        user_textField.setBounds(180,40,305,50);

        pass_textField = new JTextField();
        pass_textField.setFont(textField_font);
        pass_textField.setBounds(180,110,305,50);

        // Unlimited Button works ----- fate/stay Java -----//
        user_button = new JButton("UserName");
        user_button.setFont(button_font);
        user_button.setBounds(40,40,120,50);

        pass_button = new JButton("PassWord");
        pass_button.setFont(button_font);
        pass_button.setBounds(40,110,120,50);

        login_button = new JButton("Login");
        login_button.setFont(button_font);
        login_button.setBounds(235,200,120,50);
        login_button.addActionListener(this);

        signup_button = new JButton("Sign Up");
        signup_button.setFont(button_font);
        signup_button.setBounds(365,200,120,50);
        signup_button.addActionListener(this);

        // frame tweaks ------------- twerks --------------//
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(525,325);

        // adding to frame
        frame.add(user_button);
        frame.add(pass_button);
        frame.add(user_textField);
        frame.add(pass_textField);
        frame.add(login_button);
        frame.add(signup_button);
        frame.add(progressBar);
        frame.add(signup_label);
        frame.add(login_label);

        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == login_button){
            signup_label.setVisible(false);
            progressBar.setValue(0);

            if (username.contains(user_textField.getText())){
                int location = 0;
                for (String s : username) {
                    if (s.equals(user_textField.getText())) {
                        break;
                    }
                    location += 1;
                }
                if (password.get(location).equals(pass_textField.getText())){
                    login_label.setVisible(true);
                }
            }
            user_textField.setText("");
            pass_textField.setText("");
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            progressBar.setValue(100);
        }

        if (e.getSource() == signup_button){
            login_label.setVisible(false);

            System.out.println(user_textField.getText() + pass_textField.getText());
            if (!username.contains(user_textField.getText())){username.add(user_textField.getText());password.add(pass_textField.getText());}
            else {JOptionPane.showMessageDialog(null,"Existing yousername!");}
            user_textField.setText("");
            pass_textField.setText("");

            progressBar.setVisible(true);
            progressBar.setValue(100);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            signup_label.setVisible(true);
        }
    }
}

// --------------------------------------//
//I am the protagonist,I have plot armor//
public class main {
    public static void main(String[] args){
        new MyLogin();
    }
}
