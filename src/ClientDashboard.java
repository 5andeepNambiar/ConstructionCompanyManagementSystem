import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;


public class ClientDashboard extends JFrame implements ActionListener {


	JPanel Client_window,panel_logout_welcome,panel_buttons;
	JLabel lblWelcome;
	JButton btnLogout, btnMyBuildings;

	ClientDashboard()
	{
		setTitle("Construction Company Management System - Client Dashboard");
		setLocationRelativeTo(null);
        setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		Client_window = new JPanel();
		this.getContentPane().add(Client_window);
		Client_window.setLayout(null);

		panel_logout_welcome = new JPanel();
		panel_logout_welcome.setBounds(0, 0, 500, 35);
		panel_logout_welcome.setBackground(new Color(244, 164, 96));
		Client_window.add(panel_logout_welcome);
		panel_logout_welcome.setLayout(null);

		btnLogout = new JButton("Logout");
		btnLogout.setBounds(5, 5, 80, 25);
		btnLogout.addActionListener(this);
		panel_logout_welcome.add(btnLogout);

		lblWelcome = new JLabel("Welcome, Customer");
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWelcome.setBounds(150, 7, 180, 25);
		panel_logout_welcome.add(lblWelcome);

		panel_buttons = new JPanel();
		panel_buttons.setBounds(0, 39, 509, 138);
		Client_window.add(panel_buttons);
		panel_buttons.setLayout(null);
		
		btnMyBuildings = new JButton("My Buildings");
		btnMyBuildings.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnMyBuildings.setBounds(0, 0, 120, 29);
		btnMyBuildings.addActionListener(this);
		panel_buttons.add(btnMyBuildings);
	}

	public void actionPerformed(ActionEvent ae) {

		if(ae.getSource()==btnMyBuildings)
		{
			// Display building details
		} 

		else if(ae.getSource()==btnLogout)
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
