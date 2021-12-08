import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.Exception;

public class SiteAdminDashboard extends JFrame implements ActionListener{

	JPanel SiteAdmin_window,panel_logout_welcome,panel_buttons;
	JLabel lblWelcome;
	JButton btnLogout,btnPendingOrders,btnOrderHistory,btnNewOrders;

	SiteAdminDashboard() 
	{
		setTitle("Construction Company Management System - Site_Admin Dashboard");
		setLocationRelativeTo(null);
        setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		SiteAdmin_window = new JPanel();
		this.getContentPane().add(SiteAdmin_window);
		SiteAdmin_window.setLayout(null);
		
		panel_logout_welcome = new JPanel();
		panel_logout_welcome.setBounds(0, 0, 500, 35);
		panel_logout_welcome.setBackground(new Color(244, 164, 96));
		SiteAdmin_window.add(panel_logout_welcome);
		panel_logout_welcome.setLayout(null);
		
		btnLogout = new JButton("Logout");
		btnLogout.setBounds(5, 5, 80, 25);
		btnLogout.addActionListener(this);
		panel_logout_welcome.add(btnLogout);

		lblWelcome = new JLabel("Welcome, Site Admin");
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWelcome.setBounds(150, 7, 180, 25);
		panel_logout_welcome.add(lblWelcome);
		
		panel_buttons = new JPanel();
		panel_buttons.setBounds(0, 39, 509, 138);
		SiteAdmin_window.add(panel_buttons);
		panel_buttons.setLayout(null);
		
		btnPendingOrders = new JButton("Pending Orders");
		btnPendingOrders.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPendingOrders.setBounds(0, 0, 128, 29);
		btnPendingOrders.addActionListener(this);
		panel_buttons.add(btnPendingOrders);
		
		btnOrderHistory = new JButton("Order History");
		btnOrderHistory.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnOrderHistory.setBounds(130, 0, 128, 29);
		btnOrderHistory.addActionListener(this);
		panel_buttons.add(btnOrderHistory);
		
		btnNewOrders = new JButton("New Order");
		btnNewOrders.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewOrders.setBounds(260, 0, 128, 29);
		btnNewOrders.addActionListener(this);
		panel_buttons.add(btnNewOrders);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==btnPendingOrders)
		{
			// Display pending orders
		}
		else if(ae.getSource()==btnOrderHistory)
		{
			// Display order history
		}
		else if(ae.getSource()==btnNewOrders)
		{
			// Display new orders
		}
		else if(ae.getSource() == btnLogout)
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
