package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import src.sqlUtils.Auth;

public class RegistrationForm extends JFrame implements ActionListener{
    JLabel login_register;
    JPanel login_window,register_window;
    JLabel role,user_id,first_name,last_name,password,email,mobile_no,city,state,pincode,image_label,logo_label;
    JTextField user_id_input,first_name_input,last_name_input,email_input,mobile_no_input,city_input,state_input,pincode_input;
    JPasswordField password_input;
    GridBagConstraints Gridwidth;
    JButton login_button,register_button;
    JComboBox<String> role_select;


    RegistrationForm() 
    {
        setTitle("Construction Company Management System");
        setSize(700,440);
        setLocationRelativeTo(null);
        setResizable(false);


        login_button = new JButton("Login");
        login_button.addActionListener(this);
        register_button = new JButton("Register");
        register_button.addActionListener(this);


        register_window = new JPanel();
        register_window.setBackground(new Color(0,0,0));
        this.getContentPane().add(register_window);
        register_window.setLayout(null);
        register_window.setBounds(0, 0, 400, 400);
        register_window.add(login_button);

        String Options[] = {" ","Admin", "SiteAdmin", "Supplier", "Customer" };
        role_select = new JComboBox<String>(Options);

        image_label = new JLabel("");
        image_label.setIcon(new ImageIcon(this.getClass().getResource("assets/reg.jpg")));
        image_label.setLayout(null);
        image_label.setBounds(0, 40, 700, 400);
        register_window.add(image_label);

        logo_label = new JLabel("");
        logo_label.setIcon(new ImageIcon(this.getClass().getResource("assets/logo.jpg")));
        logo_label.setBounds(3, 0, 50, 40);
        register_window.add(logo_label);


        role = new JLabel("Role:");
        role.setForeground(Color.WHITE);
        first_name = new JLabel("First Name:");
        first_name.setForeground(Color.WHITE);
        last_name = new JLabel("Last Name:");
        last_name.setForeground(Color.WHITE);
        user_id = new JLabel("User ID:");
        user_id.setForeground(Color.WHITE);
        email = new JLabel("Email:");
        email.setForeground(Color.WHITE);
        password = new JLabel("Password:");
        password.setForeground(Color.WHITE);
		mobile_no = new JLabel("Mobile No:");
        mobile_no.setForeground(Color.WHITE);
		city = new JLabel("City:");
        city.setForeground(Color.WHITE);
		state = new JLabel("State:");
        state.setForeground(Color.WHITE);
        pincode = new JLabel("Pincode:");
        pincode.setForeground(Color.WHITE);


        login_register = new JLabel("Register");
        login_register.setFont(new Font("Serif",Font.BOLD,25));
        login_register.setForeground(new Color(255,255,255));

        user_id_input = new JTextField();
        first_name_input = new JTextField();
        last_name_input = new JTextField();
		email_input = new JTextField();
        password_input = new JPasswordField();
		mobile_no_input = new JTextField();
		city_input = new JTextField();
		state_input = new JTextField();
        pincode_input = new JTextField();

        

        role.setBounds(30,80,100,25);
        role_select.setBounds(140,80,140,25);

        user_id.setBounds(350,80,100,25);
        user_id_input.setBounds(450,80,140,25);

        first_name.setBounds(30,120,100,25);
        first_name_input.setBounds(140,120,140,25);

        last_name.setBounds(350,120,100,25);
        last_name_input.setBounds(450,120,140,25);

        email.setBounds(30,160,100,25);
        email_input.setBounds(140,160,140,25);

        password.setBounds(350,160,100,25);
        password_input.setBounds(450,160,140,25);

        mobile_no.setBounds(30,200,100,25);
        mobile_no_input.setBounds(140,200,140,25);

        city.setBounds(350,200,100,25);
        city_input.setBounds(450,200,140,25);

        state.setBounds(30,240,100,25);
        state_input.setBounds(140,240,140,25);

        pincode.setBounds(350,240,100,25);
        pincode_input.setBounds(450,240,140,25);    
        
        register_button.setBounds(250,300,100,30);
        login_button.setBounds(352,300,100,30);

        login_register.setBounds(300,3,100,35);


        image_label.add(role);
        image_label.add(first_name);
        image_label.add(last_name);
        image_label.add(user_id);
        image_label.add(email);
        image_label.add(password);
        image_label.add(mobile_no);
        image_label.add(city);
        image_label.add(state);
        image_label.add(pincode);
        image_label.add(role_select);
        image_label.add(user_id_input);
        image_label.add(first_name_input);
        image_label.add(last_name_input);
        image_label.add(email_input);
        image_label.add(password_input);
        image_label.add(mobile_no_input);
        image_label.add(city_input);
        image_label.add(state_input);
        image_label.add(pincode_input);
        image_label.add(register_button);
        image_label.add(login_button);
        register_window.add(login_register);

        add(register_window, BorderLayout.CENTER);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource()==register_button)
        {
            String option = role_select.getItemAt(role_select.getSelectedIndex()); 
            String Username = user_id_input.getText();
            String First_Name = first_name_input.getText();
            String Last_Name = last_name_input.getText();
            String Email = email_input.getText();
            // String Password = password_input.getText();
            int Mobile_No = Integer.parseInt(mobile_no_input.getText());
            String City = city_input.getText();
            String State = state_input.getText();
            int Pincode = Integer.parseInt(pincode_input.getText());

            Auth auth = new Auth(user_id_input.getText(), new String(password_input.getPassword()));
            auth.Authenticate(Username,option);
            if (auth.isAuthenticated==false) 
            {
                JOptionPane.showMessageDialog(null, "User registration success !");
                if(option.equals("Customer"))
                {
                    auth.CreateAccount(option,First_Name,Last_Name,Email,Mobile_No,City,State,Pincode);
                    JOptionPane.showMessageDialog(null, "Customer registration success !");
                    ClientDashboard cd = new ClientDashboard(Username);
                    cd.setVisible(true);
                }
                else if(option.equals("SiteAdmin"))
                {
                    auth.CreateAccount(option,First_Name,Last_Name,Email,Mobile_No,City,State,Pincode);
                    JOptionPane.showMessageDialog(null, "Site Admin registration success !");
                    SiteAdminDashboard sad = new SiteAdminDashboard();
                    sad.setVisible(true);
                }
                
                else if(option.equals("Admin"))
                {
                    auth.CreateAccount(option,First_Name,Last_Name,Email,Mobile_No,City,State,Pincode);
                    JOptionPane.showMessageDialog(null, "Admin registration success !");
                    AdminDashboard ad = new AdminDashboard();
                    ad.setVisible(true);
                }
                else if(option.equals("Supplier"))
                {
                    auth.CreateAccount(option,First_Name,Last_Name,Email,Mobile_No,City,State,Pincode);
                    JOptionPane.showMessageDialog(null, "Supplier registration success !");
                    SupplierDashboard sd = new SupplierDashboard();
                    sd.setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Please select a role to continue!");
                }
            } 
            else 
            {
                JOptionPane.showMessageDialog(null, "Could not register user !");
            }
        }

        else if(ae.getSource()==login_button)
        {
            this.dispose();
            LoginForm login = new LoginForm();
            login.setVisible(true);
            login.setSize(500,500);
        }
    }

}