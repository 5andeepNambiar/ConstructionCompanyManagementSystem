package src;
import javax.swing.*;
import java.awt.event.*;
import java.lang.Exception;


public class SupplierDashboard extends JFrame implements ActionListener {

	JPanel Supplier_window,panel_buttons;
	JButton btnLogout,btnNewOrders,btnHistory;
	JLabel image_label;


	SupplierDashboard() 
	{
		setTitle("Construction Company Management System - Supplier Dashboard");
		setLocationRelativeTo(null);
        setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 500, 400);
		Supplier_window = new JPanel();
		this.getContentPane().add(Supplier_window);
		Supplier_window.setLayout(null);

		image_label = new JLabel("");
        image_label.setIcon(new ImageIcon(this.getClass().getResource("assets/siteadmin.jpg")));
        image_label.setLayout(null);
        image_label.setBounds(2, 0, 500, 400);
        Supplier_window.add(image_label);
		
		btnLogout = new JButton("Logout");
		btnLogout.setBounds(0, 2, 111, 28);
		btnLogout.addActionListener(this);
		image_label.add(btnLogout);
		
		btnNewOrders = new JButton("New Orders");
		btnNewOrders.setBounds(112, 2, 111, 28);
		btnNewOrders.addActionListener(this);
		image_label.add(btnNewOrders);
		
		btnHistory = new JButton("Order History");
		btnHistory.setBounds(224, 2, 111, 28);
		btnHistory.addActionListener(this);
		image_label.add(btnHistory);
		
	}

	public void actionPerformed(ActionEvent ae) {

		if(ae.getSource()==btnNewOrders)
		{
			// Add New Orders 
		}
		else if(ae.getSource()==btnHistory)
		{
			// Order History
		}
		else if(ae.getSource()==btnLogout)
		{
			this.dispose();
			try 
			{
                LoginForm login = new LoginForm();
                login.setSize(500, 400);
                login.setVisible(true);
            } 
			catch (Exception e) 
			{
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
		}

	}
}
