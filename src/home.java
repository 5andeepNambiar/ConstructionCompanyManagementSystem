package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;

public class home extends JFrame implements ActionListener{

    JPanel panel;
    JLabel label1,label2,header_label;
    JButton btnLogin,btnAbout,btnExit;
    Connection con;

    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home window = new home();
					window.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

    home()
    {
        setTitle("Construction Company Management System");
        setSize(970,698);
        setResizable(false);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0,40,970,698);
        panel.setBackground(new Color(0,0,0));
        this.add(panel);
        
        label1 = new JLabel("");
        label1.setIcon(new ImageIcon(this.getClass().getResource("assets/home.jpg")));
        label1.setBounds(0, 40, 970, 698);
        panel.add(label1);

        label2 = new JLabel("");
        label2.setIcon(new ImageIcon(this.getClass().getResource("assets/logo.jpg")));
        label2.setBounds(3, 0, 50, 40);
        panel.add(label2);

        header_label = new JLabel("WELCOME TO CCMS HOMEPAGE!");
        header_label.setFont(new Font("Calibri", Font.BOLD, 18));
        header_label.setBounds(300, 3, 400, 40);
		header_label.setForeground(new Color(250,235,215));
        panel.add(header_label);

        btnAbout = new JButton("ABOUT");
        btnAbout.addActionListener(this);
        btnAbout.setBounds(648,6,98,30);
        panel.add(btnAbout);

        btnLogin = new JButton("LOGIN");
        btnLogin.addActionListener(this);
        btnLogin.setBounds(750,6,98,30);
        panel.add(btnLogin);

        btnExit = new JButton("EXIT");
        btnExit.addActionListener(this);
        btnExit.setBounds(852,6,98,30); 
        panel.add(btnExit);


    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==btnLogin)
        {
            try 
            {
                LoginForm login = new LoginForm();
                login.setSize(500, 500);
                login.setVisible(true);
            } 
            catch (Exception e) 
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }

        else if (ae.getSource()==btnAbout)
        {
            try 
            {
                JOptionPane.showMessageDialog(null,"A system that can automatically evaluate the data regarding the construction company that constructs houses for a number of clients.");
            } 
            catch (Exception e) 
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }

        else if (ae.getSource()==btnExit)
        {
            System.exit(0);
        }
        
    }
    
}

