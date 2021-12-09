import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;

public class RegistrationForm extends JFrame implements ActionListener{
    JLabel login_register;
    JPanel login_window,register_window;
    JLabel role,user_id,first_name,last_name,password,email,mobile_no,city,state,pincode;
    JTextField user_id_input,first_name_input,last_name_input,password_input,email_input,mobile_no_input,city_input,state_input,pincode_input;
    GridBagConstraints Gridwidth;
    JButton login_button,register_button;
    JComboBox<String> role_select;

    RegistrationForm() 
    {
        setTitle("Construction Company Management System");
        setSize(500,650);
        setLocationRelativeTo(null);
        setResizable(false);


        login_button = new JButton("Login");
        login_button.addActionListener(this);
        register_button = new JButton("Register");
        register_button.addActionListener(this);

        register_window = new JPanel();
        register_window.setBackground(new Color(244, 164, 96));
        this.getContentPane().add(register_window);
        register_window.setLayout(null);
        register_window.setBounds(0, 0, 400, 400);
        register_window.add(login_button);

        String Options[] = { " ","Admin", "Site Admin", "Supplier", "Customer" };
        role_select = new JComboBox<String>(Options);


        role = new JLabel("Role:");
        first_name = new JLabel("First Name:");
        last_name = new JLabel("Last Name:");
        user_id = new JLabel("User ID:");
        email = new JLabel("Email:");
        password = new JLabel("Password:");
		mobile_no = new JLabel("Mobile No:");
		city = new JLabel("City:");
		state = new JLabel("State:");
        pincode = new JLabel("Pincode:");


        login_register = new JLabel("Register");
        login_register.setFont(new Font("Serif",Font.BOLD,25));

        user_id_input = new JTextField();
        first_name_input = new JTextField();
        last_name_input = new JTextField();
		email_input = new JTextField();
        password_input = new JTextField();
		mobile_no_input = new JTextField();
		city_input = new JTextField();
		state_input = new JTextField();
        pincode_input = new JTextField();

        

        role.setBounds(30,80,100,30);
        first_name.setBounds(30,120,100,30);
        last_name.setBounds(30,160,100,30);
        user_id.setBounds(30,200,100,30);
        email.setBounds(30,240,100,30);
        password.setBounds(30,280,100,30);
        mobile_no.setBounds(30,320,100,30);
        city.setBounds(30,360,100,30);
        state.setBounds(30,400,100,30);
        pincode.setBounds(30,440,100,30);



        role_select.setBounds(140,80,200,30);
        first_name_input.setBounds(140,120,200,30);
        last_name_input.setBounds(140,160,200,30);
        user_id_input.setBounds(140,200,200,30);
        email_input.setBounds(140,240,200,30);
        password_input.setBounds(140,280,200,30);
        mobile_no_input.setBounds(140,320,200,30);
        city_input.setBounds(140,360,200,30);
        state_input.setBounds(140,400,200,30);
        pincode_input.setBounds(140,440,200,30);

        
        register_button.setBounds(130,500,100,30);
        login_button.setBounds(250,500,100,30);

        login_register.setBounds(190,20,100,30);


        register_window.add(role);
        register_window.add(first_name);
        register_window.add(last_name);
        register_window.add(user_id);
        register_window.add(email);
        register_window.add(password);        
		register_window.add(mobile_no);
		register_window.add(city);
		register_window.add(state);
        register_window.add(pincode);
        register_window.add(role_select);
        register_window.add(first_name_input);
        register_window.add(last_name_input);
        register_window.add(user_id_input);
		register_window.add(email_input);
        register_window.add(password_input);
		register_window.add(mobile_no_input);
		register_window.add(city_input);
		register_window.add(state_input);
        register_window.add(pincode_input);
        register_window.add(login_button);
        register_window.add(register_button);
        register_window.add(login_register);

        add(register_window, BorderLayout.CENTER);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent ae) {
        String option = role_select.getItemAt(role_select.getSelectedIndex()); 
        String Password = password_input.getText();

        if(ae.getSource()==register_button)
        {
            if(option == "" && Password == "")
            {
                /*
                1. Check if user exists
                2. Check if password is valid
                3. If correct, GO TO REQUIRED DASHBOARD
                */
            }

            else
            {
                if(option.equals("Admin"))
                {
                    // Add details to database
                    JOptionPane.showMessageDialog(null,"Registration Successful!");
                    AdminDashboard ad = new AdminDashboard();
                    ad.setVisible(true);
                    this.setVisible(false);
                }
                else if(option.equals("Site Admin"))
                {
                    // Add details to database
                    JOptionPane.showMessageDialog(null,"Registration Successful!");
                    SiteAdminDashboard sad = new SiteAdminDashboard();
                    sad.setVisible(true);
                    this.setVisible(false);
                }
                else if(option.equals("Supplier"))
                {
                    // Add details to database
                    JOptionPane.showMessageDialog(null,"Registration Successful!");
                    SupplierDashboard sd = new SupplierDashboard();
                    sd.setVisible(true);
                    this.setVisible(false);
                }
                else if(option.equals("Customer"))
                {
                    // Add details to database
                    JOptionPane.showMessageDialog(null,"Registration Successful!");
                    ClientDashboard cd = new ClientDashboard();
                    cd.setVisible(true);
                    this.setVisible(false);
                    
                }
            }
            
        }

        else if(ae.getSource()==login_button)
        {
            this.dispose();
            try {
                LoginForm login = new LoginForm();
                login.setSize(500, 400);
                login.setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        

    }
}