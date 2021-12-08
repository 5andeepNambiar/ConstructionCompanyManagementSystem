import javax.swing.*;
import java.awt.event.*;
import java.lang.Exception;

public class SupplierDashboard extends JFrame implements ActionListener {

	JPanel Supplier_window,panel_buttons;
	JButton btnLogout,btnNewOrders,btnHistory;

	SupplierDashboard() 
	{
		setTitle("Construction Company Management System - Supplier Dashboard");
		setLocationRelativeTo(null);
        setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 350);
		Supplier_window = new JPanel();
		this.getContentPane().add(Supplier_window);
		Supplier_window.setLayout(null);
		
		btnLogout = new JButton("Logout");
		btnLogout.setBounds(0, 2, 111, 28);
		btnLogout.addActionListener(this);
		Supplier_window.add(btnLogout);
		
		btnNewOrders = new JButton("New Orders");
		btnNewOrders.setBounds(112, 2, 111, 28);
		btnNewOrders.addActionListener(this);
		Supplier_window.add(btnNewOrders);
		
		btnHistory = new JButton("Order History");
		btnHistory.setBounds(224, 2, 111, 28);
		btnHistory.addActionListener(this);
		Supplier_window.add(btnHistory);
		
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
