package ui;

import javax.swing.*;
import java.awt.event.*;

public class LoginFrame extends JFrame{

    JTextField user=new JTextField();
    JPasswordField pass=new JPasswordField();

    public LoginFrame(){

        setTitle("Bank System Login");
        setSize(320,200);
        setLayout(null);

        JLabel u=new JLabel("Username");
        JLabel p=new JLabel("Password");

        JButton login=new JButton("Login");

        u.setBounds(40,30,100,25);
        p.setBounds(40,70,100,25);

        user.setBounds(140,30,120,25);
        pass.setBounds(140,70,120,25);

        login.setBounds(110,120,90,30);

        add(u); add(p); add(user); add(pass); add(login);

        login.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){

                if(user.getText().equals("admin") &&
                   new String(pass.getPassword()).equals("admin")){

                    dispose();
                    new Dashboard();

                }else{

                    JOptionPane.showMessageDialog(null,"Invalid Login");

                }
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}