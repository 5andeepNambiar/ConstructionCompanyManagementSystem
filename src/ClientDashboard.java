package src;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

import Core.Building;

public class ClientDashboard extends JFrame implements ActionListener {


	JPanel Client_window,panel_logout_welcome,panel_buttons;
	String Username;
	JLabel lblWelcome,image_label,logo_label;
	JButton btnLogout, btnMyBuildings,btnUpdate;
	JTable table;


	ClientDashboard(String Username)
	{
		this.Username = Username;
		setSize(700,540);
		setTitle("Construction Company Management System - Client Dashboard");
		setLocationRelativeTo(null);
        setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 540);
		Client_window = new JPanel();
		this.getContentPane().add(Client_window);
		Client_window.setLayout(null);

		panel_logout_welcome = new JPanel();
		panel_logout_welcome.setBounds(0, 0, 700, 40);
		panel_logout_welcome.setBackground(new Color(0,0,0));
		Client_window.add(panel_logout_welcome);
		panel_logout_welcome.setLayout(null);

		image_label = new JLabel("");
        image_label.setIcon(new ImageIcon(this.getClass().getResource("assets/dashboard.jpg")));
        image_label.setLayout(null);
        image_label.setBounds(0, 40, 700, 500);
        Client_window.add(image_label);

		logo_label = new JLabel("");
        logo_label.setIcon(new ImageIcon(this.getClass().getResource("assets/logo.jpg")));
        logo_label.setBounds(5, 1, 50, 40);
        panel_logout_welcome.add(logo_label);

		btnLogout = new JButton("Logout");
		btnLogout.setBounds(600, 7, 80, 25);
		btnLogout.addActionListener(this);
		panel_logout_welcome.add(btnLogout);

		lblWelcome = new JLabel("Welcome " + this.Username);
		lblWelcome.setForeground(new Color(250,235,215));
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWelcome.setBounds(250, 6, 180, 25);
		panel_logout_welcome.add(lblWelcome);

		panel_buttons = new JPanel();
		panel_buttons.setBounds(0, 39, 700, 500);
		Client_window.add(panel_buttons);
		panel_buttons.setLayout(null);
		
		btnMyBuildings = new JButton("My Buildings");
		btnMyBuildings.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnMyBuildings.setBounds(3, 3, 110, 30);
		btnMyBuildings.setForeground(new Color(0,0,0));
		btnMyBuildings.addActionListener(this);
		image_label.add(btnMyBuildings);

		btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnUpdate.setBounds(115, 3, 100, 30);
		btnUpdate.setForeground(new Color(0,0,0));
		btnUpdate.addActionListener(this);
		image_label.add(btnUpdate);

	}

	

	public void actionPerformed(ActionEvent ae) {

		if(ae.getSource()==btnMyBuildings)
		{
			DefaultTableModel model = new DefaultTableModel(); 
			JTable table = new JTable(model); 
			JScrollPane scroller = new JScrollPane(table);
			scroller.setBounds(0, 40, 700, 500);
			
				   String [] col= {"Building ID","Building Name", "Building Type" , "Year of Construction" , "Site Name", "Location" };
				   model.setColumnIdentifiers(col);
				   table.setModel(model);
				   image_label.add(scroller);

				   ArrayList<Building> buildings = new Building().getBuildingsOwned(this.Username);
				   for(Building building : buildings)
				   {
				   		Object[] objs = {building.BuildingId, building.BuildingName, building.BuildingType, building.ConstructionYear, building.SiteName, building.SiteLocation};
				   		model.addRow(objs);
				   }
				   panel_buttons.add(scroller);
		} 

		else if(ae.getSource()==btnLogout)
		{
			this.dispose();
			try {
                LoginForm login = new LoginForm();
                login.setSize(500, 500);
                login.setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
		}

		else if (ae.getSource()==btnUpdate)
		{
			UpdateForm update = new UpdateForm();
			update.setVisible(true);
		}
	}

	public static void main(String[] args)
	{
		ClientDashboard client = new ClientDashboard("");
		client.setVisible(true);
	}
} 