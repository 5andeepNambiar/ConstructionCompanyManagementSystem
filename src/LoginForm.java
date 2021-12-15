package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import src.sqlUtils.Auth;


public class LoginForm extends JFrame implements ActionListener{
    JLabel login_register;
    JPanel login_window;
    JLabel role,password,user_id,label,image_label,logo_label;
    JTextField user_id_input;
    JPasswordField password_input;
    GridBagConstraints Gridwidth;
    JButton login_button,register_button;
    JComboBox<String> role_select;

    LoginForm() 
    {
        setTitle("Construction Company Management System");
        setSize(500,590);
        setLocationRelativeTo(null);
        setResizable(false);

        login_button = new JButton("Login");
        login_button.addActionListener(this);
        register_button = new JButton("Register");
        register_button.addActionListener(this);

        login_window = new JPanel();
        login_window.setBackground(new Color(0,0,0));
        this.getContentPane().add(login_window);
        login_window.setLayout(null);
        login_window.setBounds(0, 0, 500, 500);

        image_label = new JLabel("");
        image_label.setIcon(new ImageIcon(this.getClass().getResource("assets/login.jpg")));
        image_label.setLayout(null);
        image_label.setBounds(0, 40, 500, 500);
        login_window.add(image_label);

        
        String Options[] = {"","Admin", "SiteAdmin", "Supplier", "Customer" };
        role_select = new JComboBox<String>(Options);


        role = new JLabel("Role:");
        role.setFont(new Font("SansSerif", Font.BOLD, 15));
        role.setForeground(new Color(0,0,0));
        user_id = new JLabel("User ID:");
        user_id.setFont(new Font("SansSerif", Font.BOLD, 15));
        user_id.setForeground(new Color(0,0,0));
        password = new JLabel("Password:");
        password.setFont(new Font("SansSerif", Font.BOLD, 15));
        password.setForeground(new Color(0,0,0));

        login_register = new JLabel("Login");
        login_register.setFont(new Font("Serif",Font.BOLD,25));
        login_register.setForeground(new Color(250,235,215));

        logo_label = new JLabel("");
        logo_label.setIcon(new ImageIcon(this.getClass().getResource("assets/logo.jpg")));
        logo_label.setBounds(3, 0, 50, 40);
        login_window.add(logo_label);

        user_id_input = new JTextField();
        password_input = new JPasswordField();

        role.setBounds(80,140,100,30);
        user_id.setBounds(80,180,100,30);
        password.setBounds(80,220,100,30);

        role_select.setBounds(180,140,200,30);
        user_id_input.setBounds(180,180,200,30);
        password_input.setBounds(180,220,200,30);

        login_button.setBounds(170,280,100,30);
        register_button.setBounds(273,280,100,30);
        

        login_register.setBounds(190,3,100,35);


        image_label.add(role);
        image_label.add(user_id);
        image_label.add(password);
        image_label.add(role_select);
        image_label.add(user_id_input);
        image_label.add(password_input);
        image_label.add(login_button);
        image_label.add(register_button);
        login_window.add(login_register);

        add(login_window, BorderLayout.CENTER);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent ae) {
        
        String option = role_select.getItemAt(role_select.getSelectedIndex()); 
        String Username = user_id_input.getText();

        if(ae.getSource()==login_button)
        {
            Auth auth = new Auth(user_id_input.getText(), new String(password_input.getPassword()));
            auth.Authenticate(Username,option);
            if (auth.isAuthenticated)
            {
                JOptionPane.showMessageDialog(null, "Login Successful !");
                if(option.equals("Admin"))
                {
                    AdminDashboard admin = new AdminDashboard();
                    admin.setVisible(true);
                    this.dispose();
                }
                else if(option.equals("SiteAdmin"))
                {
                    SiteAdminDashboard siteAdmin = new SiteAdminDashboard();
                    siteAdmin.setVisible(true);
                    this.dispose();
                }
                else if(option.equals("Supplier"))
                {
                    SupplierDashboard supplier = new SupplierDashboard();
                    supplier.setVisible(true);
                    this.dispose();
                }
                else if(option.equals("Customer"))
                {
                    ClientDashboard customer = new ClientDashboard(Username);
                    customer.setVisible(true);
                    this.dispose();
                }
                
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Wrong Username or Password.");
            }

		} 
        else if (ae.getSource() == register_button) 
        {
			System.out.println("Signup Event");
			RegistrationForm register = new RegistrationForm();
			register.setVisible(true);
			this.dispose();
		}
    }   
}
