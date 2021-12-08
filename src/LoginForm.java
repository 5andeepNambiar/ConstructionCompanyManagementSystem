import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;

public class LoginForm extends JFrame implements ActionListener{
    JLabel login_register;
    JPanel login_window,register_window;
    JLabel user_id,password;
    JTextField password_input;
    GridBagConstraints Gridwidth;
    JButton login_button,register_button;
    JComboBox<String> user_id_input;

    LoginForm() 
    {
        setTitle("Construction Company Management System");
        setSize(480,450);
        setLocationRelativeTo(null);
        setResizable(false);

        login_button = new JButton("Login");
        login_button.addActionListener(this);
        register_button = new JButton("Register");
        register_button.addActionListener(this);

        login_window = new JPanel();
        login_window.setBackground(new Color(244, 164, 96));
        this.getContentPane().add(login_window);
        login_window.setLayout(null);
        login_window.setBounds(0, 0, 400, 400);
        

        String Options[] = { " ","Admin", "Site Admin", "Supplier", "Customer" };
        user_id_input = new JComboBox<String>(Options);


        user_id = new JLabel("User ID:");
        user_id.setFont(new Font("SansSerif", Font.BOLD, 15));
        password = new JLabel("Password:");
        password.setFont(new Font("SansSerif", Font.BOLD, 15));
        login_register = new JLabel("Login");
        login_register.setFont(new Font("Serif",Font.BOLD,25));

        password_input = new JTextField();

        user_id.setBounds(30,120,100,30);
        password.setBounds(30,160,100,30);

        user_id_input.setBounds(150,120,200,30);
        password_input.setBounds(150,160,200,30);

        login_button.setBounds(140,220,100,30);
        register_button.setBounds(260,220,100,30);
        

        login_register.setBounds(190,20,100,30);


        login_window.add(user_id);
        login_window.add(password);
        login_window.add(user_id_input);
        login_window.add(password_input);
        login_window.add(login_button);
        login_window.add(register_button);
        login_window.add(login_register);

        add(login_window, BorderLayout.CENTER);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent ae) {
        String option = user_id_input.getItemAt(user_id_input.getSelectedIndex()); 
        String Password = password_input.getText();

        if(ae.getSource() == login_button)
        {   
            this.dispose();
            if(option.equals("Admin"))
            {
                if(Password.equals("admin"))
                {
                    JOptionPane.showMessageDialog(null,"Login Successful");
                    AdminDashboard ad = new AdminDashboard();
                    ad.setVisible(true);
                    this.setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Invalid Password");
                }
            }
            else if(option.equals("Site Admin"))
            {
                if(Password.equals("siteadmin"))
                {
                    JOptionPane.showMessageDialog(null,"Login Successful");
                    SiteAdminDashboard sad = new SiteAdminDashboard();
                    sad.setVisible(true);
                    this.setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Invalid Password");
                }
            }
            else if(option.equals("Supplier"))
            {
                if(Password.equals("supplier"))
                {
                    JOptionPane.showMessageDialog(null,"Login Successful");
                    SupplierDashboard sd = new SupplierDashboard();
                    sd.setVisible(true);
                    this.setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Invalid Password");
                }
            }
            else if(option.equals("Customer"))
            {
                if(Password.equals("customer"))
                {
                    JOptionPane.showMessageDialog(null,"Login Successful");
                    ClientDashboard cd = new ClientDashboard();
                    cd.setVisible(true);
                    this.setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Invalid Password");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Invalid User");
            }
        }
        else if (ae.getSource() == register_button) {
            this.dispose();
            try {
                RegistrationForm register = new RegistrationForm();
                register.setVisible(true);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
}