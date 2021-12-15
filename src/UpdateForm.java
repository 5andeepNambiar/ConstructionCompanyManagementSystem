package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Core.Update;



public class UpdateForm extends JFrame implements ActionListener {
	JLabel update_label;
    JPanel update_window;
    JLabel role,user_id,first_name,last_name,password,email,mobile_no,city,state,pincode,image_label,logo_label;
    JTextField user_id_input,first_name_input,last_name_input,email_input,mobile_no_input,city_input,state_input,pincode_input;
    JPasswordField password_input;
    JButton btnUpdate,btnClear;
    JComboBox<String> role_select;

    UpdateForm() 
    {
        setTitle("Construction Company Management System");
        setSize(700,440);
        setLocationRelativeTo(null);
        setResizable(false);


        btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(this);
        btnClear = new JButton("Clear");
        btnClear.addActionListener(this);


        update_window = new JPanel();
        update_window.setBackground(new Color(0,0,0));
        this.getContentPane().add(update_window);
        update_window.setLayout(null);
        update_window.setBounds(0, 0, 400, 400);
        update_window.add(btnUpdate);

        String Options[] = {" ","Admin", "SiteAdmin", "Supplier", "Customer" };
        role_select = new JComboBox<String>(Options);

        image_label = new JLabel("");
        image_label.setIcon(new ImageIcon(this.getClass().getResource("assets/update.png")));
        image_label.setLayout(null);
        image_label.setBounds(0, 40, 700, 400);
        update_window.add(image_label);

        logo_label = new JLabel("");
        logo_label.setIcon(new ImageIcon(this.getClass().getResource("assets/logo.jpg")));
        logo_label.setBounds(3, 0, 50, 40);
        update_window.add(logo_label);


        role = new JLabel("Role:");
        role.setForeground(Color.black);
        first_name = new JLabel("First Name:");
        first_name.setForeground(Color.black);
        last_name = new JLabel("Last Name:");
        last_name.setForeground(Color.black);
        user_id = new JLabel("User ID:");
        user_id.setForeground(Color.black);
        email = new JLabel("Email:");
        email.setForeground(Color.black);
        password = new JLabel("Password:");
        password.setForeground(Color.black);
		mobile_no = new JLabel("Mobile No:");
        mobile_no.setForeground(Color.black);
		city = new JLabel("City:");
        city.setForeground(Color.black);
		state = new JLabel("State:");
        state.setForeground(Color.black);
        pincode = new JLabel("Pincode:");
        pincode.setForeground(Color.black);


        update_label = new JLabel("Update");
        update_label.setFont(new Font("Serif",Font.BOLD,25));
        update_label.setForeground(new Color(255,255,255));

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
        
        btnClear.setBounds(250,300,100,30);
        btnUpdate.setBounds(352,300,100,30);

        update_label.setBounds(300,3,100,35);


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
        image_label.add(btnClear);
        image_label.add(btnUpdate);
        update_window.add(update_label);

        add(update_window, BorderLayout.CENTER);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae) {
			Update cl = new Update(password_input.getText(), first_name_input.getText(), last_name_input.getText(), email_input.getText(), Integer.parseInt(mobile_no_input.getText()), city_input.getText(), state_input.getText(), Integer.parseInt(pincode_input.getText()), user_id_input.getText());
            String option = role_select.getItemAt(role_select.getSelectedIndex()); 
            if(ae.getSource()==btnUpdate) 
            {
                if (cl.update(option))
                {
                    JOptionPane.showMessageDialog(null, "Updated Successfully!");
                } 
                else 
                {
                    JOptionPane.showMessageDialog(null, "Could not Update!.");	
                }
            }
            
                else if (ae.getSource()==btnClear)
                {
                    try 
                    {

                        password_input.setText("");
                        first_name_input.setText("");
                        last_name_input.setText("");
                        email_input.setText("");
                        mobile_no_input.setText("");
                        city_input.setText("");
                        state_input.setText("");
                        pincode_input.setText("");
                        user_id_input.setText("");
                        return;
                    } 
                    catch (Exception e) 
                    {
                        System.out.println(e.getMessage());
                        return;
                    }
        
                }
            }
}
