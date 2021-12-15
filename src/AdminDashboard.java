package src;
import javax.swing.*;
import java.awt.event.*;
import java.lang.Exception;

public class AdminDashboard extends JFrame implements ActionListener{

	JPanel Admin_window;
	JButton btnApplication,btnClient,btnBuildings,btnSite,btnSupplier,btnMaterials,btnInventory,btnLogout;
	JLabel image_label;


	AdminDashboard() 
	{
		setTitle("Construction Company Management System - Admin Dashboard");
		setLocationRelativeTo(null);
        setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 847, 400);
		Admin_window = new JPanel();
		this.getContentPane().add(Admin_window);
		Admin_window.setLayout(null);
		
		image_label = new JLabel("");
        image_label.setIcon(new ImageIcon(this.getClass().getResource("assets/admin.jpg")));
        image_label.setLayout(null);
        image_label.setBounds(2, 0, 847, 400);
        Admin_window.add(image_label);

		btnApplication = new JButton("Application");
		btnApplication.addActionListener(this);
		btnApplication.setBounds(0, 0, 104, 26);
		image_label.add(btnApplication);
		
		btnClient = new JButton("Client");
		btnClient.addActionListener(this);
		btnClient.setBounds(104, 0, 104, 26);
		image_label.add(btnClient);
		
		btnBuildings = new JButton("Buildings");
		btnBuildings.addActionListener(this);
		btnBuildings.setBounds(208, 0, 104, 26);
		image_label.add(btnBuildings);
		
		btnSite = new JButton("Site");
		btnSite.addActionListener(this);
		btnSite.setBounds(312, 0, 104, 26);
		image_label.add(btnSite);
		
		btnMaterials = new JButton("Materials");
		btnMaterials.addActionListener(this);
		btnMaterials.setBounds(416, 0, 104, 26);
		image_label.add(btnMaterials);
		
		btnSupplier = new JButton("Supplier");
		btnSupplier.addActionListener(this);
		btnSupplier.setBounds(520, 0, 104, 26);
		image_label.add(btnSupplier);
		
		btnInventory = new JButton("Inventory");
		btnInventory.addActionListener(this);
		btnInventory.setBounds(624, 0, 104, 26);
		image_label.add(btnInventory);

		btnLogout = new JButton("Logout");
		btnLogout.addActionListener(this);
		btnLogout.setBounds(728, 0, 104, 26);
		image_label.add(btnLogout);

		add(Admin_window);
	
	}

	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == btnApplication)
		{
			//Application List
		}
		else if(ae.getSource() == btnClient)
		{
			//Client List
		}
		else if(ae.getSource() == btnBuildings)
		{
			//Building List
		}
		else if(ae.getSource() == btnSite)
		{
			//Site List
		}
		else if(ae.getSource() == btnMaterials)
		{
			//Material List
		}
		else if(ae.getSource() == btnSupplier)
		{
			//Supplier List
		}
		else if(ae.getSource() == btnInventory)
		{
			//Inventory List
		}

		else if(ae.getSource() == btnLogout)
		{
            this.dispose();
            try {
                LoginForm login = new LoginForm();
                login.setSize(500, 590);
                login.setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
	}
}
